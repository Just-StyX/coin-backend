package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinPriceHistoryData {
    private String change;
    private List<CoinPriceHistoryExchangeRate> history = new ArrayList<> ();

    @Override
    public String toString() {
        return "CoinPriceHistoryData{" +
                "change='" + change + '\'' +
                ", history=" + history +
                '}';
    }
}
