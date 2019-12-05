package com.wjp.service.enumcode.enumservice.impl;

import com.wjp.common.Result;
import com.wjp.service.enumcode.EnumCode;
import com.wjp.service.enumcode.EnumCodeDao;
import com.wjp.service.enumcode.enumservice.EnumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjp
 * @date 2019/11/12 16:59
 */
@Service
public class EnumServiceImpl implements EnumService {
    @Resource
    private EnumCodeDao enumCodeDao;

    @Override
    public Result getEnumList(String type) {
        List<EnumCode> enumCodeList = enumCodeDao.getEnumList(type);
        return Result.successResult(enumCodeList);
    }

}
