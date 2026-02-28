package com.dk;

public class StringAlgo {

    /**
     * @param s : not null string of length >= 2
     * @return returns first 2 chars shifted to last of the string
     * @throws NullPointerException if input is null
     * @throws IllegalArgumentException if length < 2
     */
    public String shift2Char(String s) {

        if (s == null)
            throw new NullPointerException("Input cannot be null");

        if (s.length() < 2)
            throw new IllegalArgumentException("String length must be at least 2");

        return s.substring(2) + s.substring(0, 2);
    }

    public String getFromDB() {

        try {
            System.out.println("Sleep for 2000");
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "From db value received";
    }

    public static void main(String[] args) {
        StringAlgo obj = new StringAlgo();
        System.out.println(obj.shift2Char("Hello"));
    }
}