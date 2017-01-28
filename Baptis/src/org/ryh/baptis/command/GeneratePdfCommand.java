package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.ryh.baptis.service.GenerateServiceImpl;
import org.ryh.baptis.ui.BaptisWaves;

public class GeneratePdfCommand extends DefaultCommand{

	@Override
	protected void initCommand() {

	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		returnData(GenerateServiceImpl.class, GenerateServiceImpl.DO_GENERATING, wave.getData(BaptisWaves.GENERATE));
	}
	
}
