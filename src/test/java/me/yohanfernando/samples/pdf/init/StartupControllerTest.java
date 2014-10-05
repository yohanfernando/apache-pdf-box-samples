package me.yohanfernando.samples.pdf.init;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by yohanfernando on 04/10/2014.
 *
 * Contain tests for StartupController which will be the first point of control (at least during the setup phase)
 */
public class StartupControllerTest {

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception {
        System.out.println("Running test " + testName.getMethodName());
    }

    @Test
    public void testSayHelloWithName() {
        StartupController sc = new StartupController();
        Assert.assertEquals("Hello Test", sc.sayHello("Test"));
    }

    @Test
    public void testSayHelloWithNull() {
        StartupController sc = new StartupController();
        Assert.assertEquals("Hello", sc.sayHello(null));
    }

    @Test
    public void testSayHelloWithEmptyString() {
        StartupController sc = new StartupController();
        Assert.assertEquals("Hello", sc.sayHello(""));
    }


}