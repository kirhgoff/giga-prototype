call setenv.cmd
rm *.class
javac -classpath . -Djava.ext.dirs=%GIGA_LOCATION%lib\required\ *.java