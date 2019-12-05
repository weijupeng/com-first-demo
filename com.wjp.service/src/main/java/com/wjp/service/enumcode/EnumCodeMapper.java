package com.wjp.service.enumcode;

import com.wjp.dao.mapper.SupperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wjp
 * @date 2019/11/12 17:13
 */
@Mapper
public interface EnumCodeMapper extends SupperMapper<EnumCode> {




    List<EnumCode> getEnumList(@Param("type") String type);
}