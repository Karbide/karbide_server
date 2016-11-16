package com.bluoh.repository;

import com.bluoh.model.Card;
import com.bluoh.model.CardIdBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CardServeRepository extends MongoRepository<Card, String>{

    List<CardIdBean> findByStatusOrderByModifiedTimeDescWeightAsc(String status);

    /*@Query("select u from User u")
      Stream<User> findAllByCustomQueryAndStream();
    */
    Stream<CardIdBean> readAllByIdNotNull();

}