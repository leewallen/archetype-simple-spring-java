# archetype-simple-spring-java

Archetype for creating a spring boot java application with default "Widget" related classes.

## Download and Install Archetype

You can clone the repo, or you can curl the jar file from bintray.com.

### Cloning

    git clone https://github.com/leewallen/archetype-simple-spring-java.git

### Using Curl

    
    curl -L "https://dl.bintray.com/leewallen/archetype-simple-spring-java-repo/archetype-simple-spring-java-0.1.0.jar" \
         -o archetype-simple-spring-java-0.1.0.jar

## Install archetype

### Installing from Cloned Repo

If you cloned the repo, then run this command:

    mvn clean package install archetype:update-local-catalog

### Installing from Downloaded Jar:

If you downloaded the jar, then run this command:

    mvn install -f ./archetype-simple-spring-java-0.1.0.jar

## Example Usage

    mvn archetype:generate \
        -B \ 
        -DarchetypeGroupId=codecog \
        -DarchetypeArtifactId=archetype-simple-spring-java \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=search \
        -Dpackage=app \
        -DartifactId=spring-test \
        -Djava-version=1.8

## Parameter Values

| Param Name | Description | Default |
| :---------- | :----------- | :------- | 
| version |  The version of your application. | 1.0.0 |
| java-version | The java version you want to set the app to use. 1.8 or 11. | 1.8 |
| package | The base package name to use for the app. | app |
| artifactId | The artifactId is used as the application identifier. ||
| groupId | The groupId is used in the API info page for Swagger. ||


