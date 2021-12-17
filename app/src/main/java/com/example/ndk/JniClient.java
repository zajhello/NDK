package com.example.ndk;

public class JniClient {


    public static  native String AddStr(String strA, String strB);

    public static  native void TestDataTypeJ2C(short s, int i, long l, float f,
                                               double d, char c, boolean z, byte b, String str,int[] array, Object obj,
                                               MyJavaClass mMyJavaClass);

    public static   native int[] sumArray(int[] javaArray);

    public static  native int[][] getArrayObjectFromC(int size);


    public static native void callJavaStaticMethod();

    public static native void callJavaInstaceMethod();

    public native static void accessInstanceField(ClassField obj);

    public native static void accessStaticField();

    public native static void callSuperInstanceMethod();
}