package com.coin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.entity.Coin;
import com.coin.model.CoinBo;
import com.coin.model.CoinVo;
import com.coin.repository.CoinRepository;
import com.coin.serivce.CoinService;

@Service("coinService")
public class CoinServiceImpl implements CoinService{

	@Autowired
    private CoinRepository coinRepository;
	
	@Override
	public void saveCoin(CoinBo coinBo) {
		Coin coin = new Coin();
		coin.setCode(coinBo.getCode());
		coin.setChineseName(coinBo.getChineseName());
		coin.setRate(coinBo.getRate());
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date current = new Date();
		coin.setUpdateTime(sdFormat.format(current));
		coinRepository.save(coin);
	}

	@Override
	public List<CoinVo> getCoin(String code) {
		return coinRepository.getCode(code);
	}

	@Override
	public void updateCoin(CoinBo coinBo) {
		//查詢出ID
		int id = coinRepository.findIdByCode(coinBo.getCode());
		String code = coinBo.getCode();
		String chineseName = coinBo.getChineseName();
		Double rate = coinBo.getRate();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date current = new Date();
		String date = sdFormat.format(current);
		coinRepository.updateCoin(id, code, chineseName, rate, date);
	}

}
