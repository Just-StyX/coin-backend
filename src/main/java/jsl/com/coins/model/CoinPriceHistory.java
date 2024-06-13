package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@RequiredArgsConstructor
public class CoinPriceHistory {
    private ObjectId id;
    private String status;
    private CoinPriceHistoryData data;

    @Override
    public String toString() {
        return "CoinPriceHistory{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
