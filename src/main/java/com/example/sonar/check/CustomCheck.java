package com.example.sonar.check;


import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

/**
 * IssuableSubscriptionVisitor defines the strategy on how this
 * */
@Rule(name = "CustomCheck")
public class CustomCheck extends IssuableSubscriptionVisitor {

    public List<Tree.Kind> nodesToVisit() {
        return Collections.emptyList();
    }
}
