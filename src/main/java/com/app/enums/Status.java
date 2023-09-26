package com.app.enums;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.app.config.EnumConverter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	DELETED(0), ACTIVE(1), IN_ACTIVE(2), NOT_VERIFIED(3);

	private int value;

	private Status(int value) {
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	public static Status fromValue(int value) {
		for (Status status : Status.values()) {
			if (Objects.equals(status.getValue(), value)) {
				return status;
			}
		}
		return null;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	@Component
	public static class Converter extends EnumConverter<Status, Integer> {
		public Converter() {
			super(Status.class);
		}
	}
}
