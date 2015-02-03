call setenv.cmd
rem set JAVA_OPTIONS=-verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps 
set JAVA_OPTIONS=%JAVA_OPTIONS% -Xmx3G -Xms3G -XX:+UseParallelGC

java -classpath .;%GIGA_LOCATION% -Djava.ext.dirs=%GIGA_LOCATION%lib\required\ %JAVA_OPTIONS% EmbeddedProcessor