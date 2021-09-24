package com.coin.serivce;

import java.util.List;

import com.coin.model.CoinBo;
import com.coin.model.CoinVo;

public interface CoinService {

	public void saveCoin(CoinBo coinBo);

	public List<CoinVo> getCoin(String code);

	public void updateCoin(CoinBo coinBo);

}
