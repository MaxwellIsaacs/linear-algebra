@echo off
echo Compiling...

javac *.java

if %error_level% == 0 (
  echo Compilation successful, running the program
  java Main
) else (
  echo Shit failed
)
