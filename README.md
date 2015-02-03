- Make sure JDK 1.8 is installed
- Make sure you have license set: <licensekey>Apr 3, 2015~Moex_DEV@W3WGkjbQhPFVNMtPQsSx#PREMIUM^10.0XAPPremium%UNBOUND+UNLIMITED</licensekey>
- Change GIGA_LOCATION in setenv.cmd
- Start compile.cmd (javac and java should be in PATH), make sure class files are generated and no error is printed
- Start command "gs.bat start GSA" in %GIGA_LOCATION%bin\ folder, wait till its started
- Start run.cmd and wait till 10 iterations to be run

Sample run results are:
```
2015-02-03 13:41:27,662  INFO [com.gigaspaces.core.common] - Space [eifSpace_container:eifSpace] with url [/./eifSpace?schema=default&groups=gigaspaces-10.0.1-XAPPremium-ga&state=started] started successfully
2015-02-03 13:41:28,025  INFO [EmbeddedProcessor] - Starting write loop
Test[SmallMessageSimpleIndices] count=10000, avg=0.1594 ms, throughput=6273.0 obj per sec.
Test[SmallMessageSimpleIndices] count=10000, avg=0.1326 ms, throughput=7541.0 obj per sec.
Test[SmallMessageSimpleIndices] count=10000, avg=0.0588 ms, throughput=17006.0 obj per sec.
Test[SmallMessageCompexKey] count=10000, avg=0.0906 ms, throughput=11037.0 obj per sec. 
Test[SmallMessageCompexKey] count=10000, avg=0.0516 ms, throughput=19379.0 obj per sec. 
Test[SmallMessageCompexKey] count=10000, avg=0.0337 ms, throughput=29673.0 obj per sec. 
Test[SmallMessageCompoundIndex] count=10000, avg=0.0445 ms, throughput=22471.0 obj per sec. 
Test[SmallMessageCompoundIndex] count=10000, avg=0.0541 ms, throughput=18484.0 obj per sec. 
Test[SmallMessageCompoundIndex] count=10000, avg=0.0439 ms, throughput=22779.0 obj per sec. 
Test[SmallMessageComplexKeyCompoundIndex] count=10000, avg=0.0589 ms, throughput=16977.0 obj per sec. 
Test[SmallMessageComplexKeyCompoundIndex] count=10000, avg=0.0372 ms, throughput=26881.0 obj per sec. 
Test[SmallMessageComplexKeyCompoundIndex] count=10000, avg=0.0396 ms, throughput=25252.0 obj per sec. 
```
