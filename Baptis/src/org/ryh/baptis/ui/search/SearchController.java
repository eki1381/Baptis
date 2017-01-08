package org.ryh.baptis.ui.search;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.ui.adapter.KeyAdapter;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.beans.Page;
import org.ryh.baptis.command.LoadResultCommand;
import org.ryh.baptis.command.SearchCommand;
import org.ryh.baptis.ui.BaptisWaves;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

public class SearchController extends DefaultController<SearchModel, SearchView> implements KeyAdapter{

	public SearchController(final SearchView view) throws CoreException {
		super(view);
	}

	@Override
	protected void initEventAdapters() throws CoreException {
		view().node().addEventFilter(KeyEvent.KEY_RELEASED, getHandler(KeyEvent.KEY_RELEASED));
		view().getList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Databaptis>() {
			@Override
			public void changed(ObservableValue<? extends Databaptis> arg0, Databaptis arg1, Databaptis arg2) {
				model().sendWave(BaptisWaves.DO_SHOW_PAGE, WBuilder.waveData(BaptisWaves.PAGE, Page.Result));
				model().selectedData = arg0.getValue();
				callCommand(LoadResultCommand.class);
				model().sendWave(BaptisWaves.DO_SHOW_DATA, WBuilder.waveData(BaptisWaves.DATA, arg0.getValue()));
			}
		});
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		switch(keyEvent.getCode()){
		case ENTER :  if(node().getScene().getFocusOwner() == view().getSearchField()){view().showLoadingAnimation();
		callCommand(SearchCommand.class,WBuilder.waveData(BaptisWaves.SEARCH, model().getSearchObject()));}	
		break;
		default:
			break;
		}
	}

	@Override
	protected void initEventHandlers() throws CoreException {

	}

	public void onActionSearch(final ActionEvent actionEvent){
		view().showLoadingAnimation();
		callCommand(SearchCommand.class,WBuilder.waveData(BaptisWaves.SEARCH, model().getSearchObject()));
	}

}
