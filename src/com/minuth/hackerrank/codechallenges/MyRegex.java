package com.minuth.hackerrank.codechallenges;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static final String IP_VALIDATION_PATTERN = "(([0-9]|[0-9]{2}|[01][0-9][0-9]|2[0-4][0-9]|25[0-5]))\\." +
            "(([0-9]|[0-9]{2}|[01][0-9][0-9]|2[0-4][0-9]|25[0-5]))\\." +
            "(([0-9]|[0-9]{2}|[01][0-9][0-9]|2[0-4][0-9]|25[0-5]))\\." +
            "(([0-9]|[0-9]{2}|[01][0-9][0-9]|2[0-4][0-9]|25[0-5]))";

    public static final String USER_NAME_VALIDATION_PATTERN = "[a-zA-Z][\\w]{7,29}"; // start with alphabet range(8-30)


    static void printRegex(String pattern, String value){
        System.out.println(value.matches(pattern));
    }
    static void foundMatchString(String pattern, String value){
        System.out.println(String.format("Value: %s, total length: %d",value, value.length()));
        Matcher matcher = getMatcher(pattern,value,true);
        while (matcher.find()){
            System.out.println(String.format("Found [ start at %d [%c] end at %d [%c]", matcher.start(), value.charAt(matcher.start()), matcher.end()-1, value.charAt(matcher.end()-1)));
        }
    }
    static Matcher getMatcher(String pattern, String value, boolean isCaseInsensitive){
        Pattern patternCompiler = Pattern.compile(pattern,isCaseInsensitive?Pattern.CASE_INSENSITIVE: 0);
        return patternCompiler.matcher(value);
    }
    static void removeDuplicateWords(){

        String regex = "(\\b\\w+)(\\s+\\1\\b)+";

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = getMatcher(regex,input,true);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(),m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }

    public static void main(String[] args) {
        removeDuplicateWords();
    }

}
