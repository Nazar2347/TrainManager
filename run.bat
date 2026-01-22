@echo off
REM Run the Main class from the bin directory
if not exist bin (
    echo bin directory not found. Compile first by running build.bat
    exit /b 1
)

java -cp bin Main %*
