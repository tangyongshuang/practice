package com.anhe.strategymode.service;

import com.anhe.strategymode.child.SayInnerCommand;
import com.anhe.strategymode.child.SwimInnerCommand;
import com.anhe.strategymode.child.WalkInnerCommand;
import com.anhe.strategymode.command.CommandEnum;
import com.anhe.strategymode.utils.SpringBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Albert.Tang on 2019/3/4 11:56 PM.
 */
@Component
public class InnerCommandContext {

    private static final Logger logger = LoggerFactory.getLogger(InnerCommandContext.class);

    @Autowired
    private SayInnerCommand sayInnerCommand;

    @Autowired
    private WalkInnerCommand walkInnerCommand;

    @Autowired
    private SwimInnerCommand swimInnerCommand;

    public InnerCommand getInstance(String msg) throws Exception {
        InnerCommand innerCommand = null;
        CommandEnum[] values = CommandEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (msg.equalsIgnoreCase(values[i].getCommand())) {
                String clazz = values[i].getInnerCommand();
                // 第一种方式，通过Class.forName(全限定名)获取这个bean，推荐
                // innerCommand = (InnerCommand) SpringBeanUtils.getBean(Class.forName(clazz));

                // 第二种方式，通过指定类名.class这种方式进行获取，这种方式的innerCommand的实现类只能有一个，否则会报错，不推荐
                // InnerCommand bean = SpringBeanUtils.getBean(InnerCommand.class);

                // 第三种方式，通过自动装配实现，这种方式的好处在于不用写工具类去获取bean，但是弊端在于要维护下面这个判断的方法，推荐
                switch (clazz) {
                    case "sayInnerCommand":
                        return sayInnerCommand;
                    case "walkInnerCommand":
                        return walkInnerCommand;
                    case "swimInnerCommand":
                        return swimInnerCommand;
                    default:
                        logger.info("没有找到合适的command！");
                }
            }
        }
        return null;
    }
}
