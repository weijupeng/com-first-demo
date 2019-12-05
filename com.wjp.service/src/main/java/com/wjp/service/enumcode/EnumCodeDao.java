package com.wjp.service.enumcode;

import com.wjp.dao.base.SuperDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjp
 * @date 2019/11/12 16:55
 */
@Repository
public class EnumCodeDao extends SuperDao<EnumCodeMapper, EnumCode> {

    public List<EnumCode> getEnumList(String type) {
        EnumCode enumCode = EnumCode.builder().enumType(type).isDelete(0).build();
        List<EnumCode> enumList = baseMapper.getEnumList(type);
        return enumList;
    }

}
