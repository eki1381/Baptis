package org.ryh.baptis.ui.result;

import java.text.SimpleDateFormat;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.DefaultModel;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.ui.BaptisWaves;

public class ResultModel extends DefaultModel<ResultModel, ResultView>{
	@Override
	protected void initModel() {
		listen(BaptisWaves.DO_SHOW_DATA);
		listen(BaptisWaves.DO_VIEW_RESULT);
	}
	
	@Override
	protected void initInnerComponents() {
		super.initInnerComponents();
	}
	
	@Override
	protected void bind() {
		super.bind();
	}
	
	@Override
	protected void processWave(Wave wave) {
		super.processWave(wave);
	}
	
	public void doShowData(final Databaptis data, final Wave wave){
		System.out.println("dasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
		SimpleDateFormat dt = new SimpleDateFormat("dd MMMM yyyy");
		view().getTitleLabel().setText(data.getNAMA());
		view().getNamaField().setText(data.getNAMA());
		if(data.getJNKEL() == 1){
			view().getJnKelField().setText("PRIA");
		}else{
			view().getJnKelField().setText("WANITA");
		}
		view().getTmptLahirField().setText(data.getTMPLAHIR());
		if(String.valueOf(data.getTGLLAHIR()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			view().getTglLahirField().setText("");
		}else{
			view().getTglLahirField().setText(dt.format(data.getTGLLAHIR()));
		}
		view().getParokiField().setText(data.getPAROKI());
		view().getKotaParokiField().setText(data.getKOTAPAROKI());
		view().getNamaStasiField().setText(data.getNAMASTASI());
		view().getAyahField().setText(data.getAYAH());
		view().getIbuField().setText(data.getIBU());
		view().getTmptBaptisField().setText(data.getTMPBAPTIS());
		if(String.valueOf(data.getTGLBAPTIS()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			view().getTglBaptisField().setText("");
		}else{
			view().getTglBaptisField().setText(dt.format(data.getTGLBAPTIS()));
		}
		view().getTmptKrismaField().setText(data.getTMPKRISMA());
		if(String.valueOf(data.getTGLKRISMA()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			view().getTglKrismaField().setText("");
		}else{
			view().getTglKrismaField().setText(dt.format(data.getTGLKRISMA()));
		}
		view().getKawinDgnField().setText(data.getKWDENGAN());
		if(String.valueOf(data.getTGLKW()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			view().getTglKawinField().setText("");
		}else{
			view().getTglKawinField().setText(dt.format(data.getTGLKW()));
		}
		if(String.valueOf(data.getTGLMATI()).equals("Tue Oct 06 00:00:00 ICT 17793")){
			view().getTglMatiField().setText("");
		}else{
			view().getTglMatiField().setText(dt.format(data.getTGLMATI()));
		}
		view().getBukuField().setText(data.getBUKU());
		view().getHalField().setText(String.valueOf(data.getHAL()));
		view().getNoField().setText(String.valueOf(data.getNO()));
	}
	
	public void doViewResult(final Wave wave){
		view().node().setTop(view().getTopPane());
	}
}
