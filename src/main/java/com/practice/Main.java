package com.practice;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");
        String formattedDate = formatter.format(new Date(0));
        System.out.println(formattedDate);
    }
}