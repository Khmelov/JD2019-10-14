FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../lang/%%~nI.properties
)
