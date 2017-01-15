package org.ryh.baptis.ui.search;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.ui.adapter.KeyAdapter;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.beans.Page;
import org.ryh.baptis.command.SearchCommand;
import org.ryh.baptis.ui.BaptisWaves;

import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SearchController extends DefaultController<SearchModel, SearchView> implements KeyAdapter{
	
	private Databaptis databaptis;
	
	public SearchController(final SearchView view) throws CoreException {
		super(view);
	}

	@Override
	protected void initEventAdapters() throws CoreException {
		view().node().addEventFilter(KeyEvent.KEY_RELEASED, getHandler(KeyEvent.KEY_RELEASED));
		view().getList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Databaptis>() {
			@Override
			public void changed(ObservableValue<? extends Databaptis> arg0, Databaptis arg1, Databaptis arg2) {
				bind(arg0.getValue());
				model().sendWave(BaptisWaves.DO_SHOW_PAGE, WBuilder.waveData(BaptisWaves.PAGE, Page.Result));
			}
		});
		view().getSearchButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getSearchButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
		view().getSettingButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getSettingButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
		view().getDownArrowImg().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> advSearchLabelMouseEntered(true));
		view().getDownArrowImg().addEventFilter(MouseEvent.MOUSE_EXITED, e -> advSearchLabelMouseEntered(false));
		view().getAdvSearchLabel().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> advSearchLabelMouseEntered(true));
		view().getAdvSearchLabel().addEventFilter(MouseEvent.MOUSE_EXITED, e -> advSearchLabelMouseEntered(false));
		view().getDownArrowImg().addEventFilter(MouseEvent.MOUSE_CLICKED, e -> showAdvPopUp());
		view().getAdvSearchLabel().addEventFilter(MouseEvent.MOUSE_CLICKED, e -> showAdvPopUp());
		view().getAdvCancelButton().addEventFilter(MouseEvent.MOUSE_CLICKED, e -> view().getAdvPopUp().close());
		view().getAdvOkButton().addEventFilter(MouseEvent.MOUSE_CLICKED, e -> advSearching());
	}
	
	private void advSearchLabelMouseEntered(boolean isEntered){
		if(isEntered){
			view().getAdvSearchLabel().setUnderline(true);
			changeCursor(isEntered);
		}else{
			view().getAdvSearchLabel().setUnderline(false);
			changeCursor(isEntered);
		}
	}
	
	private void changeCursor(boolean isEntered){
		if(isEntered){
			view().node().setCursor(Cursor.HAND);
		}else{
			view().node().setCursor(Cursor.DEFAULT);
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		switch(keyEvent.getCode()){
		case ENTER :  if(node().getScene().getFocusOwner() == view().getSearchField()){
			if(view().getSearchField().getText() == null || view().getSearchField().getText().equals("")){
				view().getNullErrorDialog().show();
			}else{
				view().showLoadingAnimation();
				databaptis = new Databaptis();
				databaptis.setNAMA(model().getSearchObject());
				callCommand(SearchCommand.class,WBuilder.waveData(BaptisWaves.SEARCH, databaptis));
			}
			}	
		break;
		default:
			break;
		}
	}

	@Override
	protected void initEventHandlers() throws CoreException {

	}

	public void onActionSearch(final ActionEvent actionEvent){
		if(view().getSearchField().getText() == null || view().getSearchField().getText().equals("")){
			view().getNullErrorDialog().show();
		}else{
			view().showLoadingAnimation();
			databaptis = new Databaptis();
			databaptis.setNAMA(model().getSearchObject());
			callCommand(SearchCommand.class,WBuilder.waveData(BaptisWaves.SEARCH, databaptis));
		}
	}
	
	public void onActionSettings(final ActionEvent actionEvent){
		view().getPopUp().show(PopupVPosition.TOP, PopupHPosition.RIGHT);
	}
	
	public void onActionChoose(final ActionEvent actionEvent){
		model().showFileChooser();
		view().getPopUp().close();
	}
	
	public void showAdvPopUp(){
		view().getRoot().setCenter(null);
		view().getAdvPopUp().show(PopupVPosition.TOP, PopupHPosition.RIGHT);
	}
	
	public void advSearching(){
		view().showLoadingAnimation();
		databaptis = new Databaptis();
		if(view().getNameAdvField().getText().length() > 0){
			databaptis.setNAMA(view().getNameAdvField().getText());
		}
		if(view().getDatePicker().getValue() != null){
			LocalDate localDate = view().getDatePicker().getValue();
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			databaptis.setTGLLAHIR(date);
		}
		if(view().getParishAdvField().getText().length() > 0){
			databaptis.setPAROKI(view().getParishAdvField().getText());
		}
		if(view().getParishCityAdvField().getText().length() > 0){
			databaptis.setKOTAPAROKI(view().getParishCityAdvField().getText());
		}
		callCommand(SearchCommand.class,WBuilder.waveData(BaptisWaves.SEARCH, databaptis));
		view().getAdvPopUp().close();
	}

	private void bind(Databaptis arg0){
		SimpleDateFormat dt = new SimpleDateFormat("dd MMMM yyyy");
		model().object().setPAROKI(arg0.getPAROKI());
		model().object().setKOTAPAROKI(arg0.getKOTAPAROKI());
		model().object().setKDSTASI(arg0.getKDSTASI());
		model().object().setNAMASTASI(arg0.getNAMASTASI());
		model().object().setBUKU(arg0.getBUKU());
		model().object().setNAMA(arg0.getNAMA());
		model().object().setTMPLAHIR(arg0.getTMPLAHIR());
		model().object().setTMPBAPTIS(arg0.getTMPBAPTIS());
		model().object().setTERIMADR(arg0.getTERIMADR());
		model().object().setTERIMADI(arg0.getTERIMADI());
		model().object().setAYAH(arg0.getAYAH());
		model().object().setIBU(arg0.getIBU());
		model().object().setWALIBAPTIS(arg0.getWALIBAPTIS());
		model().object().setYGBAPTIS(arg0.getYGBAPTIS());
		model().object().setYGTERIMA(arg0.getYGTERIMA());
		model().object().setPRKKRISMA(arg0.getPRKKRISMA());
		model().object().setTMPKRISMA(arg0.getTMPKRISMA());
		model().object().setKWDENGAN(arg0.getKWDENGAN());
		model().object().setPRKKW(arg0.getPRKKW());
		model().object().setTMPKW(arg0.getTMPKW());
		model().object().setLM(arg0.getLM());
		model().object().setLMNO(arg0.getLMNO());
		model().object().setTMPMATI(arg0.getTMPMATI());
		model().object().setNOTANDA(arg0.getNOTANDA());
		model().object().setNOTANDA1(arg0.getNOTANDA1());
		model().object().setNOTANDA3(arg0.getNOTANDA3());
		model().object().setNOTANDA5(arg0.getNOTANDA5());
		model().object().setHAL(arg0.getHAL());
		model().object().setNO(arg0.getNO());
		model().object().setJNKEL(arg0.getJNKEL());
		model().object().setJNNOTANDA(arg0.getJNNOTANDA());
		model().object().setTGLLAHIR(arg0.getTGLLAHIR());
		model().object().setTGLBAPTIS(arg0.getTGLBAPTIS());
		model().object().setTERIMATGL(arg0.getTERIMATGL());
		model().object().setTGLKRISMA(arg0.getTGLKRISMA());
		model().object().setTGLKW(arg0.getTGLKW());
		model().object().setTGLMATI(arg0.getTGLMATI());
		model().object().setNOTANDA2(arg0.getNOTANDA2());
		model().object().setNOTANDA4(arg0.getNOTANDA4());
		if(model().object().getJNKEL() == 1){
			model().object().setDJNKEL("PRIA");
		}else{
			model().object().setDJNKEL("WANITA");
		}
		if(String.valueOf(model().object().getTGLLAHIR()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			model().object().setDTGLLAHIR("");
		}else{
			model().object().setDTGLLAHIR(dt.format(model().object().getTGLLAHIR()));
		}
		if(String.valueOf(model().object().getTGLBAPTIS()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			model().object().setDTGLBAPTIS("");
		}else{
			model().object().setDTGLBAPTIS(dt.format(model().object().getTGLBAPTIS()));
		}
		if(String.valueOf(model().object().getTGLKRISMA()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			model().object().setDTGLKRISMA("");
		}else{
			model().object().setDTGLKRISMA(dt.format(model().object().getTGLKRISMA()));
		}
		if(String.valueOf(model().object().getTGLKW()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			model().object().setDTGLKW("");
		}else{
			model().object().setDTGLKW(dt.format(model().object().getTGLKW()));
		}
		if(String.valueOf(model().object().getTGLMATI()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			model().object().setDTGLMATI("");
		}else{
			model().object().setDTGLMATI(dt.format(model().object().getTGLMATI()));
		}
	}
}
