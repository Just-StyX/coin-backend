package jsl.com.coins.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryData {
    private String timestamp;
    private double value;

    @Override
    public String toString() {
        return "HistoryData{" +
                "timestamp='" + timestamp + '\'' +
                ", value=" + value +
                '}';
    }
}
