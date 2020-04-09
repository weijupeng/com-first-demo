package com.wjp.controller;

import com.wjp.service.excel.ExcelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author wjp
 * @date 2019/12/17 15:24
 */
@RestController
public class ExcelController {
    @Resource
    private ExcelService excelService;

    @RequestMapping(value="excel-down")
//获取url链接上的参数
    public @ResponseBody String dowm(HttpServletResponse response, @RequestParam("id") String id, @RequestParam("userName") String name){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name+".xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            String[] titles = { "用户id", "用户姓名", "用户密码", "用户年龄" };
            excelService.export(titles, out);
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
}