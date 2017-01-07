package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.ryh.baptis.service.SearchServiceImpl;
import org.ryh.baptis.ui.BaptisWaves;

public class SearchCommand extends DefaultCommand{
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void initCommand() {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void perform(final Wave wave) {
    	returnData(SearchServiceImpl.class, SearchServiceImpl.DO_SEARCHING, wave.getData(BaptisWaves.SEARCH));
    }
	
}