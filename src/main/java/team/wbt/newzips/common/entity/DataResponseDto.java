package team.wbt.newzips.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DataResponseDto<T> {
    private T data;
}
