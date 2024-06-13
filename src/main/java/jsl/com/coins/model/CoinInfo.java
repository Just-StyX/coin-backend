package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinInfo {
    private String uuid;
    private String symbol;
    private String name;
    private String color;
    private String iconUrl;
    private String marketCap;
    private String price;
    private Integer listedAt;
    private Integer tier;
    private String change;
    private Integer rank;
    private List<String> sparkline = new ArrayList<>();
    private Boolean lowVolume;
    private String coinrankingUrl;
    private String _24hVolume;
    private String btcPrice;
    private List<String> contractAddresses = new ArrayList<>();

    @Override
    public String toString() {
        return "CoinInfo{" +
                "uuid='" + uuid + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", price='" + price + '\'' +
                ", listedAt=" + listedAt +
                ", tier=" + tier +
                ", change='" + change + '\'' +
                ", rank=" + rank +
                ", sparkline=" + sparkline +
                ", lowVolume=" + lowVolume +
                ", coinrankingUrl='" + coinrankingUrl + '\'' +
                ", _24hVolume='" + _24hVolume + '\'' +
                ", btcPrice='" + btcPrice + '\'' +
                ", contractAddresses=" + contractAddresses +
                '}';
    }
}
