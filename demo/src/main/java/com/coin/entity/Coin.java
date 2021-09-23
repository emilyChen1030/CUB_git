package com.coin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "coin")
public class Coin implements Serializable{

	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 	
	 	@Column(name = "code")
	    private String code;
	 	
	 	@Column(name = "chineseName")
	    private String chineseName;
	 	
	 	@Column(name = "rate")
	    private Double rate;
	 	
	 	@Column(name = "updateTime")
	    private String updateTime;
	    
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

		public Double getRate() {
			return rate;
		}

		public void setRate(Double rate) {
			this.rate = rate;
		}

		public String getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(String string) {
			this.updateTime = string;
		}
		
}
