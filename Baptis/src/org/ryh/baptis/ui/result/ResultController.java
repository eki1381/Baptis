package org.ryh.baptis.ui.result;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Page;
import org.ryh.baptis.ui.BaptisWaves;

import javafx.event.ActionEvent;

public class ResultController extends DefaultController<ResultModel, ResultView>{

	public ResultController(ResultView view) throws CoreException {
		super(view);
	}
	
	@Override
	protected void initEventAdapters() throws CoreException {
		// TODO Auto-generated method stub
		super.initEventAdapters();
	}
	
	@Override
	protected void initEventHandlers() throws CoreException {
		// TODO Auto-generated method stub
		super.initEventHandlers();
	}

	public void onActionBack(final ActionEvent actionEvent){
		model().sendWave(BaptisWaves.DO_SHOW_PAGE, WBuilder.waveData(BaptisWaves.PAGE, Page.Search));
	}
}
