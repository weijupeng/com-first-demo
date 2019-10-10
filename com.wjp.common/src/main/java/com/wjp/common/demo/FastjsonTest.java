package com.wjp.common.demo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author weijupeng
 */
@Data
public class FastjsonTest {
    private Integer id;
    private String string;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @JSONField(serialize = false)
    private String ignore;

}
