package org.ryh.baptis.beans;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DatabaptisProperty {
	StringProperty PAROKI = new SimpleStringProperty();
	StringProperty KOTAPAROKI = new SimpleStringProperty();
	StringProperty KDSTASI = new SimpleStringProperty();
	StringProperty NAMASTASI = new SimpleStringProperty();
	StringProperty BUKU = new SimpleStringProperty();
	StringProperty NAMA = new SimpleStringProperty("");
	StringProperty TMPLAHIR = new SimpleStringProperty();
	StringProperty TMPBAPTIS = new SimpleStringProperty();
	StringProperty TERIMADR = new SimpleStringProperty();
	StringProperty TERIMADI = new SimpleStringProperty();
	StringProperty AYAH = new SimpleStringProperty();
	StringProperty IBU = new SimpleStringProperty();
	StringProperty WALIBAPTIS = new SimpleStringProperty();
	StringProperty YGBAPTIS = new SimpleStringProperty();
	StringProperty YGTERIMA = new SimpleStringProperty();
	StringProperty PRKKRISMA = new SimpleStringProperty();
	StringProperty TMPKRISMA = new SimpleStringProperty();
	StringProperty KWDENGAN = new SimpleStringProperty();
	StringProperty PRKKW = new SimpleStringProperty();
	StringProperty TMPKW = new SimpleStringProperty();
	StringProperty LM = new SimpleStringProperty();
	StringProperty LMNO = new SimpleStringProperty();
	StringProperty TMPMATI = new SimpleStringProperty();
	StringProperty NOTANDA = new SimpleStringProperty();
	StringProperty NOTANDA1 = new SimpleStringProperty();
	StringProperty NOTANDA3 = new SimpleStringProperty();
	StringProperty NOTANDA5 = new SimpleStringProperty();
	StringProperty dJNKEL = new SimpleStringProperty();
	StringProperty dTGLLAHIR = new SimpleStringProperty();
	StringProperty dTGLBAPTIS = new SimpleStringProperty();
	StringProperty dTERIMATGL = new SimpleStringProperty();
	StringProperty dTGLKRISMA = new SimpleStringProperty();
	StringProperty dTGLKW = new SimpleStringProperty();
	StringProperty dTGLMATI = new SimpleStringProperty();
	StringProperty dNOTANDA2 = new SimpleStringProperty();
	StringProperty dNOTANDA4 = new SimpleStringProperty();
	
	IntegerProperty HAL = new SimpleIntegerProperty();
	IntegerProperty NO = new SimpleIntegerProperty();
	IntegerProperty JNKEL = new SimpleIntegerProperty();
	IntegerProperty JNNOTANDA = new SimpleIntegerProperty();
	
	ObjectProperty<Date>TGLLAHIR = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>TGLBAPTIS = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>TERIMATGL = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>TGLKRISMA = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>TGLKW = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>TGLMATI = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>NOTANDA2 = new SimpleObjectProperty<Date>();
	ObjectProperty<Date>NOTANDA4 = new SimpleObjectProperty<Date>();

	public DatabaptisProperty() {
		super();
	}
	
	public DatabaptisProperty(String pAROKI, String kOTAPAROKI, String kDSTASI, String nAMASTASI, String bUKU, int hAL, 
			int nO, String nAMA, int jNKEL, String tMPLAHIR, Date tGLLAHIR, String tMPBAPTIS, Date tGLBAPTIS,
			String tERIMADR, String tERIMADI, Date tERIMATGL, String aYAH, String iBU, String wALIBAPTIS, 
			String yGBAPTIS, String yGTERIMA, String pRKKRISMA, String tMPKRISMA, Date tGLKRISMA, String kWDENGAN,
			String pRKKW, String tMPKW, Date tGLKW, String lM, String lMNO, String tMPMATI, Date tGLMATI, int jNNOTANDA,
			String nOTANDA, String nOTANDA1, Date nOTANDA2, String nOTANDA3, Date nOTANDA4, String nOTANDA5) {
		super();
		PAROKI.set(pAROKI);
		KOTAPAROKI.set(kOTAPAROKI);
		KDSTASI.set(kDSTASI);
		NAMASTASI.set(nAMASTASI);
		BUKU.set(bUKU);
		NAMA.set(nAMA);
		TMPLAHIR.set(tMPLAHIR);
		TMPBAPTIS.set(tMPBAPTIS);
		TERIMADR.set(tERIMADR);
		TERIMADI.set(tERIMADI);
		AYAH.set(aYAH);
		IBU.set(iBU);
		WALIBAPTIS.set(wALIBAPTIS);
		YGBAPTIS.set(yGBAPTIS);
		YGTERIMA.set(yGTERIMA);
		PRKKRISMA.set(pRKKRISMA);
		TMPKRISMA.set(tMPKRISMA);
		KWDENGAN.set(kWDENGAN);
		PRKKW.set(pRKKW);
		TMPKW.set(tMPKW);
		LM.set(lM);
		LMNO.set(lMNO);
		TMPMATI.set(tMPMATI);
		NOTANDA.set(nOTANDA);
		NOTANDA1.set(nOTANDA1);
		NOTANDA3.set(nOTANDA3);
		NOTANDA5.set(nOTANDA5);
		HAL.set(hAL);
		NO.set(nO);
		JNKEL.set(jNKEL);
		JNNOTANDA.set(jNNOTANDA);
		TGLLAHIR.set(tGLLAHIR);
		TGLBAPTIS.set(tGLBAPTIS);
		TERIMATGL.set(tERIMATGL);
		TGLKRISMA.set(tGLKRISMA);
		TGLKW.set(tGLKW);
		TGLMATI.set(tGLMATI);
		NOTANDA2.set(nOTANDA2);
		NOTANDA4.set(nOTANDA4);
	}
	
	public StringProperty getPAROKIProperty(){
		return PAROKI;
	}

	public String getPAROKI() {
		return PAROKI.get();
	}

	public void setPAROKI(String pAROKI) {
		PAROKI.set(pAROKI);;
	}
	
	public StringProperty getKOTAPAROKIProperty(){
		return KOTAPAROKI;
	}

	public String getKOTAPAROKI() {
		return KOTAPAROKI.get();
	}

	public void setKOTAPAROKI(String kOTAPAROKI) {
		KOTAPAROKI.set(kOTAPAROKI);
	}
	
	public StringProperty getKDSTASIProperty(){
		return KDSTASI;
	}

	public String getKDSTASI() {
		return KDSTASI.get();
	}

	public void setKDSTASI(String kDSTASI) {
		KDSTASI.set(kDSTASI);
	}

	public StringProperty getNAMASTASIProperty(){
		return NAMASTASI;
	}
	
	public String getNAMASTASI() {
		return NAMASTASI.get();
	}

	public void setNAMASTASI(String nAMASTASI) {
		NAMASTASI.set(nAMASTASI);
	}

	public StringProperty getBUKUProperty(){
		return BUKU;
	}
	
	public String getBUKU() {
		return BUKU.get();
	}

	public void setBUKU(String bUKU) {
		BUKU.set(bUKU);
	}
	
	public StringProperty getNAMAProperty(){
		return NAMA;
	}

	public String getNAMA() {
		return NAMA.get();
	}

	public void setNAMA(String nAMA) {
		NAMA.set(nAMA);
	}
	
	public StringProperty getTMPLAHIRProperty(){
		return TMPLAHIR;
	}

	public String getTMPLAHIR() {
		return TMPLAHIR.get();
	}

	public void setTMPLAHIR(String tMPLAHIR) {
		TMPLAHIR.set(tMPLAHIR);
	}
	
	public StringProperty getTMPBAPTISProperty(){
		return TMPBAPTIS;
	}

	public String getTMPBAPTIS() {
		return TMPBAPTIS.get();
	}

	public void setTMPBAPTIS(String tMPBAPTIS) {
		TMPBAPTIS.set(tMPBAPTIS);
	}
	
	public StringProperty getTERIMADRProperty(){
		return TERIMADR;
	}

	public String getTERIMADR() {
		return TERIMADR.get();
	}

	public void setTERIMADR(String tERIMADR) {
		TERIMADR.set(tERIMADR);
	}
	
	public StringProperty getTERIMADIProperty(){
		return TERIMADI;
	}

	public String getTERIMADI() {
		return TERIMADI.get();
	}

	public void setTERIMADI(String tERIMADI) {
		TERIMADI.set(tERIMADI);
	}
	
	public StringProperty getAYAHProperty(){
		return AYAH;
	}

	public String getAYAH() {
		return AYAH.get();
	}

	public void setAYAH(String aYAH) {
		AYAH.set(aYAH);
	}

	public StringProperty getIBUProperty(){
		return IBU;
	}
	
	public String getIBU() {
		return IBU.get();
	}

	public void setIBU(String iBU) {
		IBU.set(iBU);
	}

	public StringProperty getWALIBAPTISProperty(){
		return WALIBAPTIS;
	}
	
	public String getWALIBAPTIS() {
		return WALIBAPTIS.get();
	}

	public void setWALIBAPTIS(String wALIBAPTIS) {
		WALIBAPTIS.set(wALIBAPTIS);
	}
	
	public StringProperty getYGBAPTISProperty(){
		return YGBAPTIS;
	}

	public String getYGBAPTIS() {
		return YGBAPTIS.get();
	}

	public void setYGBAPTIS(String yGBAPTIS) {
		YGBAPTIS.set(yGBAPTIS);
	}
	
	public StringProperty getYGTERIMAProperty(){
		return YGTERIMA;
	}

	public String getYGTERIMA() {
		return YGTERIMA.get();
	}

	public void setYGTERIMA(String yGTERIMA) {
		YGTERIMA.set(yGTERIMA);
	}
	
	public StringProperty getPRKKRISMAProperty(){
		return PRKKRISMA;
	}

	public String getPRKKRISMA() {
		return PRKKRISMA.get();
	}

	public void setPRKKRISMA(String pRKKRISMA) {
		PRKKRISMA.set(pRKKRISMA);
	}

	public StringProperty getTMPKRISMAProperty(){
		return TMPKRISMA;
	}
	
	public String getTMPKRISMA() {
		return TMPKRISMA.get();
	}

	public void setTMPKRISMA(String tMPKRISMA) {
		TMPKRISMA.set(tMPKRISMA);
	}
	
	public StringProperty getKWDENGANProperty(){
		return KWDENGAN;
	}

	public String getKWDENGAN() {
		return KWDENGAN.get();
	}

	public void setKWDENGAN(String kWDENGAN) {
		KWDENGAN.set(kWDENGAN);
	}
	
	public StringProperty getPRKKWProperty(){
		return PRKKW;
	}

	public String getPRKKW() {
		return PRKKW.get();
	}

	public void setPRKKW(String pRKKW) {
		PRKKW.set(pRKKW);
	}
	
	public StringProperty getTMPKWProperty(){
		return TMPKW;
	}

	public String getTMPKW() {
		return TMPKW.get();
	}

	public void setTMPKW(String tMPKW) {
		TMPKW.set(tMPKW);
	}
	
	public StringProperty getLMProperty(){
		return LM;
	}

	public String getLM() {
		return LM.get();
	}

	public void setLM(String lM) {
		LM.set(lM);
	}
	
	public StringProperty getLMNOProperty(){
		return LMNO;
	}

	public String getLMNO() {
		return LMNO.get();
	}

	public void setLMNO(String lMNO) {
		LMNO.set(lMNO);
	}
	
	public StringProperty getTMPMATIProperty(){
		return TMPMATI;
	}

	public String getTMPMATI() {
		return TMPMATI.get();
	}

	public void setTMPMATI(String tMPMATI) {
		TMPMATI.set(tMPMATI);
	}
	
	public StringProperty getNOTANDAProperty(){
		return NOTANDA;
	}

	public String getNOTANDA() {
		return NOTANDA.get();
	}

	public void setNOTANDA(String nOTANDA) {
		NOTANDA.set(nOTANDA);
	}
	
	public StringProperty getNOTANDA1Property(){
		return NOTANDA1;
	}

	public String getNOTANDA1() {
		return NOTANDA1.get();
	}

	public void setNOTANDA1(String nOTANDA1) {
		NOTANDA1.set(nOTANDA1);
	}
	
	public StringProperty getNOTANDA3Property(){
		return NOTANDA3;
	}

	public String getNOTANDA3() {
		return NOTANDA3.get();
	}

	public void setNOTANDA3(String nOTANDA3) {
		NOTANDA3.set(nOTANDA3);
	}
	
	public StringProperty getNOTANDA5Property(){
		return NOTANDA5;
	}

	public String getNOTANDA5() {
		return NOTANDA5.get();
	}

	public void setNOTANDA5(String nOTANDA5) {
		NOTANDA5.set(nOTANDA5);
	}
	
	public IntegerProperty getHALProperty(){
		return HAL;
	}

	public int getHAL() {
		return HAL.get();
	}

	public void setHAL(int hAL) {
		HAL.set(hAL);
	}
	
	public IntegerProperty getNOProperty(){
		return NO;
	}

	public int getNO() {
		return NO.get();
	}

	public void setNO(int nO) {
		NO.set(nO);
	}

	public IntegerProperty getJNKELProperty(){
		return JNKEL;
	}
	
	public int getJNKEL() {
		return JNKEL.get();
	}

	public void setJNKEL(int jNKEL) {
		JNKEL.set(jNKEL);
	}

	public IntegerProperty getJNNOTANDAProperty(){
		return JNNOTANDA;
	}
	
	public int getJNNOTANDA() {
		return JNNOTANDA.get();
	}

	public void setJNNOTANDA(int jNNOTANDA) {
		JNNOTANDA.set(jNNOTANDA);
	}
	
	public ObjectProperty<Date> getTGLLAHIRProperty(){
		return TGLLAHIR;
	}

	public Date getTGLLAHIR() {
		return TGLLAHIR.get();
	}

	public void setTGLLAHIR(Date tGLLAHIR) {
		TGLLAHIR.set(tGLLAHIR);
	}
	
	public ObjectProperty<Date> getTGLBAPTISProperty(){
		return TGLBAPTIS;
	}

	public Date getTGLBAPTIS() {
		return TGLBAPTIS.get();
	}

	public void setTGLBAPTIS(Date tGLBAPTIS) {
		TGLBAPTIS.set(tGLBAPTIS);
	}

	public ObjectProperty<Date> getTERIMATGLProperty(){
		return TERIMATGL;
	}
	
	public Date getTERIMATGL() {
		return TERIMATGL.get();
	}

	public void setTERIMATGL(Date tERIMATGL) {
		TERIMATGL.set(tERIMATGL);
	}

	public ObjectProperty<Date> getTGLKRISMAProperty(){
		return TGLKRISMA;
	}
	
	public Date getTGLKRISMA() {
		return TGLKRISMA.get();
	}

	public void setTGLKRISMA(Date tGLKRISMA) {
		TGLKRISMA.set(tGLKRISMA);
	}

	public ObjectProperty<Date> getTGLKWProperty(){
		return TGLKW;
	}
	
	public Date getTGLKW() {
		return TGLKW.get();
	}

	public void setTGLKW(Date tGLKW) {
		TGLKW.set(tGLKW);
	}
	
	public ObjectProperty<Date> getTGLMATIProperty(){
		return TGLMATI;
	}

	public Date getTGLMATI() {
		return TGLMATI.get();
	}

	public void setTGLMATI(Date tGLMATI) {
		TGLMATI.set(tGLMATI);
	}
	
	public ObjectProperty<Date> getNOTANDA2Property(){
		return NOTANDA2;
	}

	public Date getNOTANDA2() {
		return NOTANDA2.get();
	}

	public void setNOTANDA2(Date nOTANDA2) {
		NOTANDA2.set(nOTANDA2);
	}
	
	public ObjectProperty<Date> getNOTANDA4Property(){
		return NOTANDA4;
	}

	public Date getNOTANDA4() {
		return NOTANDA4.get();
	}

	public void setNOTANDA4(Date nOTANDA4) {
		NOTANDA4.set(nOTANDA4);
	}
	
	public StringProperty getDJNKELProperty(){
		return dJNKEL;
	}
	
	public String getDJNKEL(){
		return dJNKEL.get();
	}
	
	public void setDJNKEL(String dJNKEL){
		this.dJNKEL.set(dJNKEL);
	}
	
	public StringProperty getDTGLLAHIRProperty(){
		return dTGLLAHIR;
	}
	
	public String getDTGLLAHIR(){
		return dTGLLAHIR.get();
	}
	
	public void setDTGLLAHIR(String dTGLLAHIR){
		this.dTGLLAHIR.set(dTGLLAHIR);
	}
	
	public StringProperty getDTGLBAPTISProperty(){
		return dTGLBAPTIS;
	}
	
	public String getDTGLBAPTIS(){
		return dTGLBAPTIS.get();
	}
	
	public void setDTGLBAPTIS(String dTGLBAPTIS){
		this.dTGLBAPTIS.set(dTGLBAPTIS);
	}
	
	public StringProperty getDTERIMATGLProperty(){
		return dTERIMATGL;
	}
	
	public String getDTERIMATGL(){
		return dTERIMATGL.get();
	}
	
	public void setDTERIMATGL(String dTERIMATGL){
		this.dTERIMATGL.set(dTERIMATGL);
	}
	
	public StringProperty getDTGLKRISMAProperty(){
		return dTGLKRISMA;
	}
	
	public String getDTGLKRISMA(){
		return dTGLKRISMA.get();
	}
	
	public void setDTGLKRISMA(String dTGLKRISMA){
		this.dTGLKRISMA.set(dTGLKRISMA);
	}
	
	public StringProperty getDTGLKWProperty(){
		return dTGLKW;
	}
	
	public String getDTGLKW(){
		return dTGLKW.get();
	}
	
	public void setDTGLKW(String dTGLKW){
		this.dTGLKW.set(dTGLKW);
	}
	
	public StringProperty getDTGLMATIProperty(){
		return dTGLMATI;
	}
	
	public String getDTGLMATI(){
		return dTGLMATI.get();
	}
	
	public void setDTGLMATI(String dTGLMATI){
		this.dTGLMATI.set(dTGLMATI);
	}
	
	public StringProperty getDNOTANDA2Property(){
		return dNOTANDA2;
	}
	
	public String getDNOTANDA2(){
		return dNOTANDA2.get();
	}
	
	public void setDNOTANDA2(String dNOTANDA2){
		this.dNOTANDA2.set(dNOTANDA2);
	}
	
	public StringProperty getDNOTANDA4Property(){
		return dNOTANDA4;
	}
	
	public String getDNOTANDA4(){
		return dNOTANDA4.get();
	}
	
	public void setDNOTANDA4(String dNOTANDA4){
		this.dNOTANDA4.set(dNOTANDA4);
	}
}
