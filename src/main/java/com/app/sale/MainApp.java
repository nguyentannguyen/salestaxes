package com.app.sale;

import com.app.sale.command.CommandFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CommandFactory commandFactory = context.getBean(CommandFactory.class);

        System.out.println("======================================");
        System.out.println("Enter for instruction");
        Scanner sc = new Scanner(System.in);
        String input;
        while(!(input=sc.nextLine().trim()).equals("exit")){
            System.out.println(commandFactory.createCommand(input).execute());
        }
    }
}
