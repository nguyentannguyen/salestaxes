package com.app.sale.command;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public abstract class Command {

    protected final String input;

    Command(String input){
        this.input = input;
    }

    public abstract String execute();
}
