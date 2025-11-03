# CMSC495 Project

## Project Migration — Maven Structure

Since the team is using different IDEs (VS Code, IntelliJ, Eclipse, etc.), we're migrating the project to a **standard Maven project structure**. This ensures consistent builds, dependency management, and reduces merge conflicts caused by IDE-generated files.

---

## Benefits of Using Maven:

- Centralized dependency management in `pom.xml`
- Works uniformly across all IDEs
- Cleaner Git history
- Prevents classpath issues
- Helps enforce proper package structure

---

## Project Layout:
- When adding new files, place the file under the directory structure shown below.
<pre>
   src/main/java/edu/cmsc495
</pre>
- Make sure you add the package declaration at the top of your code:
<pre>
   package edu.cmsc495;
</pre>

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
               Converter_GUI.java
               ConverterController.java
</pre>

---

## Building and Running:
- From the root folder, build with: 
<pre>
   ./mvnw clean compile
</pre>
- From the root folder, run with: 
<pre>
   ./mvnw exec:java -Dexec.mainClass=edu.cmsc495.Main
</pre>

---

## Git workflow:
#### Step 1: Fork the Repo. This creates a copy of the repo under your account.
<pre>
   - FORK this Repo.
   - Choose your own GitHub account as the destination.
</pre>

#### Step 2: Clone Your Fork.
<pre>
   git clone https:github.com/YOUR_USER_NAME/CMSC495.git
   cd CMSC495
</pre>

#### Step 3: Start work (every new feature or fix)
Always start by updating `main` and then creating a branch:
<pre>
   git checkout main
   git pull origin main
   git switch -c feat/your-branch-name
</pre>

Use a good naming convention like...
<pre>
feat/ for new features
fix/ for bug fixes
refactor/ for code cleanup
docs/ for documentation

i.e. feat/add-gui or fix/neg-numbers
</pre>

#### Step 4: Start Coding! 
- Run your code often (see Building and Running above) before you decide to submit.
- Always run `./mvnw test` before pushing.
<pre>
   ./mvnw clean compile
   ./mvnw test
   ./mvnw exec:java -Dexec.mainClass=edu.cmsc495.Main
</pre>
- If everything is working, push it to main and open a pull request
<pre>
   git status
   git add .
   git commit -m "your message explaining what you did"
   git push -u origin feat/your-branch-name
</pre>
- Publish Your Merge
- Open PR on GitHub
- Ask for a Review

#### Step 5: After your merge has been approved, switch back to your main and delete your old branch.
<pre>
   git checkout main
   git pull origin main
   git branch -d feat_OR_fix/your_old_branch_name
</pre>

#### Step 6: Go Back to Step 3 and have more fun!
