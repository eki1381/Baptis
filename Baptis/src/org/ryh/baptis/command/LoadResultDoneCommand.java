package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.ryh.baptis.ui.BaptisWaves;

public class LoadResultDoneCommand extends DefaultCommand{

	@Override
	protected void initCommand() {
		super.initCommand();
	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		sendWave(BaptisWaves.DO_VIEW_RESULT);
	}
	
}
