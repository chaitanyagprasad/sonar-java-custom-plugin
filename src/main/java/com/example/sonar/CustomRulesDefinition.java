package com.example.sonar;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.plugins.java.api.JavaCheck;

public class CustomRulesDefinition /*implements RulesDefinition*/ {
    public static final String REPOSITORY_NAME = "chait-custom-rules-java";
    /**
     * annotation based loading
     * */
    /*@Override
    public void define(Context context) {
        NewRepository repository = context
                .createRepository(
                        REPOSITORY_NAME,
                        "java"
                ).setName("Custom sonar rules developed by chait");
        for( Class<? extends JavaCheck> check : RulesList.getJavaChecks() ) {
            new RulesDefinitionAnnotationLoader().load(repository, check);

        }
    }*/
}
