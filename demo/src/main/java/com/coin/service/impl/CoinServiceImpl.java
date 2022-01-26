package com.coin.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coin.entity.Coin;
import com.coin.model.CoinBo;
import com.coin.model.CoinVo;
import com.coin.repository.CoinRepository;
import com.coin.serivce.CoinService;

@Service("coinService")
public class CoinServiceImpl implements CoinService{

	@Autowired
    private CoinRepository coinRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void saveCoin(CoinBo coinBo) throws ParseException {
		Coin coin = new Coin();
		coin.setCode(coinBo.getCode());
		coin.setChineseName(coinBo.getChineseName());
		coin.setRate(coinBo.getRate());
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date current = new Date();
		Date temp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(sdFormat.format(current));
		coin.setUpdateTime(temp);
		coinRepository.save(coin);
	}

	@Override
	public List<Coin> getCoin(String code) {
		List<Coin> vo = new ArrayList<>();
		if (code == null) {
			coinRepository.findAll().forEach(vo::add);
		} else {
			coinRepository.findByCodeContaining(code).forEach(vo::add);
		}
		
		return vo;
	}

	@Override
	public void updateCoin(CoinBo coinBo) throws ParseException {
		//查詢出ID
		int id = coinRepository.findIdByCode(coinBo.getCode());
		String code = coinBo.getCode();
		String chineseName = coinBo.getChineseName();
		Double rate = coinBo.getRate();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date current = new Date();
		Date updateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(sdFormat.format(current));
		coinRepository.updateCoin(id, code, chineseName, rate, updateTime);
	}

	@Override
	public void deleteCoin(String code) {
		int id = coinRepository.findIdByCode(code);
		coinRepository.deleteById(id);
	}

	@Override
	public String showCoinDeskAPI() {
		Map<String, String> queryParams = new HashMap<>();
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		String coinDeskAPIData = restTemplate.getForObject(url, String.class, queryParams);
		return coinDeskAPIData;
	}

	@Override
	public CoinVo inputCoinDeskAPIData() throws ParseException {
		String coinDeskAPIData = showCoinDeskAPI();
		
		List<Coin> coin = new ArrayList<>();
		JSONObject coinDeskAPIObj = JSON.parseObject(coinDeskAPIData); 
		
		String time = coinDeskAPIObj.getObject("time", String.class);
		JSONObject timeObj = JSON.parseObject(time);
		String updatedISO = timeObj.getObject("updatedISO", String.class);
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dt.parse(updatedISO.substring(0,updatedISO.indexOf("T")) +" " + updatedISO.substring(updatedISO.indexOf("T") + 1 ,updatedISO.indexOf("+")));

		String bpi = coinDeskAPIObj.getObject("bpi", String.class);
		JSONObject bpiDataObj = JSON.parseObject(bpi);
		Map<String, Object> map = (Map<String, Object>)bpiDataObj;
		for(String s: map.keySet()) {
			JSONObject bpiObj = JSON.parseObject( bpiDataObj.getObject(s, String.class));
			Coin coinObject = new Coin();
			String code = bpiObj.getObject("code", String.class);
			//查中文名稱
			String chineseName = coinRepository.findChineseName(code);
			coinObject.setCode(code);
			coinObject.setChineseName(chineseName);
			coinObject.setRate(new Double(bpiObj.getObject("rate", String.class).replaceAll(",", "")));
			coin.add(coinObject);
		}
		
		CoinVo coinVo = new CoinVo();
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		coinVo.setUpdateTime(dt1.format(date));
		coinVo.setCoinList(coin);

		return coinVo;
	}

}
