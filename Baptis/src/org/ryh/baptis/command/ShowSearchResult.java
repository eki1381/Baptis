package org.ryh.baptis.command;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.single.internal.DefaultCommand;
import org.jrebirth.af.core.exception.CommandException;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.service.SearchServiceImpl;
import org.ryh.baptis.ui.BaptisWaves;

public class ShowSearchResult extends DefaultCommand{

	@Override
    protected void initCommand() {
    	
    }
    
    @Override
    protected void perform(Wave wave) throws CommandException {
    	final SearchServiceImpl service = getService(SearchServiceImpl.class);
    	sendWave(BaptisWaves.DO_SHOW_RESULT, WBuilder.waveData(BaptisWaves.RESULT,service.getSearchResult()));    }
}
