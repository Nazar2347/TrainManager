@echo off
REM Compile Java sources into bin directory
if not exist bin mkdir bin
javac -d bin src\Main.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)

echo Compilation succeeded.
