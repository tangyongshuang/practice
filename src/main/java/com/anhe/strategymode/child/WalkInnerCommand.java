package com.anhe.strategymode.child;

import com.anhe.strategymode.service.InnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Albert.Tang on 2019/3/5 2:02 PM.
 */
@Service
public class WalkInnerCommand implements InnerCommand {
    private static final Logger logger = LoggerFactory.getLogger(WalkInnerCommand.class);

    @Override
    public void process(String msg) {
        logger.info("I'm walking! the command is {}", msg);
    }
}
