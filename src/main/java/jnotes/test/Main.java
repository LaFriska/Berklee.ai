package jnotes.test;

import jnotes.core.notes.Notes;
import jnotes.test.testutil.Assertion;

public class Main {
    public static void main(String[] args) {
        Assertion<String> assertion = new Assertion<>("Hello", "Hello");
        assertion.run();
        System.out.println(assertion.getResults());
    }
}
