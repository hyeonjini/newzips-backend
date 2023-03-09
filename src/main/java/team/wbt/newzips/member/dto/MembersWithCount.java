package team.wbt.newzips.member.dto;

import team.wbt.newzips.common.entity.DataResponseDto;

import java.util.List;

public class MembersWithCount extends DataResponseDto {

    private int count;

    public MembersWithCount(List data) {
        super(data);
        this.count = data.size();
    }
}
