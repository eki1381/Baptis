package org.ryh.baptis.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.service.DefaultService;
import org.ryh.baptis.beans.DatabaptisProperty;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateServiceImpl extends DefaultService implements GenerateService{
	
	public static final String RESULT = "src/FirstPdf.pdf";
    public static final String FONT = "src/resources/Roboto-Regular.ttf";
    public static final String FONT_BOLD = "src/resources/Roboto-Bold.ttf";

	@Override
	public void doGenerating(DatabaptisProperty databaptis, Wave wave) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        
        document.open();
        
        writer.setCompressionLevel(0);
        BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        BaseFont bfb = BaseFont.createFont(FONT_BOLD, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        
        SimpleDateFormat dt1 = new SimpleDateFormat("dd MMMM");
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy");
        SimpleDateFormat dt3 = new SimpleDateFormat("dd MMMM yyyy");
        
        Phrase PAROKI = new Phrase(databaptis.getPAROKI(), new Font(bf));
        Phrase KOTAPAROKI = new Phrase(databaptis.getKOTAPAROKI(), new Font(bf));
        Phrase BUKU = new Phrase(databaptis.getBUKU(), new Font(bf));
        Phrase HAL = new Phrase(String.valueOf(databaptis.getHAL()), new Font(bf));
        Phrase NO = new Phrase(String.valueOf(databaptis.getNO()), new Font(bf));
        Phrase TGLLAHIRTAHUN, TGLLAHIR;
        if(String.valueOf(databaptis.getTGLLAHIR()).equals("Tue Oct 06 00:00:00 ICT 17793")){
        	TGLLAHIRTAHUN = new Phrase("", new Font(bf));
            TGLLAHIR = new Phrase("", new Font(bf));
		}else{
			TGLLAHIRTAHUN = new Phrase(dt2.format(databaptis.getTGLLAHIR()), new Font(bf));
	        TGLLAHIR = new Phrase(dt1.format(databaptis.getTGLLAHIR()), new Font(bf));
		}
        Phrase TMPLAHIR = new Phrase(databaptis.getTMPLAHIR(), new Font(bf));
        Phrase TGLBAPTISTAHUN, TGLBAPTIS;
        if(String.valueOf(databaptis.getTGLBAPTIS()).equals("Tue Oct 06 00:00:00 ICT 17793")){
        	TGLBAPTISTAHUN = new Phrase("", new Font(bf));
            TGLBAPTIS = new Phrase("", new Font(bf));
		}else{
			TGLBAPTISTAHUN = new Phrase(dt2.format(databaptis.getTGLBAPTIS()), new Font(bf));
	        TGLBAPTIS = new Phrase(dt1.format(databaptis.getTGLBAPTIS()), new Font(bf));
		}
        Phrase PAROKI2 = new Phrase(databaptis.getPAROKI(), new Font(bf));
        Phrase NAMASTASI = new Phrase(databaptis.getNAMASTASI(), new Font(bf));
        Phrase NAMA = new Phrase(databaptis.getNAMA(), new Font(bfb));
        Phrase AYAH = new Phrase(databaptis.getAYAH(), new Font(bf));
        Phrase IBU = new Phrase(databaptis.getIBU(), new Font(bf));
        Phrase WALIBAPTIS = new Phrase(databaptis.getWALIBAPTIS(), new Font(bf));
        Phrase YGBAPTIS = new Phrase(databaptis.getYGBAPTIS(), new Font(bf));
        Phrase TGLKRISMA;
        if(String.valueOf(databaptis.getTGLKRISMA()).equals("Tue Oct 06 00:00:00 ICT 17793")){
        	TGLKRISMA = new Phrase("", new Font(bf));
		}else{
			TGLKRISMA = new Phrase(dt3.format(databaptis.getTGLKRISMA()), new Font(bf));
		}
        Phrase PRKKRISMA = new Phrase(databaptis.getPRKKRISMA(), new Font(bf));
        Phrase TMPKRISMA = new Phrase(databaptis.getTMPKRISMA(), new Font(bf));
        Phrase KWDENGAN = new Phrase(databaptis.getKWDENGAN(), new Font(bf));
        Phrase TGLMATI;
        if(String.valueOf(databaptis.getTGLMATI()).equals("Tue Oct 06 00:00:00 ICT 17793")){
        	TGLMATI = new Phrase("", new Font(bf));
		}else{
			TGLMATI = new Phrase(dt3.format(databaptis.getTGLMATI()), new Font(bf));
		}
        Phrase TMPMATI = new Phrase(databaptis.getTMPMATI(), new Font(bf));
        
        PdfContentByte canvas = writer.getDirectContentUnder();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, PAROKI, 560, 520, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, KOTAPAROKI, 525, 490, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, BUKU, 505, 460, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, HAL, 610, 460, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, NO, 705, 460, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLLAHIRTAHUN, 80, 430, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLLAHIR, 200, 430, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TMPLAHIR, 420, 430, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLBAPTISTAHUN, 80, 400, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLBAPTIS, 200, 400, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, PAROKI2, 410, 400, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, NAMASTASI, 565, 400, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, NAMA, 450, 370, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, AYAH, 220, 320, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, IBU, 600, 320, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, WALIBAPTIS, 150, 290, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, YGBAPTIS, 600, 290, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLKRISMA, 200, 265, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, PRKKRISMA, 470, 265, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TMPKRISMA, 680, 265, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, KWDENGAN, 200, 235, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TGLMATI, 145, 205, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TMPMATI, 610, 205, 0);

        document.close();
	}

}
