package com.coin.serivce;

import java.text.ParseException;
import java.util.List;

import com.coin.entity.Coin;
import com.coin.model.CoinBo;
import com.coin.model.CoinVo;
import com.coin.response.CoinResponse;

public interface CoinService {

	public CoinResponse saveCoin(CoinBo coinBo) throws ParseException;

	public List<Coin> getCoin(String code);

	public void updateCoin(CoinBo coinBo) throws ParseException;

	public void deleteCoin(String code);

	public String showCoinDeskAPI();

	public CoinVo inputCoinDeskAPIData() throws ParseException;

}
