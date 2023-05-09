package team.wbt.newzips.member.dto;

import team.wbt.newzips.common.entity.DataResponseDto;

import java.util.List;

public class UsersWithCount extends DataResponseDto {

    private int count;

    public UsersWithCount(List data) {
        super(data);
        this.count = data.size();
    }
}
