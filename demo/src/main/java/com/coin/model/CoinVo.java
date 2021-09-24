package com.coin.model;

import com.coin.entity.Coin;

public class CoinVo {

	private long id;
    private String code;
    private String chineseName;
    private Double rate;
	
    public CoinVo(Coin coin) {
    	this.id = coin.getId();
        this.code = coin.getCode();
        this.chineseName = coin.getChineseName();
        this.rate = coin.getRate();
    }

    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}
