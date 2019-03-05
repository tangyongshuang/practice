package com.anhe.strategymode.child;

import com.anhe.strategymode.service.InnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Albert.Tang on 2019/3/4 11:54 PM.
 */
@Service
public class SayInnerCommand implements InnerCommand {
    private static final Logger logger = LoggerFactory.getLogger(SayInnerCommand.class);

    @Override
    public void process(String msg) {
        logger.info("Hello world!!!");
    }


}
