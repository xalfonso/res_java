package eas.com.direct;


import eas.com.console.HelloWorkPrinter;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class MainApplication {

    public static void main(String[] args) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new HelloWorkPrinter());
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                System.out.println("Exception of in print");
                /* The job did not successfully complete */
            }
        } else {
            System.out.println("The printing was cancelled");
        }
    }

}
