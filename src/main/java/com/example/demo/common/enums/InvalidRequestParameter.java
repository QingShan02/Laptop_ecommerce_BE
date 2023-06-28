package com.example.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum InvalidRequestParameter{
	NOTHING("nothing"),
	INVALID_TYPE("invalid type");
	@Getter
	private String name;
}
