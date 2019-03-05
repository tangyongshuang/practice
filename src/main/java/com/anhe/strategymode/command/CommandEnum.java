package com.anhe.strategymode.command;

/**
 * Created by Albert.Tang on 2019/3/4 11:58 PM.
 */
public enum CommandEnum {

    SAY("say", "com.anhe.strategymode.child.SayInnerCommand"),
    WALK("walk", "com.anhe.strategymode.child.WalkInnerCommand");
    private String command;
    private String innerCommand;

    CommandEnum(String command, String innerCommand) {
        this.command = command;
        this.innerCommand = innerCommand;
    }

    public String getCommand() {
        return command;
    }


    public String getInnerCommand() {
        return innerCommand;
    }



}
