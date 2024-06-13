package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.BsonTimestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinPriceHistoryExchangeRate {
    private String price;
    private String timestamp;

    @Override
    public String toString() {
        return "CoinPriceHistoryExchangeRate{" +
                "price='" + price + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
