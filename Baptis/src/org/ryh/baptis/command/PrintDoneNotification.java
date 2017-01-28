package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.jrebirth.af.core.wave.WBuilder;

public class PrintDoneNotification extends DefaultCommand{
	public static final WaveType DO_PRINTING_DONE = WBuilder.waveType("PRINTING_DONE");
	
	@Override
	protected void initCommand() {
		
	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		
	}
}
