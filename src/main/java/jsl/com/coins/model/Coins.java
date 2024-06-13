package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@RequiredArgsConstructor
public class Coins {
    private ObjectId id;
    private String status;
    private CoinData data;

    @Override
    public String toString() {
        return "Coins{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
