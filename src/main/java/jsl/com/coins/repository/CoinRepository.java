package jsl.com.coins.repository;

import jsl.com.coins.model.Coins;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coins, ObjectId> {
}
