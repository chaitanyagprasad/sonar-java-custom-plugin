package com.example.sonar;

import com.example.sonar.check.CustomCheck;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to register the classes as the check components.
 * */
public class RulesList {

    private RulesList() {
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return Collections.unmodifiableList(Arrays.asList(
                CustomCheck.class
        ));
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return new ArrayList<>();
    }

}

