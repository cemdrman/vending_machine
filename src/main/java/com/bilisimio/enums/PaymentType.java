package com.bilisimio.enums;

public enum PaymentType {

	CreditCard(""),
	Cash("");

	private String type;

	PaymentType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
