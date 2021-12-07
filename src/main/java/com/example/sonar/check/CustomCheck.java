package com.example.sonar.check;


import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

/**
 * IssuableSubscriptionVisitor defines the strategy on how a *.java file will be analyzed.
 *
 * */
@Rule(name = "CustomCheck")
public class CustomCheck extends IssuableSubscriptionVisitor {

    /**
     * This method tells what kind of node to visit.
     * In this case, the node that we will consider is a method.
     * */
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.METHOD);
    }

    /**
     * This method specifies how the rule will react when methods declared in nodesToVisit() are encountered.
     * In this case we want to check whether the return type of a method is same as input argument and report it as a
     * violation
     * */
    @Override
    public void visitNode(Tree tree) {
        MethodTree methodTree = (MethodTree) tree;
        if( methodTree.parameters().size() == 1 ) {
            /* Object that will give the details(information) about method */
            Symbol.MethodSymbol symbol = methodTree.symbol();
            Type returnType = symbol.returnType().type();
            Type inputType = symbol.parameterTypes().get(0);
            if( returnType.is(inputType.fullyQualifiedName()) ) {
                /* Use the reportIssue to  */
                reportIssue(methodTree.simpleName(), "Never do that");
            }
        }
    }
}
