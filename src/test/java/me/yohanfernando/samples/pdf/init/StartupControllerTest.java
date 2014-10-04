package me.yohanfernando.samples.pdf.init;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

/**
 * Created by yohanfernando on 04/10/2014.
 *
 * Contain tests for StartupController which will be the first point of control (at least during the setup phase)
 */
public class StartupControllerTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        System.out.println("Running test " + getName());
    }

    public void testSayHelloWithName() {
        StartupController sc = new StartupController();
        assertEquals("Hello Test",sc.sayHello("Test"));
    }

    public void testSayHelloWithNull() {
        StartupController sc = new StartupController();
        assertEquals("Hello",sc.sayHello(null));
    }

    public void testSayHelloWithEmptyString() {
        StartupController sc = new StartupController();
        assertEquals("Hello",sc.sayHello(""));
    }


}