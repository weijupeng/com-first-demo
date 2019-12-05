package com.wjp.mail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wjp
 * @date 2019/12/5 13:56
 */
@RestController
public class MailController {
    @Resource
    private MailService mailService;

    @GetMapping("/mail")
    public String send() {
        mailService.sendHtmlMail("weijupeng@vcredit.com", "主题测试", "测试");
        return "success";
    }
}
