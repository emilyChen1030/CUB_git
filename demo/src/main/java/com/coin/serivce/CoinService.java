package com.coin.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.dao.CoinDao;
import com.coin.entity.Coin;
import com.coin.model.CoinBo;

@Service
public class CoinService {

	@Autowired
    private CoinDao coinDao;
    
    public void add(CoinBo bo) {
    	Coin entity = new Coin();
        entity.setId(bo.getId());
        entity.setCode(bo.getCoin());
        entity.setChineseName(bo.getChineseName());
        coinDao.save(entity);
    }
}
