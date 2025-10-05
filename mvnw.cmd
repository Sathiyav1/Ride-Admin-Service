@echo off
rem Apache Maven Wrapper for Windows
setlocal
set SCRIPT_DIR=%~dp0
set WRAPPER_DIR=%SCRIPT_DIR%.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
if not exist "%WRAPPER_JAR%" (
  echo Maven Wrapper jar not found. Please run mvnw from a networked environment to download it.
  exit /b 1
)
java -jar "%WRAPPER_JAR%" %*
