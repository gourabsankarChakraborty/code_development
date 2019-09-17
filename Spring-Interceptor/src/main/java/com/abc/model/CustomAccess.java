package com.abc.model;

import org.springframework.validation.annotation.Validated;

import com.abc.AccessControl;

@Validated
public class CustomAccess {

	@AccessControl
	private boolean hasAccess;

	public boolean getHasAccess() {
		return hasAccess;
	}
	public void setHasAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}

}
