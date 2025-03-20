package org.example.sp1.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    String getTime();

    String after100();
}
