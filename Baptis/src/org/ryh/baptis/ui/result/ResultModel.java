package org.ryh.baptis.ui.result;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.object.DefaultObjectModel;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.DatabaptisProperty;
import org.ryh.baptis.command.PrintCommand;
import org.ryh.baptis.ui.BaptisWaves;

public class ResultModel extends DefaultObjectModel<ResultModel, ResultView, DatabaptisProperty>{
	
	@Override
	protected void initModel() {
		listen(BaptisWaves.DO_PRINT_DOC);
	}

	@Override
	protected void bind() {
		view().getTitleLabel().textProperty().bind(object().getNAMAProperty());
		view().getNamaField().textProperty().bind(object().getNAMAProperty());
		view().getJnKelField().textProperty().bind(object().getDJNKELProperty());
		view().getTmptLahirField().textProperty().bind(object().getTMPLAHIRProperty());
		view().getTglLahirField().textProperty().bind(object().getDTGLLAHIRProperty());
		view().getParokiField().textProperty().bind(object().getPAROKIProperty());
		view().getKotaParokiField().textProperty().bind(object().getKOTAPAROKIProperty());
		view().getNamaStasiField().textProperty().bind(object().getNAMASTASIProperty());
		view().getAyahField().textProperty().bind(object().getAYAHProperty());
		view().getIbuField().textProperty().bind(object().getIBUProperty());
		view().getTmptBaptisField().textProperty().bind(object().getTMPBAPTISProperty());
		view().getTglBaptisField().textProperty().bind(object().getDTGLBAPTISProperty());
		view().getTmptKrismaField().textProperty().bind(object().getTMPKRISMAProperty());
		view().getTglKrismaField().textProperty().bind(object().getDTGLKRISMAProperty());
		view().getKawinDgnField().textProperty().bind(object().getKWDENGANProperty());
		view().getTglKawinField().textProperty().bind(object().getDTGLKWProperty());
		view().getTglMatiField().textProperty().bind(object().getDTGLMATIProperty());
		view().getBukuField().textProperty().bind(object().getBUKUProperty());
		view().getHalField().textProperty().bind(object().getHALProperty().asString());
		view().getNoField().textProperty().bind(object().getNOProperty().asString());
	}
	
	@Override
	protected void processWave(Wave wave) {
		super.processWave(wave);
	}
	
	public void doPrintDoc(final Wave wave){
		if(view().getPrintCombo().getSelectionModel().getSelectedItem() != null){
			callCommand(PrintCommand.class, WBuilder.waveData(BaptisWaves.PRINT, view().getPrintCombo().getSelectionModel().getSelectedItem().getText()));
			view().getPrintDialog().close();
		}
	}
}
