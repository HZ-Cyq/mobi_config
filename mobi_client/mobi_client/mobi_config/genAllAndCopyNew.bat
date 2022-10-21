chcp 936
cd /D %~dp0
mode con lines=999
echo off

set server_package_name=mobi

set clientXmlPath=..\Assets\Resources_\Config\ConfigXml\
set clientXmlPathAVG=..\Assets\Resources_\Config\AVGScripts\
set clientCSPath=..\Assets\scripts\Config\ConfigModel\
set serverJavaPath=..\..\..\mobi_server\mobi_server\src\main\java\com\mobi\config\configModel\
set serverConfigManagerPath=..\..\..\mobi_server\mobi_server\src\main\java\com\mobi\config\
set serverXmlPath=..\..\..\mobi_server\mobi_server\data\

set clientHFCSPath=..\mobi_hotfix\mobi_hotfix\HFScripts\HFConfig\ConfigModel\

if not exist csharp mkdir csharp
if not exist csharp\hf mkdir csharp\hf
if not exist csharp\MainCSharp mkdir csharp\MainCSharp
if not exist csharp\HFCSharp mkdir csharp\HFCSharp
if not exist java mkdir java
if not exist xml mkdir xml
if not exist xml\AVGScripts mkdir xml\AVGScripts
if not exist excel\AVGScripts mkdir excel\AVGScripts

if exist xml\AVGScripts\*.xml del /q xml\AVGScripts\*.xml

if exist xml\clientXml rd /s /Q xml\clientXml
md xml\clientXml

java -jar parserconfigNew.jar %server_package_name%

if exist %clientXmlPath%*.xml del /q %clientXmlPath%*.xml
if exist %clientXmlPathAVG%*.xml del /q %clientXmlPathAVG%*.xml

if exist %clientCSPath%*.cs del /q %clientCSPath%*.cs
if exist %serverJavaPath%*.java del /q %serverJavaPath%*.java
if exist %serverXmlPath%*.xml del /q %serverXmlPath%*.xml

if exist %clientHFCSPath%*.cs del /q %clientHFCSPath%*.cs


if exist %serverJavaPath% copy java\*.java %serverJavaPath% >nul
if exist %serverConfigManagerPath% copy ConfigManager.java %serverConfigManagerPath% >nul
if exist %serverXmlPath% copy xml\*.xml %serverXmlPath% >nul
if exist xml\cdkeytemp.xml del xml\cdkeytemp.xml
rem if exist %clientCSPath% copy csharp\*.* %clientCSPath% >nul
if exist %clientXmlPath% copy xml\clientXml\*.* %clientXmlPath% >nul
if exist %clientXmlPathAVG% copy xml\AVGScripts\*.* %clientXmlPathAVG% >nul

java -jar configtools\ConfigToolsJava.jar
if exist %clientCSPath% copy csharp\MainCSharp\*.* %clientCSPath% >nul
if exist %clientHFCSPath% copy csharp\HFCSharp\*.* %clientHFCSPath% >nul


echo FILES COPIED.
echo .


del /q java\*.java
del /q csharp\*.cs
del /q xml\*.xml
del /q xml\AVGScripts\*.xml
if exist xml\clientXml\*.xml del /q xml\clientXml\*.xml
del /q ConfigManager.java
del /q csharp\MainCSharp\*.cs
del /q csharp\HFCSharp\*.cs

setlocal
setlocal ENABLEDELAYEDEXPANSION
set suf="*.xml"
rem %clientXmlPath%
for /f "delims=" %%i in ('dir /b/s/a-d %clientXmlPath%\%suf%') do (
  set h="%%~ni"
  for %%j in (a b c d e f g h i j k l m n o p q r s t u v w x y z) do set h="!h:%%j=%%j!"
  ren "%%i" "!h!"%suf%
)

rem %clientXmlPathAVG%
for /f "delims=" %%i in ('dir /b/s/a-d %clientXmlPathAVG%\%suf%') do (
  set h="%%~ni"
  for %%j in (a b c d e f g h i j k l m n o p q r s t u v w x y z) do set h="!h:%%j=%%j!"
  ren "%%i" "!h!"%suf%
)
endlocal

pause