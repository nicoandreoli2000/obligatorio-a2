#!/bin/bash

#set -x
BUILD_FOLDER=./build
STUDENT_FOLDER=.

rm -dr $BUILD_FOLDER
mkdir "$BUILD_FOLDER" 

for NRO_EJERCICIO in {1..13}
do
    TEST_FOLDER=./pruebas/ejercicio$NRO_EJERCICIO
    JAVAFILE=$STUDENT_FOLDER/Ejercicio$NRO_EJERCICIO.java
    CPPFILE=$STUDENT_FOLDER/ejercicio$NRO_EJERCICIO.cpp

    if [ -f "$JAVAFILE" ] || [ -f "$CPPFILE" ]; then
        echo -e "\e[1;36m Comenzando pruebas para EJERCICIO $NRO_EJERCICIO \e[0m"
        # echo "Compilando..."
        if [ -f "$CPPFILE" ]; then
          echo "Realizado en C++"
          if ! g++ $CPPFILE -o $BUILD_FOLDER/ejercicio$NRO_EJERCICIO.out; then
            echo -e "\e[31mERROR en compilacion\e[0m"
            continue
          fi
        else 
          echo "Realizado en JAVA"
          if ! javac $JAVAFILE -d ./; then
            echo -e "\e[31mERROR en compilacion\e[0m"
            continue
          fi
        fi
        # echo "Compilado terminado"

        # borrando resultados anteriores
        find $TEST_FOLDER -name "*.own.txt" -type f -delete

        # echo "Empezando las pruebas"
        du $TEST_FOLDER/*.in.txt | sort -g |
        while read filesize filename; do
          T="$(date +%s)"
          if [ -f "$CPPFILE" ]; then
            $BUILD_FOLDER/ejercicio$NRO_EJERCICIO.out < $filename > ${filename/in/own}
          else 
            java Ejercicio$NRO_EJERCICIO < $filename > ${filename/in/own}
          fi
          T="$(($(date +%s)-T))"
          echo "$NRO_EJERCICIO : $filename : $T segundos"
          diff -Z -B ${filename/in/out} ${filename/in/own} > /dev/null
          if [ $? -eq 0 ]
          then
            echo -e "\e[32m${filename} - OK\e[0m"
          else
            echo -e "\e[31m${filename} - FAIL\e[0m"
          fi
        done

        # borra todo compilado de java
        find . -name "*.class" -type f -delete
        
    else 
        echo -e "\e[31mEjericio $NRO_EJERCICIO NO REALIZADO\e[0m"
    fi
    printf "\n"
    # read -p "Presione una tecla para continuar"
done

