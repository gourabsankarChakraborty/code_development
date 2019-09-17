package com.abc.model;

import com.abc.AccessControl;

public class Access {
//	@AccessControl
	private String hasAccess;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String isTrue() {
		return hasAccess;
	}

	public void setTrue(String isTrue) {
		this.hasAccess = isTrue;
	}
}
