package jsl.com.coins.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.TimeSeries;
import org.springframework.data.mongodb.core.timeseries.Granularity;

@Getter
@Setter
@RequiredArgsConstructor
@TimeSeries(
        timeField = "timestamp",
        granularity = Granularity.SECONDS,
        metaField = "deviceId")
public class BitCoinsSeries {
    private ObjectId id;
    private Long timestamp;
    private Double price;
    private String symbol;

}
