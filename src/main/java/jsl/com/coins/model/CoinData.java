package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinData {
    private CoinStats stats;
    private List<CoinInfo> coins = new ArrayList<>();



    @Override
    public String toString() {
        return "CoinData{" +
                "stats=" + stats +
                ", coins=" + coins +
                '}';
    }
}
