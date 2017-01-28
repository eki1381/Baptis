package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.ui.BaptisWaves;

public class IndexDoneNotification extends DefaultCommand{
	
	public static final WaveType DO_INDEXING_DONE = WBuilder.waveType("INDEXING_DONE");
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void initCommand() {
    	listen(DO_INDEXING_DONE);
    }
    
    @Override
    protected void perform(Wave wave) throws CommandException {
    	sendWave(BaptisWaves.DO_HIDE_INDEX);
    }
}
