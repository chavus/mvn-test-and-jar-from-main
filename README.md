This project is a template for "stand alone" tests that need to be packed into an executable `jar` and also need to be run using `mvn test`

### Characteristics:
1. Test is developed under main module
2. `maven-assembly-plugin` is added to pom to specify main class and to include dependencies in jar:
```xml
<plugins>
    <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>single</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <archive>
                <manifest>
                    <addClasspath>true</addClasspath>
                    <mainClass>run.TestMainRunner</mainClass>
                </manifest>
            </archive>
            <descriptorRefs>
                <descriptorRef>jar-with-dependencies</descriptorRef>
            </descriptorRefs>
        </configuration>
    </plugin> 
</plugins>
```
3. `src/main/java` and `src/main/resources` are defined as test sources and resource in the pom file:
```xml
<build>
        <testSourceDirectory>
            src/main/java
        </testSourceDirectory>
        
        <testResources>
            <testResource>
                <directory>src/main/resources</directory>
            </testResource>
        </testResources> 
</build>
```

4. To generate jar, run from terminal:
```shell
mvn clean compile assembly:single
```
`jar` file is output to `target` folder

5. And also `mvn test` can be executed

Note: When executing `mvn test`, `classes` and `test-classes` are generated with same content. That might cause throwing some warning durig execution, probably nothing to worry (its the downside of this approach) 