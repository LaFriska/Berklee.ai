package jnotes.test.testutil;

public class Assertion<T> implements Runnable{

    private final T expected;
    private final T actual;

    private Boolean hasPassed = null;

    public Assertion(T expected, T actual){
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public void run() {
        hasPassed = expected.equals(actual);
    }

    public Boolean getResults(){
        return hasPassed;
    }

    public String getExpectedStr() {
        return String.valueOf(expected);
    }

    public String getActualStr() {
        return String.valueOf(actual);
    }

}
