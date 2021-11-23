package com.mybang.khweb.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomMateDto {
    public String title;
    public String content;
    public Long writer;

}
