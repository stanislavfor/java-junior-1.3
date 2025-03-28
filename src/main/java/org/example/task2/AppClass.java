package org.example.task2;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class AppClass {
    public static void main(String[] args) {
        // УНастройка кодировки по умолчанию на UTF-8
        System.setProperty("file.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        MainClass mainClass = new MainClass(scanner, System.out);
        mainClass.start();
    }
}