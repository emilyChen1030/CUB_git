package com.coin.model;

import java.util.ArrayList;
import java.util.List;

import com.coin.entity.Coin;


public class CoinVo {

    private String updateTime;
    private List<Coin> coinList = new ArrayList<>();

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<Coin> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<Coin> coinList) {
		this.coinList = coinList;
	}
	
}
