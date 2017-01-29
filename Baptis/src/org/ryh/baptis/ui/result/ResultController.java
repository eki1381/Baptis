package org.ryh.baptis.ui.result;

import java.awt.print.PrinterJob;

import javax.print.PrintService;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Page;
import org.ryh.baptis.command.GeneratePdfCommand;
import org.ryh.baptis.ui.BaptisWaves;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ResultController extends DefaultController<ResultModel, ResultView>{

	public ResultController(ResultView view) throws CoreException {
		super(view);
	}
	
	@Override
	protected void initEventAdapters() throws CoreException {
		view().getPrintMenuButton().setOnAction(e -> printPdf(view().getPrintCombo().getSelectionModel().getSelectedItem().getText()));
		view().getCancelPrintMenuButton().setOnAction(e -> view().getPrintDialog().close());
		view().getBackButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getBackButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
		view().getPrintButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getPrintButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
		view().getCancelPrintMenuButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getCancelPrintMenuButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
		view().getPrintMenuButton().addEventFilter(MouseEvent.MOUSE_ENTERED, e -> changeCursor(true));
		view().getPrintMenuButton().addEventFilter(MouseEvent.MOUSE_EXITED, e -> changeCursor(false));
	}
	
	@Override
	protected void initEventHandlers() throws CoreException {
		// TODO Auto-generated method stub
		super.initEventHandlers();
	}
	
	public void onActionShow(final ActionEvent actionEvent){
		PrintService[] services = PrinterJob.lookupPrintServices();
		view().getPrintCombo().getItems().clear();
		for(int i = 0;i < services.length;i++){
			view().getPrintCombo().getItems().add(new Label(services[i].getName()));
		}
		view().getPrintCombo().getSelectionModel().select(0);
		view().getPrintDialog().show();
	}

	public void onActionBack(final ActionEvent actionEvent){
		model().sendWave(BaptisWaves.DO_SHOW_PAGE, WBuilder.waveData(BaptisWaves.PAGE, Page.Search));
	}
	
	public void printPdf(String printerName){
		callCommand(GeneratePdfCommand.class,WBuilder.waveData(BaptisWaves.GENERATE, model().object()));
	}
	
	private void changeCursor(boolean isEntered){
		if(isEntered){
			view().node().setCursor(Cursor.HAND);
		}else{
			view().node().setCursor(Cursor.DEFAULT);
		}
	}
}
