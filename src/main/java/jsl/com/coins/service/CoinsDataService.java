package jsl.com.coins.service;

import jsl.com.coins.model.*;
import jsl.com.coins.repository.BitCoinSeriesRepository;
import jsl.com.coins.repository.CoinRepository;
import jsl.com.coins.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CoinsDataService {
    public static final String GET_COIN_API = "";
    public static final String GET_COIN_HISTORY_API = "";
    public static final String COIN_HISTORY_TIME_PERIOD_PARAM = "/history?timePeriod=";
    public static final List<String> timePeriods = List.of("24h", "7d", "30d", "3m", "1y", "3y", "5y");

    private final RestTemplate restTemplate;
    private final CoinRepository coinRepository;
    private final BitCoinSeriesRepository bitCoinSeriesRepository;

    public CoinsDataService(RestTemplate restTemplate, CoinRepository coinRepository, BitCoinSeriesRepository bitCoinSeriesRepository) {
        this.restTemplate = restTemplate;
        this.coinRepository = coinRepository;
        this.bitCoinSeriesRepository = bitCoinSeriesRepository;
    }

    public void fetchCoins() {
        log.info("Inside fetchCoins()");
        ResponseEntity<Coins> coinsEntity = restTemplate.exchange(
                GET_COIN_API,
                HttpMethod.GET,
                HttpUtils.getHttpEntity(),
                Coins.class
        );
        storeCoinsToRedisJSON(coinsEntity.getBody());
    }

    public void fetchCoinHistory() {
        log.info("Inside fetchCoinHistory()");
        List<CoinInfo> allCoins = getAllCoinsFromMongoJSON();
        allCoins.forEach(coinInfo -> {
            timePeriods.forEach(s -> {
                fetchCoinHistoryForTimePeriod(coinInfo, s);
            });
        });
    }

    private void fetchCoinHistoryForTimePeriod(CoinInfo coinInfo, String timePeriod) {
        log.info("Fetching Coin History of {} for Time Period {}", coinInfo.getName(), timePeriod);
        var url = GET_COIN_HISTORY_API + coinInfo.getUuid() + COIN_HISTORY_TIME_PERIOD_PARAM + timePeriod;
        ResponseEntity<CoinPriceHistory> coinPriceHistoryResponseEntity = restTemplate.exchange(
                url, HttpMethod.GET, HttpUtils.getHttpEntity(), CoinPriceHistory.class);

        log.info("Data Fetched From API for Coin History of {} for Time Period {}", coinInfo.getName(), timePeriod);

        storeCoinHistoryToMongoTS(Objects.requireNonNull(coinPriceHistoryResponseEntity.getBody()), coinInfo.getSymbol(), timePeriod);
    }

    private void storeCoinHistoryToMongoTS(CoinPriceHistory body, String symbol, String timePeriod) {
        List<CoinPriceHistoryExchangeRate> exchangeRates = body.getData().getHistory();
        exchangeRates.stream().filter(ch -> ch.getPrice() != null && ch.getTimestamp() != null)
                .forEach(
                        ch -> {
                            var history = new BitCoinsSeries();
                            history.setSymbol(symbol + ":" + timePeriod);
                            history.setTimestamp(Long.valueOf(ch.getTimestamp()));
                            history.setPrice(Double.valueOf(ch.getPrice()));
                            bitCoinSeriesRepository.save(history);
                        }
                );
    }

    private List<CoinInfo> getAllCoinsFromMongoJSON() {
        return coinRepository.findAll().getFirst().getData().getCoins();
    }

    private void storeCoinsToRedisJSON(Coins coins) {
        coinRepository.save(coins);
    }
}
