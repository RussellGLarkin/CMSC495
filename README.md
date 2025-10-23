# CMSC495 Project

## Project Migration — Maven Structure

Since the team is using different IDEs (VS Code, IntelliJ, Eclipse, etc.), we're migrating the project to a **standard Maven project structure**. This ensures consistent builds, dependency management, and reduces merge conflicts caused by IDE-generated files.

---

## Benefits of Using Maven

- Centralized dependency management in `pom.xml`
- Works uniformly across all IDEs
- No more manually downloading JARs
- Cleaner Git history
- Prevents classpath issues
- Helps enforce proper package structure

---

## Project Layout

<pre>
CMSC495/
├─ pom.xml                      # Maven build file
├─ mvnw, mvnw.cmd               # Maven Wrapper scripts
├─ .mvn/                        # Wrapper support files
└─ src/
   └─ main/
      └─ java/
         └─ edu/
            └─ cmsc495/
               Main.java
               CurrencyConverter.java
</pre>

## Place all Java source files inside
<pre>src/main/java/edu/cmsc495</pre>

## Building and Running
Build with: 
<pre>./mvnw clean compile</pre>
Run with: 
<pre>./mvnw exec:java -Dexec.mainClass=edu.cmsc495.Main</pre>

## When Adding New Java Files
- Include the package declaration:
<pre>package edu.cmsc495;</pre>
- Place the file under the directory structure shown above.
