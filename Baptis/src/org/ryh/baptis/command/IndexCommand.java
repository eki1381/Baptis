package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.ryh.baptis.service.IndexServiceImpl;
import org.ryh.baptis.ui.BaptisWaves;

public class IndexCommand extends DefaultCommand{
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void initCommand() {
        
    }
    
    @Override
    protected void perform(Wave wave) throws CommandException {
    	returnData(IndexServiceImpl.class, IndexServiceImpl.DO_INDEXING, wave.getData(BaptisWaves.INDEX));
    }

}
