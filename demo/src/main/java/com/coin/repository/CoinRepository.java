package com.coin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coin.entity.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Integer>{

}
