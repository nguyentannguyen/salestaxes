package com.app.sale.command;

import java.util.Scanner;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class HelpCommand extends Command{

    private static final String INSTRUCTION_FILE_PATH = "instruction";
    private static String instruction;

    public HelpCommand(String input){
        super(input);
    }

    @Override
    public String execute() {
        if (instruction==null){
            Scanner fscaner = new Scanner(this.getClass().getClassLoader().getResourceAsStream(INSTRUCTION_FILE_PATH));
            StringBuilder str = new StringBuilder();
            while (fscaner.hasNextLine()){
                str.append(fscaner.nextLine());
                str.append(System.getProperty("line.separator"));
            }
            fscaner.close();
            instruction = str.toString();
        }

        return instruction;
    }
}
