package com.yatap.board.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto<T> {
    @Builder.Default
    private String status = "success";
    private T data;
}
