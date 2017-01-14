package org.ryh.baptis.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.concurrent.Priority;
import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.command.IndexDoneNotification;
import org.ryh.baptis.ui.BaptisWaves;

public interface IndexService extends Service{
		
    public static WaveType DO_INDEXING = WBuilder.waveType("INDEXING")
    		.items(BaptisWaves.INDEX)
    		.returnWaveType(IndexDoneNotification.DO_INDEXING_DONE)
    		.returnCommandClass(IndexDoneNotification.class)
    		.returnItem(JRebirthItems.voidItem);
    
    @Priority(PriorityLevel.High)
    void doIndexing(final File file, final Wave wave) throws IOException;
    
    Directory getIndex();
    
    StandardAnalyzer getAnalyzer();
    
    List<Databaptis> getIndexedData();
}
