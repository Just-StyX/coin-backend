package jsl.com.coins.service;

import jsl.com.coins.model.HistoryData;
import jsl.com.coins.repository.BitCoinSeriesRepository;
import jsl.com.coins.utils.Utility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitCoinsSeriesService {
    private final BitCoinSeriesRepository bitCoinSeriesRepository;

    public BitCoinsSeriesService(BitCoinSeriesRepository bitCoinSeriesRepository) {
        this.bitCoinSeriesRepository = bitCoinSeriesRepository;
    }

    public List<HistoryData> findBySymbol(String symbol, String timePeriod) {
        var bitcoins = bitCoinSeriesRepository.findBySymbol(symbol + ":" + timePeriod);

        return bitcoins.stream()
                .map(bitCoinsSeries -> new HistoryData(
                        Utility.convertUnixTimeToDate(bitCoinsSeries.getTimestamp()),
                        Utility.round(bitCoinsSeries.getPrice(), 2)
                )).toList();
    }
}
