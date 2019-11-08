package com.wjp.dao.system;

import com.wjp.dao.base.SuperDao;
import com.wjp.dao.entity.SysConfig;
import com.wjp.dao.mapper.SysConfigMapper;
import org.springframework.stereotype.Repository;

/**
 * @author wjp
 * @date 2019/11/1 11:11
 */
@Repository
public class SysConfigDao extends SuperDao<SysConfigMapper, SysConfig> {
    public SysConfig getSysConfigById(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }
}
