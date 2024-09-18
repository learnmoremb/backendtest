package com.example.pract.dto.response;

import com.example.pract.domain.models.Item;

import java.util.List;

public class ResponseDTO {

    private List<Item> list;
    private boolean success;

    // Getters and Setters
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

