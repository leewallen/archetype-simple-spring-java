# archetype-simple-spring-java
Archetype for creating a spring boot java application with default "Widget" related classes.

## Usage

    mvn archetype:generate \
        -B \ 
        -DarchetypeGroupId=codecog \
        -DarchetypeArtifactId=archetype-simple-spring-java \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=search \
        -Dpackage=app \
        -DartifactId=spring-test \
        -Djava-version=1.8
