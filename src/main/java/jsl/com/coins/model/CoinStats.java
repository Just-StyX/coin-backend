package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinStats {
    private float total;
    private float referenceCurrencyRate;
    private float totalCoins;
    private float totalMarkets;
    private float totalExchanges;
    private String totalMarketCap;
    private String total24hVolume;
    private float btcDominance;
    private List<CoinInfo> bestCoins = new ArrayList<>();
    private List<CoinInfo> newestCoins = new ArrayList<>();

    @Override
    public String toString() {
        return "CoinStats{" +
                "total=" + total +
                ", referenceCurrencyRate=" + referenceCurrencyRate +
                ", totalCoins=" + totalCoins +
                ", totalMarkets=" + totalMarkets +
                ", totalExchanges=" + totalExchanges +
                ", totalMarketCap='" + totalMarketCap + '\'' +
                ", total24hVolume='" + total24hVolume + '\'' +
                ", btcDominance=" + btcDominance +
                ", bestCoins=" + bestCoins +
                ", newestCoins=" + newestCoins +
                '}';
    }
}
