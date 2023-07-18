package jnotes.test.testutil;

public class Assertion<T> implements Runnable{

    private final T expected;
    private final T actual;
    private final boolean isString;

    private Boolean hasPassed = null;

    public Assertion(T expected, T actual){
        this.expected = expected;
        this.actual = actual;
        isString = actual instanceof String;
    }

    @Override
    public void run() {
        hasPassed = isString ? expected.equals(actual) : expected == actual;
    }

    public Boolean getResults(){
        return hasPassed;
    }

}
