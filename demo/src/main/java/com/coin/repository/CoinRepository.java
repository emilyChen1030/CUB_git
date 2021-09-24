package com.coin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coin.entity.Coin;
import com.coin.model.CoinVo;

@Repository
public interface CoinRepository extends JpaRepository<Coin, String>{

	@Query(value = "SELECT c FROM Coin c WHERE c.code = :code")
	public List<CoinVo> getCode(@Param("code") String code);

	@Query(value = "SELECT c.id FROM Coin c WHERE c.code = :code")
	public int findIdByCode(@Param("code")String code);

	@Modifying
	@Query(value = "update Coin set code= :code, chineseName= :chineseName, rate= :rate where id= :id")
	public void updateCoin(@Param("id")int id, @Param("code")String code, @Param("chineseName")String chineseName, 
			@Param("rate")Double rate, @Param("time")String time);

}
