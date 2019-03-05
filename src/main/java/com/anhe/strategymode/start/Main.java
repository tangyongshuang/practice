package com.anhe.strategymode.start;

import com.anhe.strategymode.service.InnerCommandContext;
import com.anhe.strategymode.service.InnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Albert.Tang on 2019/3/5 1:30 PM.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            String msg = "say";
            InnerCommand instance = InnerCommandContext.getInstance(msg);
            instance.process(msg);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("command error", e.getMessage());
        }
    }
}
