package com.example.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum InvalidRequestParameter {
	NOTHING("nothing"),
	INVALID_TYPE("invalid type"),
	WRONG("wrong"),
	EXISTS("is exists"),
	NOT_EXISTS("not exists"),
	NOT_FOUND("not found");
	@Getter
	private String name;
}
