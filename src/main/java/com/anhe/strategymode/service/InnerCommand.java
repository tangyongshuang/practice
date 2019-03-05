package com.anhe.strategymode.service;

/**
 * Created by Albert.Tang on 2019/3/4 11:49 PM.
 */
public interface InnerCommand {
    /**
     * 指令执行的接口方法
     * @param msg 具体指令
     */
    void process(String msg);
}
