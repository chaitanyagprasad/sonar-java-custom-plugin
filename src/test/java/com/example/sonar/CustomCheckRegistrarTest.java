package com.example.sonar;

import org.junit.jupiter.api.Test;
import org.sonar.plugins.java.api.CheckRegistrar;

import static org.assertj.core.api.Assertions.assertThat;


class CustomCheckRegistrarTest {
    @Test
    void checkNumberRules() {
        CheckRegistrar.RegistrarContext context = new CheckRegistrar.RegistrarContext();

        CustomCheckRegistrar registrar = new CustomCheckRegistrar();
        registrar.register(context);

        assertThat(context.checkClasses()).hasSize(1); // change it to 9, we added a new one!
        assertThat(context.testCheckClasses()).isEmpty();
    }
}