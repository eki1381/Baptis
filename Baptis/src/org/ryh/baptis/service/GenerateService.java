package org.ryh.baptis.service;

import java.io.IOException;

import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.DatabaptisProperty;
import org.ryh.baptis.command.GeneratePdfDoneCommand;
import org.ryh.baptis.ui.BaptisWaves;

import com.itextpdf.text.DocumentException;

public interface GenerateService extends Service{
	public static WaveType DO_GENERATING = WBuilder.waveType("GENERATING")
    		.items(BaptisWaves.GENERATE)
    		.returnWaveType(GeneratePdfDoneCommand.DO_GENERATING_DONE)
    		.returnCommandClass(GeneratePdfDoneCommand.class)
    		.returnItem(JRebirthItems.voidItem);
	
	public void doGenerating(final DatabaptisProperty databaptis, final Wave wave) throws DocumentException, IOException;
		
}
