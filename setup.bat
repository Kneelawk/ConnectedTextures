@echo off

cd %~dp0

IF %~1 EQU "" (
	java -jar DownloadAndExtract2.jar
) ELSE (
	java -jar DownloadAndExtract2.jar
	call gradlew.bat setupDecompWorkspace %~1
)

pause
