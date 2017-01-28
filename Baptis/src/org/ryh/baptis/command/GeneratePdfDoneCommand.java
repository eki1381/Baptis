package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.ui.BaptisWaves;

public class GeneratePdfDoneCommand extends DefaultCommand{
	
	public static final WaveType DO_GENERATING_DONE = WBuilder.waveType("GENERATING_DONE");
	
	@Override
	protected void initCommand() {
		
	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		sendWave(BaptisWaves.DO_PRINT_DOC);
	}
}
