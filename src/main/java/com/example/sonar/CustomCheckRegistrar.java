package com.example.sonar;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

import java.util.List;

/**
 * This class is used to tell the parent Java Plugin that there are new rules to be fetched for analysis.
 *
 * */
@SonarLintSide
public class CustomCheckRegistrar implements CheckRegistrar {
    @Override
    public void register(RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(
            CustomRulesDefinition.REPOSITORY_NAME,
                checkClasses(),
                testCheckClasses()
        );
    }

    public static List<Class<? extends JavaCheck>> checkClasses() {
        return RulesList.getJavaChecks();
    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static List<Class<? extends JavaCheck>> testCheckClasses() {
        return RulesList.getJavaTestChecks();
    }
}
