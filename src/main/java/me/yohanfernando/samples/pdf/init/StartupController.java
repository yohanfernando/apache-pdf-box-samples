package me.yohanfernando.samples.pdf.init;

import me.yohanfernando.samples.pdf.PdfCreator;
import org.apache.pdfbox.exceptions.COSVisitorException;

import java.io.IOException;

/**
 * Created by yohanfernando on 04/10/2014.
 * <p/>
 * This is the first point of control, at least during the setup phase
 */
public class StartupController {

    public static void main(String[] args) {
        StartupController sc = new StartupController();

        System.out.println("Saying " + sc.sayHello(args[0]));

        sc.createPdf();
    }

    public String sayHello(String name) {
        return ("Hello " + ((name != null && !name.isEmpty()) ? name : "stranger")).trim();
    }

    public void createPdf() {
        PdfCreator pdf = new PdfCreator();
        pdf.testMe();
        pdf.sayHello();

        try {
            pdf.create("blankpage");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
    }

}
