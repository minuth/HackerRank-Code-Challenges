package com.minuth.hackerrank.codechallenges;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    static void process(){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            String regex = "<(\\w+)>(.+\\s*)+</\\1>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
//                line = line.replaceAll(String.format("(<%s>|</%s>)",matcher.group(1),matcher.group(1)),"");
                System.out.println(line);
            }
            testCases--;
        }
    }

    public static void main(String[] args) {
        String dd = "(\\b\\w+)(\\s+\\1\\b)+"; // abc abc    abc
        MyRegex.foundMatchString("<(\\w+)>(.+)(</\\1>)","<h1><h1>Sanjay has no watch</h1></h1>");
//        process();
    }
}
