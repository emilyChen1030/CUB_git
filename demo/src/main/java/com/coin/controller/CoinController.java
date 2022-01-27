package com.coin.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coin.entity.Coin;
import com.coin.model.CoinBo;
import com.coin.model.CoinVo;
import com.coin.repository.CoinRepository;
import com.coin.response.CoinResponse;
import com.coin.serivce.CoinService;


@RestController
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService coinService; 
	
	@Autowired
    private CoinRepository coinRepository;
	
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//新增
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody CoinResponse saveCoin(@RequestBody CoinBo coinBo) throws ParseException {
		String errMsg = validRequest(coinBo.getCode());
		if(!errMsg.equals("")) {
			CoinResponse response = new CoinResponse(CoinResponse.PARAMS_ERROR, errMsg);
			return response;
		}else {
			coinService.saveCoin(coinBo);
			CoinResponse response = new CoinResponse(); //default success
			return response;
			
		}
		
    }
	
	//查詢
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<Coin> queryCoin(@RequestParam(value ="code", required=false)String code) {
		List<Coin> coinVo = coinService.getCoin(code);
		return coinVo;
    }
	
	//修改
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody CoinResponse updateCoin(@RequestBody CoinBo coinBo) throws ParseException {
		String errMsg = validRequestUpdate(coinBo.getCode());
		if(!errMsg.equals("")) {
			CoinResponse response = new CoinResponse(CoinResponse.PARAMS_ERROR, errMsg);
			return response;
		}else {
			coinService.updateCoin(coinBo);
			CoinResponse response = new CoinResponse(); //default success
			return response;
		}
	}
	
	//刪除
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public @ResponseBody CoinResponse deleteCoin(@RequestBody CoinBo coinBo) {
		String errMsg = validRequestUpdate(coinBo.getCode());
		if(!errMsg.equals("")) {
			CoinResponse response = new CoinResponse(CoinResponse.PARAMS_ERROR, errMsg);
			return response;
		}else {
			coinService.deleteCoin(coinBo.getCode());
			CoinResponse response = new CoinResponse(); //default success
			return response;
		}
		
	}
	
	//呼叫coindesk API
	@RequestMapping(value = "/queryCoinDesk", method = RequestMethod.GET)
	public String showCoinDeskAPI() {
		String coinDeskAPIData = coinService.showCoinDeskAPI();
		if(coinDeskAPIData != null) {
	        return coinDeskAPIData;
	    } else {
	        return "";
	    }
	}
	
	//測試呼叫資料轉換的API
	@RequestMapping(value = "/queryChangeCoinDesk", method = RequestMethod.GET)
	public CoinVo inputCoinDeskAPIData() throws ParseException {
		CoinVo coinVo =coinService.inputCoinDeskAPIData();
		return coinVo;
	}
	
	
	private String validRequest(String code) {
		String chineseName = coinRepository.findChineseName(code);
		if(chineseName == null) {
			return "";
		}
		return "data have code : " + code;
	}
	
	private String validRequestUpdate(String code) {
		String chineseName = coinRepository.findChineseName(code);
		if(chineseName == null) {
			return "data not find : " + code;
		}
		return "";
	}

}
