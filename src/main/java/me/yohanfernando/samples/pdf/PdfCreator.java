package me.yohanfernando.samples.pdf;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yohanfernando on 04/10/2014.
 * <p/>
 * This will be used to create pdf's.
 * <p/>
 * todo: more details to follow
 */
public class PdfCreator {

    private String outputDirectory;

    //region Constructor & related functions
    public PdfCreator() {
        outputDirectory = "target/pdfs/";

        File outputDir = new File(outputDirectory);
        outputDir.mkdirs();
        emptyDir(outputDir);
    }

    /**
     * Recursively delete the output folder
     *
     * @param file the current file/folder
     */
    private void emptyDir(File file) {
        File[] files = file.listFiles();

        for (File dFile : files) {
            if (dFile.isDirectory()) {
                emptyDir(dFile);
            }
            dFile.delete();
        }
    }
    //endregion


    public void testMe() {System.out.println("Running " + getClass().getName());}

    public String sayHello() {
        return "Hello from " + getClass().getName();
    }

    /**
     * Create a pdf document and save with the given filename
     *
     * @param filename given file name
     *
     * @throws IOException
     * @throws COSVisitorException
     */
    public void create(String filename) throws IOException, COSVisitorException {

        /*
            Create the parent pdf document
         */
        PDDocument document = new PDDocument();

        /*
            Create a page and add to the document
         */
        PDPage page = new PDPage();
        document.addPage(page);

        /*
            save the pdf just created, use generatePdfName(...) to get the correct file name with path.
         */
        document.save(generatePdfName(filename));

        /*
            close the pdf document to ensure its properly closed
         */
        document.close();
    }

    /**
     * This will generate the pdf save path and filename with '.pdf' extension (if not already included)
     * <p/>
     * If no filename given a default name is used in the format pdf-yyyy-MM-dd-hh-mm.pdf
     * <p/>
     * If a file exists with the given name, an incrementing no will be appended.
     *
     * @param filename given file name, if null/empty a default name will be use
     *
     * @return the save path & filename
     */
    private String generatePdfName(String filename) {
        String fNameMaster, fName;

        if (filename != null && !filename.isEmpty()) {
            if (filename.endsWith(".pdf")) {
                fNameMaster = filename.substring(0, filename.length() - 4);
            } else {
                fNameMaster = filename;
            }
        } else {
            fNameMaster = "pdf-" + new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        }

        fName = fNameMaster;

        int i = 1;
        Path path = Paths.get(outputDirectory + fName + ".pdf");
        while (Files.exists(path)) {
            fName = fNameMaster + "-" + i;
            path = Paths.get(outputDirectory + fName + ".pdf");
            i++;
        }

        return outputDirectory + fName + ".pdf";
    }


    //region Getters/Setters
    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }
    //endregion
}
