package org.ryh.baptis.service;


import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.concurrent.Priority;
import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.command.ShowSearchResult;
import org.ryh.baptis.ui.BaptisWaves;

public interface SearchService extends Service{

	/** Perform searching. */
    public static WaveType DO_SEARCHING = WBuilder.waveType("SEARCHING")
    		.items(BaptisWaves.SEARCH)
    		.returnAction("SEARCHING_DONE")
    		.returnCommandClass(ShowSearchResult.class)
    		.returnItem(JRebirthItems.voidItem);
    
    @Priority(PriorityLevel.High)
    void doSearching(final String value, final Wave wave) throws ParseException, IOException, InterruptedException;
	
}
