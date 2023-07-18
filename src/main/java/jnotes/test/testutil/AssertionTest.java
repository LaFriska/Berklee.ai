package jnotes.test.testutil;

public class AssertionTest {

    private static int TEST_NUM = 0;

    public static <T> void assertEquals(T result, T test){
        TEST_NUM++;
        if(test == result){
            log(true);
        }else{
            log(false);
        }
    }

    private static void log(boolean passed){
        System.out.println("Test assertion number " + TEST_NUM + " has " + (passed ? "passed." : "failed."));
    }

}
