#include <jni.h>
#include <string>
#include "Test.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ndk_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    Test test;
    std::string hello = "Hello from C++" + test.GetTest();
    return env->NewStringUTF(hello.c_str());
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ndk_MainActivity_getJNI(
        JNIEnv *env,
        jobject /* this */) {

    Test test;
    std::string hello = "Hello from JNI" + test.GetTest();
    return env->NewStringUTF(hello.c_str());
}

/*
 * Class:     com_example_ndk_MainActivity
 * Method:    setJNI
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ndk_MainActivity_setJNI
        (JNIEnv *env, jobject, jstring name) {

    const char *str;
    str = env->GetStringUTFChars(name, NULL);
    if (!str) {
        return NULL;
    }

    std::string hello = std::string(str) + std::string("SET JNI");
    // 释放
    env->ReleaseStringChars(name, reinterpret_cast<const jchar *>(str));

    return env->NewStringUTF(hello.c_str());
}

/*
 * Class:     com_example_ndk_MainActivity
 * Method:    staticFromJNI
 * Signature: ()Ljava/lang/String;
 */
extern "C" JNIEXPORT jstring
JNICALL Java_com_example_ndk_MainActivity_staticFromJNI
        (JNIEnv *env, jclass) {
    std::string hello = std::string("static hello from C++");
    return env->NewStringUTF(hello.c_str());
}
