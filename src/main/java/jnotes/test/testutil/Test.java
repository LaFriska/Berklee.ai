package jnotes.test.testutil;

import java.util.ArrayList;

public class Test extends Failable implements Runnable{

    public static ArrayList<Suite> suites = new ArrayList<>();

    public Test addSuite(Suite suite){
        suites.add(suite);
        return this;
    }

    public Test addSuites(Suite ... suites){
        for (Suite suite : suites) {
            addSuite(suite);
        }
        return this;
    }

    @Override
    public void run() {
        int count = 0;
        for (Suite suite : suites) {
            count++;
            logSuite(suite, count);
            suite.run();
            if(suite.isFailed()){
                failed = true;
                failLog.append("\n").append(suite.getFailLog());
            }
        }
        failLog.insert(0, "--------------------FAIL LOG--------------------").append("--------------------FAIL LOG--------------------");
        if(isFailed()){
            System.err.println("\nTest failed: " + failedNum + "/" + suites.size() + " test suites did not succeed. Below is the fail log:\n");
            System.err.println(failLog);
        }else{
            System.out.println("Success! All test suites out of " + suites.size() + " have passed without any failed assertions.");
        }
    }

    private void logSuite(Suite suite, int count){
        System.out.println("Running test suite " + count + "/" + suites.size() + ": " + suite.getSuiteName());
    }
}