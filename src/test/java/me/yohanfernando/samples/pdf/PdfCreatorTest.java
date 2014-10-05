package me.yohanfernando.samples.pdf;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yohanfernando on 04/10/2014.
 * <p/>
 * Contain tests for PdfCreator.
 */
public class PdfCreatorTest {

    @Rule
    public TestName testName = new TestName();

    PdfCreator pdfCreator = new PdfCreator();

    @Before
    public void setUp() {
        System.out.println("Running test " + testName.getMethodName());
    }

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello from " + PdfCreator.class.getName(), pdfCreator.sayHello());
    }

    @Test
    public void testCreateWithFilenameIncExtension() throws IOException, COSVisitorException {
        String filename = "testCreateWithFilenameIncExtension.pdf";
        pdfCreator.create(filename);

        Assert.assertTrue(new File(pdfCreator.getOutputDirectory() + filename).exists());
    }

    @Test
    public void testCreateWithFilenameExcExtension() throws IOException, COSVisitorException {
        String filename = "testCreateWithFilenameExcExtension";
        pdfCreator.create(filename);

        Assert.assertTrue(new File(pdfCreator.getOutputDirectory() + filename + ".pdf").exists());
    }

    private int countFilesWithPattern(String path, String pattern) {
        Path fPath = Paths.get(path);

        int i = 0;
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(fPath, pattern)) {
            for (Path p : ds) {
                i++;
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        return i;
    }

    @Test
    public void testCreateWithEmptyFilename() throws IOException, COSVisitorException {
        String filename = "";

        int iBefore = countFilesWithPattern(pdfCreator.getOutputDirectory(), "pdf-*.pdf");

        pdfCreator.create(filename);

        int iAfter = countFilesWithPattern(pdfCreator.getOutputDirectory(), "pdf-*.pdf");

        Assert.assertEquals(iAfter, iBefore + 1);
    }

    @Test
    public void testCreateWithNullFilename() throws IOException, COSVisitorException {
        String filename = null;

        int iBefore = countFilesWithPattern(pdfCreator.getOutputDirectory(), "pdf-*.pdf");

        pdfCreator.create(filename);

        int iAfter = countFilesWithPattern(pdfCreator.getOutputDirectory(), "pdf-*.pdf");

        Assert.assertEquals(iAfter, iBefore + 1);
    }


}