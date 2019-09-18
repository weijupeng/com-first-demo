package com.wjp.common;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author kancy
 * @version 1.0
 * @date 2019/1/30 17:47
 */
public class BaseModel implements Serializable , Cloneable {
    private static final long serialVersionUID = 8664733363777247582L;

    /**
     * 转成json格式字符串
     *
     * @return json格式字符串
     */
    public String toJson() {
        return JSON.toJSONString(this);
    }
}
