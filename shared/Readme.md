# Generate a JAR to be used in other projects as a library

https://stackoverflow.com/questions/76846047/how-to-use-a-springboot-project-as-a-shared-library-in-microservice-project/76847561#76847561


1- Go to pom.xml in shared project and add this:

           <plugin>
                <artifactId>maven-jar-plugin</artifactId>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                        <configuration>
                            <classifier>origin</classifier>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
2- Inside the folder where exists the pom.xml in the shared project execute this:

mvn clean install
3- Go inside shared folder and Install the jar (change the file, groupId and the artifactId):

mvn install:install-file -Dfile=./target/shared-0.0.1-SNAPSHOT-origin.jar -DgroupId=com.anchtun -DartifactId=shared -Dversion=1.0 -Dpackaging=jar
4- Go inside account project and add in pom.xml this dependency (change the groupId and the artifactId):

<dependency>
    <groupId>com.anchtun</groupId>
    <artifactId>shared</artifactId>
    <version>1.0</version>
</dependency>
5- You can use the jar now!



