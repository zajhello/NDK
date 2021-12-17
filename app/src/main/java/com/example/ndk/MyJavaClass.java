package com.example.ndk;

public class MyJavaClass {
    private static String resultFromC = "";
    private static String resultFromC2 = "";

    public static String getResultFromC2() {
        return resultFromC2;
    }

    public void setResultFromC2(String resultFromC2) {
        this.resultFromC2 = resultFromC2;
    }

    public static String getResultFromC() {
        return resultFromC;
    }

    public static void setResultFromC(String resultFromC) {
        MyJavaClass.resultFromC = resultFromC;
    }


    private static void callStaticMethod(String str, int i) {
        resultFromC = str + "====" + i;
        System.out.format("ClassMethod::callStaticMethod called!-->str=%s,"
                + " i=%d\n", str, i);
    }


    private void callInstanceMethod(String str, int i) {
        resultFromC2 = str + "====" + i;
        System.out.format("ClassMethod::callInstanceMethod called!-->str=%s, "
                + "i=%d\n", str, i);
    }

}