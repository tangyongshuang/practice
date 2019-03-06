package com.anhe.strategymode.child;

import com.anhe.strategymode.service.InnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Albert.Tang on 2019/3/6 10:11 AM.
 */
@Component
public class SwimInnerCommand implements InnerCommand {

    private static final Logger logger = LoggerFactory.getLogger(SwimInnerCommand.class);

    @Override
    public void process(String msg) {
        logger.info("msg is : {} ,he is swimming ~~~", msg);
    }
}
