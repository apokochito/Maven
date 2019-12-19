import static org.junit.Assert.*;

public class ClassToTestTest {

    @org.junit.Test
    public void sum() {
        ClassToTest obj = new ClassToTest();
        int result = obj.sum(1,7);
        assertEquals(8, result);
    }
}