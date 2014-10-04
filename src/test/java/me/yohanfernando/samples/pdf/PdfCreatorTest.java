package me.yohanfernando.samples.pdf;

import junit.framework.TestCase;
import me.yohanfernando.samples.pdf.PdfCreator;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yohanfernando on 04/10/2014.
 *
 * Contain tests for PdfCreator.
 */

public class PdfCreatorTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        System.out.println("Running test " + getName());
    }

    @Test
    public void testSayHello() throws Exception {
        PdfCreator pdf = new PdfCreator();
        assertEquals("Hello from "+PdfCreator.class.getName(),pdf.sayHello()); ;

    }
}