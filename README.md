# sonar-java-custom-plugin
This code repository walks us through how to write custom rules to validate Java code on Sonar server.
The code will be developed as a Maven project and the *.jar will be deployed onto the sonar server.

# Steps to be followed:
1. Create the correct `pom.xml` with the following properties:
```aidl
<sonarqube.version>{sonar.server.version}</sonarqube.version>
<sonarjava.version>{sonar.java.version</sonarjava.version>
<sonar.plugin.api.version>{sonar.api.version}</sonar.plugin.api.version>
<java.plugin.version>{java.plugin.version}</java.plugin.version>
```
2. Develop a custom check `CustomCheck` which will implement `IssuableSubscriptionVisitor`. This class will contain the logic that will be run against the code.
3. Register the `CustomCheck` to a class `RulesList` which will contain a list of rules to run analysis against.
4. Create an instance of `CheckRegistrar` to tell the Sonar's Java analyzer about the new plugins that we are going to be deploying on the Sonar server.
5. Develop 2 metadata files to provide more information about the validations done in `CustomCheck`: `CustomCheck.html` and `CustomCheck.json`
6. Build the project. Deploy the same to Sonar server.
7. Create profile: start analysis
