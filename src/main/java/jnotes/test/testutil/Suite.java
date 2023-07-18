package jnotes.test.testutil;

import java.util.ArrayList;

public class Suite extends Failable implements Runnable{

    private static final String IND = "     ";

    private final String suiteName;

    private final ArrayList<Assertion<?>> assertions = new ArrayList<>();

    public Suite(String suiteName){
        this.suiteName = suiteName;
    }

    public Suite addAssertion(Assertion<?> assertion){
        assertions.add(assertion);
        return this;
    }

    public Suite addAssertions(Assertion<?> ... assertions){
        for (Assertion<?> assertion : assertions) {
            addAssertion(assertion);
        }
        return this;
    }

    @Override
    public void run() {
        int count = 0;
        for (Assertion<?> assertion : assertions) {
            count++;
            assertion.run();
            logAssertion(assertion, count);
        }
        if(isFailed()){
            System.err.println(IND + "Suite test failed: " + failedNum + "/" + assertions.size() + " assertions failed.");
            failLog.insert(0, "Test suite \"" + getSuiteName() + "\"\n");
        }else{
            System.out.println(IND + "Suite test success, all assertions passed.");
        }
    }

    private void logAssertion(Assertion<?> assertion, int count){
        Boolean result = assertion.getResults();
        if(result == null) throw new RuntimeException("Assertion result had not been generated yet.");

        if(result){
            System.out.println(IND + "Assertion number " + count + " passed.");
        }else{
            String log = IND + "Assertion number " + count + " failed." + "\n" +
                    IND + IND + "Expected result: " + assertion.getExpectedStr() + "\n" +
                    IND + IND + "Actual result: " + assertion.getActualStr();
            System.out.println(log);
            failLog.append(log).append("\n");
            failed = true;
            failedNum++;
        }
    }

    public String getSuiteName() {
        return suiteName;
    }
}
