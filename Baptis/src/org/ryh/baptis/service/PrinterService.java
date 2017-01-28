package org.ryh.baptis.service;

import java.awt.print.PrinterException;
import java.io.IOException;

import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.concurrent.Priority;
import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.command.PrintDoneNotification;
import org.ryh.baptis.ui.BaptisWaves;

public interface PrinterService extends Service{
	public static WaveType DO_PRINTING = WBuilder.waveType("PRINTING")
    		.items(BaptisWaves.INDEX)
    		.returnWaveType(PrintDoneNotification.DO_PRINTING_DONE)
    		.returnCommandClass(PrintDoneNotification.class)
    		.returnItem(JRebirthItems.voidItem);
	
	@Priority(PriorityLevel.High)
    void doPrinting(final String printerName, final Wave wave) throws IOException, PrinterException ;
}
