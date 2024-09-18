package com.example.pract.domain.dto.response;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS("Request completed successfully"),
    ERROR("Request failed");

    private final String description;

    ResponseCode(String description) {
        this.description = description;
    }

}
