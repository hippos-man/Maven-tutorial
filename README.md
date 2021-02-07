# Maven-tutorial
A tutorial to build simple standalone Java application with Maven.

# What I learned
- How to add dependencies by pom.xml
- Run Maven command from CLI tool
- Fetch Zipcode info using HttpClients
- Logging with apache log4j

# How to use
Run from Terminal
```bash
mvn compile exec:java -Dexec.mainClass="App"   -Dexec.args="<ZIPCODE>"
```
