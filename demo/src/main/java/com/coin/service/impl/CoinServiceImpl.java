package com.coin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.entity.Coin;
import com.coin.repository.CoinRepository;
import com.coin.serivce.CoinService;

@Service
public class CoinServiceImpl implements CoinService{

	@Autowired
    private CoinRepository coinRepository;
	
	@Override
	public Coin saveCoin(Coin coinTemp) {
		Coin coin = new Coin();
		coin.setCode(coinTemp.getCode());
		coin.setChineseName(coinTemp.getChineseName());
		coin.setRate(coinTemp.getRate());
		
		coin = coinRepository.save(coin);
        return coin;
	}

}
