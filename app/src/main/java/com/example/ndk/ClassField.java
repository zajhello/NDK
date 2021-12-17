package com.example.ndk;

/**
 * ClassField.java
 *
 */
public class ClassField {

    private static int num;

    private String str;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        ClassField.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}