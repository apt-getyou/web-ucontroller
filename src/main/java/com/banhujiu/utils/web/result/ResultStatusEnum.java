package com.banhujiu.utils.web.result;

/**
 * @author banhujiu
 * @date 2018/5/24 0024 11:10
 */
public enum ResultStatusEnum {
	OK(1, "OK"),
	ERROR(2, "ERROR"),
	Unauthorized(3, "Unauthorized"),;

	private int val;
	private String msg;

	ResultStatusEnum(int val, String msg) {
		this.val = val;
		this.msg = msg;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
