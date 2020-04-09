package com.wjp.dao.dao.mapper;


import com.wjp.dao.dao.entity.EnumCode;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface EnumCodeMapper extends SuperMapper<EnumCode> {

    int insertSelective(EnumCode record);
}