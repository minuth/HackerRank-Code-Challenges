package com.minuth.hackerrank.codechallenges;


public class Main {

    public static void main(String[] args) {
        //MyRegex.printRegex("[a-zA-Z][\\w]{7,29}","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        try {
            foo("16 00 00");
            foo("16 1 16");
            foo("16 2 20");
            foo("18 33 9");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void foo(String value) throws Exception {
        String []rawData = value.split(" ");
        if(rawData.length < 3){
            throw new Exception("Invalid data!!!");
        }
        int h = Integer.parseInt(rawData[0]);
        int m = Integer.parseInt(rawData[1]);
        int s = Integer.parseInt(rawData[2]);

        if(!(h >= 16 && h <= 17) || (h >= 17 && (m > 0 || s > 0))){
            System.out.println("No information");
        }
        else {

            if((m % 2 == 0 && s > 15)||(m % 2 != 0 && s < 15)){
                System.out.println("working out");
            }
            else {
                System.out.println("resting");
            }
        }
    }

}
