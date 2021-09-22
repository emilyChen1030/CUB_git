package com.coin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coin {

	 	@Id
	    private Long id;
	    private String code;
	    private String chineseName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
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
	    
}
