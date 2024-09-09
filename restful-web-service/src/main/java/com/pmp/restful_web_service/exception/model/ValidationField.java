package com.pmp.restful_web_service.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ValidationField {

    private final String fieldName;

    private final String message;
}
