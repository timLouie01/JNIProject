#include "JNITesting.h"
#include <jni.h>
#include <string>
#include <algorithm>

JNIEXPORT jstring JNICALL Java_JNITesting_reverseString
  (JNIEnv * env, jclass cls, jstring jstr){
    const char* cStr = env->GetStringUTFChars(jstr, NULL);
    std::string str(cStr);
    env->ReleaseStringUTFChars(jstr,cStr);
    std::reverse(str.begin(), str.end());
    return env->NewStringUTF(str.c_str());
  }