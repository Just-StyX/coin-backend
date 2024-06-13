package jsl.com.coins.controller;

import jsl.com.coins.model.CoinInfo;
import jsl.com.coins.model.HistoryData;
import jsl.com.coins.repository.CoinRepository;
import jsl.com.coins.service.BitCoinsSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/coins")
public class RankingCoinsController {
    private final CoinRepository coinRepository;
    private final BitCoinsSeriesService bitCoinsSeriesService;

    public RankingCoinsController(CoinRepository coinRepository, BitCoinsSeriesService bitCoinsSeriesService) {
        this.coinRepository = coinRepository;
        this.bitCoinsSeriesService = bitCoinsSeriesService;
    }

    @GetMapping
    private ResponseEntity<List<CoinInfo>> fetchCoinInfo() {
        return ResponseEntity.ok().body(coinRepository.findAll().getFirst().getData().getCoins());
    }

    @GetMapping("/{symbol}/{timePeriod}")
    public ResponseEntity<List<HistoryData>> fetchTimeHistoryPerTimePeriod(
            @PathVariable String symbol, @PathVariable String timePeriod) {
        return ResponseEntity.ok().body(bitCoinsSeriesService.findBySymbol(symbol, timePeriod));
    }
}
