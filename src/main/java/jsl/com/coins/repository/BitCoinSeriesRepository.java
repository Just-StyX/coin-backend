package jsl.com.coins.repository;

import jsl.com.coins.model.BitCoinsSeries;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BitCoinSeriesRepository extends MongoRepository<BitCoinsSeries, ObjectId> {
    List<BitCoinsSeries> findBySymbol(String symbol);
}
