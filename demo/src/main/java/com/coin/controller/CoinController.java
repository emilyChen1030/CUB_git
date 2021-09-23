package com.coin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coin.entity.Coin;
import com.coin.serivce.CoinService;

import io.swagger.annotations.Api;


@Api(tags = "Todo list 相關api")	
@RestController
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService coinService;
	/*
	 * 新增
	 */
	@PostMapping(value = "/add", produces = {"applictaion/json"})
    public Coin saveBook(@RequestBody Coin coin) {
		Coin bookResponse = coinService.saveCoin(coin);
        return bookResponse;
    }
	
	
}
