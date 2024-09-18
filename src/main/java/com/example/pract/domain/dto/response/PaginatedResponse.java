package com.example.pract.domain.dto.response;

import java.util.List;

public record PaginatedResponse<T>(
        long size,
        long total,
        long pageNumber,
        List<T> data
) {
}