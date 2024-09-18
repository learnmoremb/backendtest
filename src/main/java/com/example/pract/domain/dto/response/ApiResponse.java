package com.example.pract.domain.dto.response;

public record ApiResponse<T>(
        Boolean successful,
        ResponseCode narration,
        int status,
        T body
) {
}
