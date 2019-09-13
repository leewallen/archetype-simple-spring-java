# archetype-simple-spring-java
Archetype for creating a spring boot java application with default "Widget" related classes.

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

**java-version**: 1.8 or 11 are supported.
**package**: This is used as the default package name. If a package name is not provided, then the archetype will default to `app`.
**artifactId**: The artifactId is used as the app identifier.
**groupId**: The groupId is used in the API info page for Swagger.


