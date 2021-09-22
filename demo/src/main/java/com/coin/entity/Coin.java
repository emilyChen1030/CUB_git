package com.coin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coin {

	 	@Id
	    private Long id;
	    private String code;
	    private String chineseName;
	    
	    
}
