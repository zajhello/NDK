//
// Created by zajhe on 2021/12/19.
//

#include <jni.h>
#include <string>



/*
 * Class:     com_example_ndk_MainActivity
 * Method:    staticFromTwo
 * Signature: ()Ljava/lang/String;
 */
extern "C" JNIEXPORT jstring
JNICALL Java_com_example_ndk_MainActivity_staticFromTwo
        (JNIEnv *env, jclass) {
    std::string hello = std::string("static hello from two C++");
    return env->NewStringUTF(hello.c_str());
}
