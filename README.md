# java-maven-intellij-walkthrough

## Change System Settings
On Mac or Linux, modify settings in ~/.bash_profile, for example, to set a new
variable MYHOME, add the following line
```
export MYHOME=~
```  

Then we need to relogin again or run the following
```
source ~/.bash_profile
```

On Windows, open Settings(search settings on windows bar) and then search environment.
Then we could add or modify settings, they are key value pairs.
We need to restart command windows after new settings.

## JDK download

Download the latest release version or a specific version of JDK from 
[Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
The JDK document is [JavaDoc](https://docs.oracle.com/en/java/javase/16/index.html).

After installation, add the following to ~/.bash_profile.
``` 
export JAVA_HOME=~/tools/jdk-16.0.2
export PATH=~/tools/jdk-16.0.2/bin:$PATH
```
Open a command window and run 
```
source ~/.bash_profile
java -version
echo $JAVA_HOME
```
the Java version and home should be printed.

## Maven Download

Download the latest version of Maven from [Apache Maven](https://maven.apache.org/download.cgi) 
(binary zip archive).
Unzip to somewhere, like ~/tools/.
On Mac, double click the zip file to unzip, then copy to the target folder.
On Windows, use 7zip to open and drag the the Maven folder to the target folder.

To set the Maven environment, add the following lines to ~/.bash_profile
```
export M2_HOME=~/tools/apache-maven-3.8.2 # other tools are looking for this
export PATH=~/tools/apache-maven-3.8.2/bin:$PATH # add executable to PATH
```
Open a command window and run 
```
source ~/.bash_profile
mvn --version
echo $M2_HOME
```
the Maven version and home should be printed.

Next we need to copy $M2_HOME/conf/settings.xml to ~/.m2/settings.xml.
Then uncomment the localRepository section to set local repository directory:
```
<localRepository>~/tools/java-maven-repo</localRepository>
```
This is where Maven stores downloads.

## Git Repository for Source Code
Create a new repo in [github](https://github.com), we use java-maven-intellij-walkthrough
as example.
First, get the git link

![git](docs/git.png)

Now modify the git link to embed user and token
```
https://<userid>:<token>@github.com/psilons/java-maven-intellij-walkthrough.git
```

If in any chance this is missing, we can reset it locally(run this in the project folder)
```
git remote set-url origin https://<userid>:<token>@github.com/psilons/java-maven-intellij-walkthrough.git
```
The token is generated from github.com, in the user | Settings | Developer settings | Personal access token.

Then in a command window
```
git clone <git link>
git status
```
On Windows, we need [git command](https://git-scm.com/download/win) and 
optionally [Tortoise GIT](https://tortoisegit.org/).

Finally, add a .gitignore file to exclude target folder.

Now our project home is: 
```
~/java/java-maven-intellij-walkthrough
```


## Create Maven Project
To create a new Maven project, we need to create a file pom.xml under
the project home. A good background document is
[Maven in 5 minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
We just copy the pom.xml content to here and modify it later.

With the pom.xml in place, go to the project directory in a command windows
and fire off the following
```
mvn compile
```
It should finish without error.
Now follow the above Maven doc to set up the subfolders in the project, 
such as src/main/java, etc.

## IntelliJ
Download and install IntelliJ from 
[JetBrains](https://www.jetbrains.com/idea/download/#section=windows).
Once IntelliJ starts, select new 

![new project](docs/intellij-new-project.png)

Then navigate to the pom.xml

![pom.xml](docs/intellij-pom.png)

Next, trust the project(you check the box to trust the root folder)

![trust](docs/intellij-trust.png)

Select new window next and give some time for IntelliJ to digest the project.
You may click the progress bar at the bottom of the window to see progress.

Once it's done, on the right side, we should see different colors

![left](docs/intellij-left.png)

On the right side, we should see no error in Maven view

![right](docs/intellij-right.png)

Next, we set the JDK we downloaded to the project, right mouse click on the
project name

![jdk-setup](docs/intellij-jdk-setup.png)

Then select the JDK

![jdk-select](docs/intellij-jdk-select.png)

Finally, set the JDK to the project

![jdk-project](docs/intellij-jdk-project.png)


## Coding and Testing
To create a new Java package

![new package](docs/intellij-new-package.png)

Type in org.mytest

To create a new Java class under this package

![new class](docs/intellij-new-class.png)

Type in HelloWorld.

To run the class, right mouse click anywhere and select run

![hello](docs/intellij-hello-world.png)

## GIT Commit
To commit the change

![commit1](docs/intellij-git-commit1.png)

Then select all needed files

![commit2](docs/intellij-git-commit2.png)

The commit is to local repo. In order to push to remote repo,

![push](docs/intellij-git-push.png)


## Unit Testing and Logging
The JUnit lib in the pom.xml is old. The latest version can be found in
[Maven Central](https://mvnrepository.com/). Search for JUnit and click on the
latest version
![junit1](docs/mvn-junit-version.png)
![junit2](docs/mvn-junit-dep.png)

Similarly, we could add logging lib and modify the code to use it.

Finally, we add maven surefire plugin to run unit tests. Either right click
the test Lifecycle in the Maven view on the right hand side, or fire off maven
command from a command window.
```
mvn test 
```

## Test Coverage
To run the test coverage in IntelliJ

![intellij-test-coverage](docs/intellij-test-coverage.png)

The result shows

![intellij-test-coverage1](docs/intellij-test-coverage1.png)

For Maven, we need to set up the jacoco plugin. To run the test coverage,
```
run clean verify
```
The result is in target/test-coverage/index.html. More info can be found
[mkyong](https://mkyong.com/maven/maven-jacoco-code-coverage-example/)
and
[LambdaTest](https://www.lambdatest.com/blog/reporting-code-coverage-using-maven-and-jacoco-plugin/)

