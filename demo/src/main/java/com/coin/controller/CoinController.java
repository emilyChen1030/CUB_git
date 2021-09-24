package com.coin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coin.entity.Coin;
import com.coin.model.CoinBo;
import com.coin.model.CoinVo;
import com.coin.serivce.CoinService;


@RestController
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService coinService;
	
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//新增
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
    public void saveCoin(@RequestBody CoinBo coinBo) {
		coinService.saveCoin(coinBo);
    }
	
	//查詢
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<CoinVo> queryCoin(@RequestBody @RequestParam("code")String code) {
		List<CoinVo> coinVo = coinService.getCoin(code);
		return coinVo;
    }
	
	//修改
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public void updateCoin(@RequestBody CoinBo coinBo) {
		coinService.updateCoin(coinBo);
	}
	
}
