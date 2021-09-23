package com.coin.serivce;

import org.springframework.stereotype.Component;

import com.coin.entity.Coin;

@Component
public interface CoinService {

	public Coin saveCoin(Coin coin);


}
