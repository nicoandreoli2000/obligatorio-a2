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
        echo -e "`Comenzando pruebas para EJERCICIO $NRO_EJERCICIO "
        # echo "Compilando..."
        if [ -f "$CPPFILE" ]; then
          echo "Realizado en C++"
          if ! g++ $CPPFILE -o $BUILD_FOLDER/ejercicio$NRO_EJERCICIO.out; then
            echo -e "ERROR en compilacion"
            continue
          fi
        else 
          echo "Realizado en JAVA"
          if ! javac $JAVAFILE -d ./; then
            echo -e "ERROR en compilacion"
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
          diff -B ${filename/in/out} ${filename/in/own} > /dev/null
          if [ $? -eq 0 ]
          then
            echo -e "${filename} - OK"
          else
            echo -e "${filename} - FAIL"
          fi
        done

        # borra todo compilado de java
        find . -name "*.class" -type f -delete
        
    else 
        echo -e "Ejericio $NRO_EJERCICIO NO REALIZADO"
    fi
    printf "\n"
    # read -p "Presione una tecla para continuar"
done

