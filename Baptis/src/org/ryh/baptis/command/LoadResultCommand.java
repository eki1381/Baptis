package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.ryh.baptis.service.LoadingService;

public class LoadResultCommand extends DefaultCommand{

	@Override
	protected void initCommand() {
		super.initCommand();
	}
	
	@Override
	protected void perform(Wave wave) throws CommandException {
		returnData(LoadingService.class, LoadingService.DO_LOADING);
	}
	
}
