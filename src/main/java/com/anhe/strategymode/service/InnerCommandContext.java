package com.anhe.strategymode.service;

import com.anhe.strategymode.command.CommandEnum;
import com.anhe.strategymode.utils.SpringBeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Albert.Tang on 2019/3/4 11:56 PM.
 */
@Component
public class InnerCommandContext {


//    @Autowired
//    private static InnerCommand innerCommand;

    public static InnerCommand getInstance(String msg) throws Exception {
        InnerCommand innerCommand = null;
        CommandEnum[] values = CommandEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (msg.equalsIgnoreCase(values[i].getCommand())) {
                String clazz = values[i].getInnerCommand();
                innerCommand =(InnerCommand) SpringBeanUtils.getBean(Class.forName(clazz));
                // 这种方式的innerCommand的实现类只能有一个，否则会报错，不推荐
                // InnerCommand bean = SpringBeanUtils.getBean(InnerCommand.class);
                return innerCommand;
            }
        }
        return null;
    }
}
