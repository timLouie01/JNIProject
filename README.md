
# JNI Program Setup
## 1) Docker Container Setup
docker-compose up -d
## 2) JDK install
docker exec -it jni_project /bin/bash
- Run the comand /bin/bash in the container jni_project
- -i option: stands for interactive and tells Docker to keep the standard input stream open
- -t option:  stands for "tty" and allocates a pseudo-TTY (teletypewriter) for the container. A pseudo-TTY is a software emulation of a physical terminal

apt-get install -y openjdk-11-jdk
- Install the OpenJDK 11 JDK in the contianer to helps us compile and run Java applications
apt-get install build-essential
- Install the collection of tools included in build-essential which includes g++

g++ -c -fPIC -I/usr/lib/jvm/java-11-openjdk-arm64/include -
I/usr/lib/jvm/java-11-openjdk-arm64/include/linux JNITesting.cpp -o JNITesting.o
- Compile the native c++ code JNITesting.cpp into an object file JNITesting.o

g++ -shared -fPIC -o libnative.so JNITesting.o -lc
- Create a shared libarary from an object file

java -cp . -Djava.library.path=. JNITesting
- Run the Java class JNITesting 
- -cp . = Sets the class path to the current directory so that Java can find the compiled Java calsses
- -Djava.library.path=. = Sets the java.library.path system property to the current working directory so that Java can find the share library libnative.so
- JNITesting = java class to run
