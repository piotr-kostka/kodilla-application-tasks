call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo Runcrud has errors – breaking work
goto fail

:openbrowser
start chrome http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Cannot open link in Chrome browser
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.