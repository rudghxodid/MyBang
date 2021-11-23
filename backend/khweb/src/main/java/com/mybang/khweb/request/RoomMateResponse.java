package com.mybang.khweb.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class RoomMateResponse<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }
}
