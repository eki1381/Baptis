package org.ryh.baptis.service;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.print.DocPrintJob;
import javax.print.PrintService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.service.DefaultService;

public class PrinterServiceImpl extends DefaultService implements PrinterService{
	
	public static final String RESULT = "src/FirstPdf.pdf";
    public static final String FONT = "src/resources/Roboto-Regular.ttf";
    public static final String FONT_BOLD = "src/resources/Roboto-Bold.ttf";
    
	@Override
	public void doPrinting(String printerName, Wave wave) throws IOException, PrinterException {
		PrintService[] services = PrinterJob.lookupPrintServices();
        PDDocument pdf = PDDocument.load(new File(RESULT));
        PrinterJob job = PrinterJob.getPrinterJob();
        DocPrintJob docPrintJob = null;
        for (int i = 0; i < services.length; i++) {
        	if (services[i].getName().equalsIgnoreCase(printerName)) {
                docPrintJob = services[i].createPrintJob();
            }
        }
        job.setPrintService(docPrintJob.getPrintService());
        job.setPageable(new PDFPageable(pdf));
        job.print();
	}
}
