package com.coin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coin.entity.Coin;

@Repository
public interface CoinDao extends CrudRepository<Coin, Long>{

}
