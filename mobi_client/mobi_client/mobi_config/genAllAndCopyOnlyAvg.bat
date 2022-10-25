chcp 936
cd /D %~dp0
mode con lines=9999
echo off

if not exist csharp mkdir csharp
if not exist csharp\hf mkdir csharp\hf
if not exist java mkdir java
if not exist xml mkdir xml
if not exist xml\AVGScripts mkdir xml\AVGScripts
if not exist excel\AVGScripts mkdir excel\AVGScripts

if exist xml\AVGScripts\*.xml del /q xml\AVGScripts\*.xml

if exist xml\clientXml rd /s /Q xml\clientXml
md xml\clientXml

echo %1 %2
java -jar parserconfig.jar %1 %2 %3


rem del /q ..\Assets\Resources_\Config\AVGScripts\*.xml

copy xml\AVGScripts\*.* ..\Assets\Resources_\Config\AVGScripts\

rem if exist java\*.java del /q java\*.java
rem if exist csharp\*.cs del /q csharp\*.cs
rem if exist xml\*.xml del /q xml\*.xml
rem if exist xml\AVGScripts\*.xml del /q xml\AVGScripts\*.xml

if exist java\*.java del /q java\*.java
if exist csharp\*.cs del /q csharp\*.cs
if exist xml\*.xml del /q xml\*.xml
if exist xml\AVGScripts\*.xml del /q xml\AVGScripts\*.xml
if exist xml\clientXml\*.xml del /q xml\clientXml\*.xml
if exist ConfigManager.java del /q ConfigManager.java
if exist csharp\MainCSharp\*.cs del /q csharp\MainCSharp\*.cs
if exist csharp\HFCSharp\*.cs del /q csharp\HFCSharp\*.cs



setlocal
setlocal ENABLEDELAYEDEXPANSION
set path="..\Assets\Resources_\Config\AVGScripts\"
set suf="*.xml"
rem %path%
for /f "delims=" %%i in ('dir /b/s/a-d %path%\%suf%') do (
  set h="%%~ni"
  for %%j in (a b c d e f g h i j k l m n o p q r s t u v w x y z) do set h="!h:%%j=%%j!"
  ren "%%i" "!h!"%suf%
)
endlocal