package me.yohanfernando.samples.pdf.init;

import me.yohanfernando.samples.pdf.PdfCreator;

/**
 * Created by yohanfernando on 04/10/2014.
 *
 * This is the first point of control, at least during the setup phase
 */
public class StartupController {

    public static void main(String[] args) {
        StartupController sc = new StartupController();

        System.out.println("Saying " +sc.sayHello(args[0]));

    }

    public String sayHello(String name){
        return ("Hello " + ((name!=null && !name.isEmpty())?name:"")).trim();
    }

    public void createPdf() {
        PdfCreator pdf = new PdfCreator();
        pdf.testMe();
        pdf.sayHello();
    }

}
