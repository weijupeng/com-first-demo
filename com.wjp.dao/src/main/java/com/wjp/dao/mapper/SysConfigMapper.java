package com.wjp.dao.mapper;

import com.wjp.dao.entity.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wjp
 * @date 2019/11/1 11:12
 */
@Mapper
public interface SysConfigMapper extends SupperMapper<SysConfig> {
    /**
     * 根据主键查询
     *
     * @param id ID
     * @return SysConfig
     */
    SysConfig selectByPrimaryKey(@Param("id") Long id);


}
