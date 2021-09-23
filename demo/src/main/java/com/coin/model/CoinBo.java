package com.coin.model;

public class CoinBo {

    private String code;
    private String chineseName;
    private Double rate;

	public String getChineseName() {
		return chineseName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("code:" + code + ",");
        sb.append("chineseName:" + chineseName + ",");
        sb.append("rate:" + rate);
        return sb.toString();
    }
}
