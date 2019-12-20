# Maven Basics
- Libraries (master branch)
    - Lombok
    - Jackson
    - Orika
    - Log4J & Slf4J (Don't forget add slf4j dependency (compile Scope) to your classpath - "Project modules" for IntelliJ IDEA)
    - Test JUnit4 (Don't forget add JUnit4 to your classpath)
    - Jacoco Report (test goal to generate it)
- Java Servlets (servlet branch)
    - Tomcat Maven Plugin (Servlet using IntelliJ IDEA Community)(To create project struncture, run this maven command - mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4)
    - Servlet GET "Hello from a servlet" (You must have war packaging tag on your POM to run tomcat, tomcat7:run maven command)
    - JSP (See this app - http://localhost:9090/servlet)
- Maven Basics (maven branch)
    - Lifecycles
    - Plugins
    - Dependencies
    - Artifactory
    - Version
    - Profiles (Run perfiles with mvn package command, it is to activate a profile, add -P option, mvn package -Pxtest)
