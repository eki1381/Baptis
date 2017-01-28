package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.ryh.baptis.service.PrinterServiceImpl;
import org.ryh.baptis.ui.BaptisWaves;

public class PrintCommand extends DefaultCommand{
	@Override
	protected void initCommand() {
		
	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		returnData(PrinterServiceImpl.class, PrinterServiceImpl.DO_PRINTING, wave.getData(BaptisWaves.PRINT));
	}
}
