package org.ryh.baptis.beans;

import java.util.Date;


public class Databaptis {
	String PAROKI,KOTAPAROKI,KDSTASI,NAMASTASI,BUKU,NAMA,TMPLAHIR,TMPBAPTIS,TERIMADR,TERIMADI,AYAH,IBU,
		WALIBAPTIS,YGBAPTIS,YGTERIMA,PRKKRISMA,TMPKRISMA,KWDENGAN,PRKKW,TMPKW,LM,LMNO,TMPMATI,NOTANDA,NOTANDA1,
		NOTANDA3,NOTANDA5;
	
	int HAL,NO,JNKEL,JNNOTANDA;
	
	Date TGLLAHIR,TGLBAPTIS,TERIMATGL,TGLKRISMA,TGLKW,TGLMATI,NOTANDA2,NOTANDA4;

	public Databaptis() {
		super();
	}
	
	public Databaptis(String pAROKI, String kOTAPAROKI, String kDSTASI, String nAMASTASI, String bUKU, int hAL, 
			int nO, String nAMA, int jNKEL, String tMPLAHIR, Date tGLLAHIR, String tMPBAPTIS, Date tGLBAPTIS,
			String tERIMADR, String tERIMADI, Date tERIMATGL, String aYAH, String iBU, String wALIBAPTIS, 
			String yGBAPTIS, String yGTERIMA, String pRKKRISMA, String tMPKRISMA, Date tGLKRISMA, String kWDENGAN,
			String pRKKW, String tMPKW, Date tGLKW, String lM, String lMNO, String tMPMATI, Date tGLMATI, int jNNOTANDA,
			String nOTANDA, String nOTANDA1, Date nOTANDA2, String nOTANDA3, Date nOTANDA4, String nOTANDA5) {
		super();
		PAROKI = pAROKI;
		KOTAPAROKI = kOTAPAROKI;
		KDSTASI = kDSTASI;
		NAMASTASI = nAMASTASI;
		BUKU = bUKU;
		NAMA = nAMA;
		TMPLAHIR = tMPLAHIR;
		TMPBAPTIS = tMPBAPTIS;
		TERIMADR = tERIMADR;
		TERIMADI = tERIMADI;
		AYAH = aYAH;
		IBU = iBU;
		WALIBAPTIS = wALIBAPTIS;
		YGBAPTIS = yGBAPTIS;
		YGTERIMA = yGTERIMA;
		PRKKRISMA = pRKKRISMA;
		TMPKRISMA = tMPKRISMA;
		KWDENGAN = kWDENGAN;
		PRKKW = pRKKW;
		TMPKW = tMPKW;
		LM = lM;
		LMNO = lMNO;
		TMPMATI = tMPMATI;
		NOTANDA = nOTANDA;
		NOTANDA1 = nOTANDA1;
		NOTANDA3 = nOTANDA3;
		NOTANDA5 = nOTANDA5;
		HAL = hAL;
		NO = nO;
		JNKEL = jNKEL;
		JNNOTANDA = jNNOTANDA;
		TGLLAHIR = tGLLAHIR;
		TGLBAPTIS = tGLBAPTIS;
		TERIMATGL = tERIMATGL;
		TGLKRISMA = tGLKRISMA;
		TGLKW = tGLKW;
		TGLMATI = tGLMATI;
		NOTANDA2 = nOTANDA2;
		NOTANDA4 = nOTANDA4;
	}



	public String getPAROKI() {
		return PAROKI;
	}

	public void setPAROKI(String pAROKI) {
		PAROKI = pAROKI;
	}

	public String getKOTAPAROKI() {
		return KOTAPAROKI;
	}

	public void setKOTAPAROKI(String kOTAPAROKI) {
		KOTAPAROKI = kOTAPAROKI;
	}

	public String getKDSTASI() {
		return KDSTASI;
	}

	public void setKDSTASI(String kDSTASI) {
		KDSTASI = kDSTASI;
	}

	public String getNAMASTASI() {
		return NAMASTASI;
	}

	public void setNAMASTASI(String nAMASTASI) {
		NAMASTASI = nAMASTASI;
	}

	public String getBUKU() {
		return BUKU;
	}

	public void setBUKU(String bUKU) {
		BUKU = bUKU;
	}

	public String getNAMA() {
		return NAMA;
	}

	public void setNAMA(String nAMA) {
		NAMA = nAMA;
	}

	public String getTMPLAHIR() {
		return TMPLAHIR;
	}

	public void setTMPLAHIR(String tMPLAHIR) {
		TMPLAHIR = tMPLAHIR;
	}

	public String getTMPBAPTIS() {
		return TMPBAPTIS;
	}

	public void setTMPBAPTIS(String tMPBAPTIS) {
		TMPBAPTIS = tMPBAPTIS;
	}

	public String getTERIMADR() {
		return TERIMADR;
	}

	public void setTERIMADR(String tERIMADR) {
		TERIMADR = tERIMADR;
	}

	public String getTERIMADI() {
		return TERIMADI;
	}

	public void setTERIMADI(String tERIMADI) {
		TERIMADI = tERIMADI;
	}

	public String getAYAH() {
		return AYAH;
	}

	public void setAYAH(String aYAH) {
		AYAH = aYAH;
	}

	public String getIBU() {
		return IBU;
	}

	public void setIBU(String iBU) {
		IBU = iBU;
	}

	public String getWALIBAPTIS() {
		return WALIBAPTIS;
	}

	public void setWALIBAPTIS(String wALIBAPTIS) {
		WALIBAPTIS = wALIBAPTIS;
	}

	public String getYGBAPTIS() {
		return YGBAPTIS;
	}

	public void setYGBAPTIS(String yGBAPTIS) {
		YGBAPTIS = yGBAPTIS;
	}

	public String getYGTERIMA() {
		return YGTERIMA;
	}

	public void setYGTERIMA(String yGTERIMA) {
		YGTERIMA = yGTERIMA;
	}

	public String getPRKKRISMA() {
		return PRKKRISMA;
	}

	public void setPRKKRISMA(String pRKKRISMA) {
		PRKKRISMA = pRKKRISMA;
	}

	public String getTMPKRISMA() {
		return TMPKRISMA;
	}

	public void setTMPKRISMA(String tMPKRISMA) {
		TMPKRISMA = tMPKRISMA;
	}

	public String getKWDENGAN() {
		return KWDENGAN;
	}

	public void setKWDENGAN(String kWDENGAN) {
		KWDENGAN = kWDENGAN;
	}

	public String getPRKKW() {
		return PRKKW;
	}

	public void setPRKKW(String pRKKW) {
		PRKKW = pRKKW;
	}

	public String getTMPKW() {
		return TMPKW;
	}

	public void setTMPKW(String tMPKW) {
		TMPKW = tMPKW;
	}

	public String getLM() {
		return LM;
	}

	public void setLM(String lM) {
		LM = lM;
	}

	public String getLMNO() {
		return LMNO;
	}

	public void setLMNO(String lMNO) {
		LMNO = lMNO;
	}

	public String getTMPMATI() {
		return TMPMATI;
	}

	public void setTMPMATI(String tMPMATI) {
		TMPMATI = tMPMATI;
	}

	public String getNOTANDA() {
		return NOTANDA;
	}

	public void setNOTANDA(String nOTANDA) {
		NOTANDA = nOTANDA;
	}

	public String getNOTANDA1() {
		return NOTANDA1;
	}

	public void setNOTANDA1(String nOTANDA1) {
		NOTANDA1 = nOTANDA1;
	}

	public String getNOTANDA3() {
		return NOTANDA3;
	}

	public void setNOTANDA3(String nOTANDA3) {
		NOTANDA3 = nOTANDA3;
	}

	public String getNOTANDA5() {
		return NOTANDA5;
	}

	public void setNOTANDA5(String nOTANDA5) {
		NOTANDA5 = nOTANDA5;
	}

	public int getHAL() {
		return HAL;
	}

	public void setHAL(int hAL) {
		HAL = hAL;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public int getJNKEL() {
		return JNKEL;
	}

	public void setJNKEL(int jNKEL) {
		JNKEL = jNKEL;
	}

	public int getJNNOTANDA() {
		return JNNOTANDA;
	}

	public void setJNNOTANDA(int jNNOTANDA) {
		JNNOTANDA = jNNOTANDA;
	}

	public Date getTGLLAHIR() {
		return TGLLAHIR;
	}

	public void setTGLLAHIR(Date tGLLAHIR) {
		TGLLAHIR = tGLLAHIR;
	}

	public Date getTGLBAPTIS() {
		return TGLBAPTIS;
	}

	public void setTGLBAPTIS(Date tGLBAPTIS) {
		TGLBAPTIS = tGLBAPTIS;
	}

	public Date getTERIMATGL() {
		return TERIMATGL;
	}

	public void setTERIMATGL(Date tERIMATGL) {
		TERIMATGL = tERIMATGL;
	}

	public Date getTGLKRISMA() {
		return TGLKRISMA;
	}

	public void setTGLKRISMA(Date tGLKRISMA) {
		TGLKRISMA = tGLKRISMA;
	}

	public Date getTGLKW() {
		return TGLKW;
	}

	public void setTGLKW(Date tGLKW) {
		TGLKW = tGLKW;
	}

	public Date getTGLMATI() {
		return TGLMATI;
	}

	public void setTGLMATI(Date tGLMATI) {
		TGLMATI = tGLMATI;
	}

	public Date getNOTANDA2() {
		return NOTANDA2;
	}

	public void setNOTANDA2(Date nOTANDA2) {
		NOTANDA2 = nOTANDA2;
	}

	public Date getNOTANDA4() {
		return NOTANDA4;
	}

	public void setNOTANDA4(Date nOTANDA4) {
		NOTANDA4 = nOTANDA4;
	}
	
}