package org.ryh.baptis.service;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.service.DefaultService;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.command.IndexDoneNotification;
import org.ryh.baptis.command.LoadResultDoneCommand;

public class LoadingService extends DefaultService{

	public static WaveType DO_LOADING = WBuilder.waveType("LOADING")
    		.returnCommandClass(IndexDoneNotification.class)
    		.returnItem(JRebirthItems.voidItem);
	
	@Override
	protected void initService() {
		listen(DO_LOADING);
	}
	
	public void doLoading(Wave wave) throws InterruptedException{
		Thread.sleep(2000);
		callCommand(LoadResultDoneCommand.class);
	}
}
