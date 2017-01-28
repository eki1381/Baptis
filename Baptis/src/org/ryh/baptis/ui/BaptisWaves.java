package org.ryh.baptis.ui;

import static org.jrebirth.af.core.wave.WBuilder.waveType;

import java.io.File;
import org.jrebirth.af.api.module.Preloadable;
import org.jrebirth.af.api.wave.contract.WaveItem;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.WaveItemBase;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.beans.DatabaptisProperty;
import org.ryh.baptis.beans.Page;

import javafx.collections.ObservableList;


public interface BaptisWaves extends Preloadable{
	
	/** The page to display. */
	WaveItem<Page> PAGE = new WaveItemBase<Page>(){};

	/** The start action code. */
    String SHOW_PAGE = "SHOW_PAGE";

    /** Show Page action. */
    WaveType DO_SHOW_PAGE = waveType(SHOW_PAGE).items(PAGE);
    
    /** Search property to display. */
	WaveItem<File> INDEX = new WaveItemBase<File>(){};

	/** The start action code. */
    String INDEX_DOC = "INDEX_DOC";

    /** Search property to display. */
	WaveItem<Databaptis> SEARCH = new WaveItemBase<Databaptis>(){};

	/** The start action code. */
    String SEARCH_KEYWORD = "SEARCH_KEYWORD";
    
    String SHOW_RESULT = "SHOW_RESULT";

    WaveItem<ObservableList<Databaptis>> RESULT = new WaveItemBase<ObservableList<Databaptis>>(){};
    
    WaveType DO_SHOW_RESULT = waveType(SHOW_RESULT).items(RESULT);
    
    String SHOW_DATA = "SHOW_DATA";
    
    WaveItem<Databaptis> DATA = new WaveItemBase<Databaptis>(){};
    
    WaveType DO_SHOW_DATA = waveType(SHOW_DATA).items(DATA);
    
    WaveType DO_NOTIFY_RESULT = waveType("NOTIFY_RESULT");
    
    String LOADING = "LOADING";
    
    WaveType DO_LOADING = waveType(LOADING);
    
    String VIEW_RESULT = "VIEW_RESULT";
    
    WaveType DO_VIEW_RESULT = waveType(VIEW_RESULT);
    
    WaveItem<String> PRINT = new WaveItemBase<String>(){};
    
    WaveItem<DatabaptisProperty> GENERATE = new WaveItemBase<DatabaptisProperty>(){};
    
    WaveType DO_HIDE_INDEX = waveType("HIDE_INDEX");
    
    WaveItem<String> HIDE = new WaveItemBase<String>(){};
    
    WaveType DO_PRINT_DOC = waveType("PRINT_DOC");
}
