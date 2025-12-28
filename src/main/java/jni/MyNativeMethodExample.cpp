#include "jni_MyNativeMethodExample.h"

JNIEXPORT jint JNICALL
Java_jni_MyNativeMethodExample_add(JNIEnv *, jobject, jint a, jint b) {
    return a + b;
}
