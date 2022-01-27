package com.coin.response;

public class CoinResponse {

	private static final long serialVersionUID = 1L;
	
	public static final String SUCCESS_CODE = "0000";
	
	public static final String PARAMS_ERROR = "9000"; //request 參數錯誤
	
	public static final String UNKNOWN_EXCEPTION = "9999"; //發生未知錯誤
	
	/** 回應代碼. */
	protected String resultCode = SUCCESS_CODE;
	
	/** 錯誤訊息. */
	protected String resultMsg = "";

	/**
	 * Instantiates a new api response.
	 */
	public CoinResponse() {
	}
	
	public CoinResponse(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setRresultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
