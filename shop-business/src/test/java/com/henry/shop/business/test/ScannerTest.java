package com.henry.shop.business.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(",");
        int [] num = new int[split.length];
        for (int i = 0;i < split.length; i++){
            num[i] = Integer.parseInt(split[i]);
        }
        for (int n : num) {
            System.out.println(n);
        }
    }
}
