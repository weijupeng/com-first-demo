package com.wjp.service.excel;

import javax.servlet.ServletOutputStream;

/**
 * @author wjp
 * @date 2019/12/17 15:27
 */
public interface ExcelService {
    void export(String[] titles, ServletOutputStream out) throws Exception;
}
