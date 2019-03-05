package com.anhe.strategymode.controller;

import com.anhe.strategymode.service.InnerCommandContext;
import com.anhe.strategymode.service.InnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Albert.Tang on 2019/3/5 1:47 PM.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/{msg}")
    public String process(@PathVariable(value = "msg") String msg) {
        logger.info("receive msg : {}", msg);
        try {
            InnerCommand instance = InnerCommandContext.getInstance(msg);
            instance.process(msg);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("failure : {}", e.getMessage());
        }
        return "success";
    }
}
