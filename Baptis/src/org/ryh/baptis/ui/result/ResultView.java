package org.ryh.baptis.ui.result;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jrebirth.af.api.ui.annotation.OnAction;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.DefaultView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

@RootNodeId("ResultPanel")
public class ResultView extends DefaultView<ResultModel, BorderPane, ResultController>{

	@OnAction(name = "Back")
	private JFXButton backButton;
	
	private Label titleLabel, namaLabel, jnKelLabel, tmptLahirLabel, tglLahirLabel, parokiLabel
	, kotaParokiLabel, namaStasiLabel, ayahLabel, ibuLabel, tmptBaptisLabel, tglBaptisLabel, tmptKrismaLabel
	, tglKrismaLabel, kawinDgnLabel, tglKawinLabel, tglMatiLabel, bukuLabel, halLabel, noLabel;
	
	private JFXTextField namaField, jnKelField, tmptLahirField, tglLahirField, parokiField, kotaParokiField
	, namaStasiField, ayahField, ibuField, tmptBaptisField, tglBaptisField, tmptKrismaField, tglKrismaField
	, kawinDgnField, tglKawinField, tglMatiField, bukuField, halField, noField;
	
	private ImageView photoImage;
	
	@OnAction(name = "Print")
	private JFXButton printButton;
	
	private BorderPane topPane;
	
	public ResultView(ResultModel model) {
		super(model);
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	@Override
	protected void initView() {
		DropShadow ds = new DropShadow();
        ds.setOffsetY(1.0);
        ds.setOffsetX(1.0);
        ds.setColor(Color.GRAY);
        
        topPane = new BorderPane();
        topPane.setStyle("-fx-background-color : #5264AE");
        topPane.setEffect(ds);
        topPane.setPrefHeight(100);
        
        backButton = new JFXButton("", new ImageView(new Image("/resources/left-arrow.png")));
        backButton.setPrefSize(100, 100);
        
        titleLabel = new Label("PERSON NAME");
        titleLabel.setPrefHeight(100);
        titleLabel.setStyle("-fx-text-fill : WHITE");
        
        photoImage = new ImageView(new Image("/resources/user-male-black-shape.png"));
        photoImage.setFitHeight(200);
        photoImage.setFitWidth(200);
        photoImage.setEffect(ds);
        
        namaLabel = new Label("NAMA \t\t\t : ");
        namaField = new JFXTextField("PERSON NAME");
        namaField.setEditable(false);
        namaField.setStyle("-fx-background-color : #F5F5F5");
        namaLabel.setLabelFor(namaField);
        
        jnKelLabel = new Label("JENIS KELAMIN \t : ");
        jnKelField = new JFXTextField("PERSON GENDER");
        jnKelField.setEditable(false);
        jnKelField.setStyle("-fx-background-color : #F5F5F5");
        jnKelLabel.setLabelFor(jnKelField);
        
        tmptLahirLabel = new Label("TEMPAT LAHIR \t : ");
        tmptLahirField = new JFXTextField("PERSON BIRTH PLACE");
        tmptLahirField.setEditable(false);
        tmptLahirField.setStyle("-fx-background-color : #F5F5F5");
        tmptLahirLabel.setLabelFor(tmptLahirField);
        
        tglLahirLabel = new Label("TANGGAL LAHIR \t : ");
        tglLahirField = new JFXTextField("PERSON BIRTH DATE");
        tglLahirField.setEditable(false);
        tglLahirField.setStyle("-fx-background-color : #F5F5F5");
        tglLahirLabel.setLabelFor(tglLahirField);
        
        parokiLabel = new Label("PAROKI \t\t\t : ");
        parokiField = new JFXTextField("PERSON PARISH");
        parokiField.setEditable(false);
        parokiField.setStyle("-fx-background-color : #F5F5F5");
        parokiLabel.setLabelFor(parokiField);
        
        kotaParokiLabel = new Label("KOTA PAROKI \t : ");
        kotaParokiField = new JFXTextField("PERSON PARISH CITY");
        kotaParokiField.setEditable(false);
        kotaParokiField.setStyle("-fx-background-color : #F5F5F5");
        kotaParokiLabel.setLabelFor(kotaParokiField);
        
        namaStasiLabel = new Label("NAMA STASI \t : ");
        namaStasiField = new JFXTextField("PERSON STATIONS");
        namaStasiField.setEditable(false);
        namaStasiField.setStyle("-fx-background-color : #F5F5F5");
        namaStasiLabel.setLabelFor(namaStasiField);
        
        ayahLabel = new Label("NAMA AYAH \t : ");
        ayahField = new JFXTextField("PERSON FATHER");
        ayahField.setEditable(false);
        ayahField.setStyle("-fx-background-color : #F5F5F5");
        ayahLabel.setLabelFor(ayahField);
        
        ibuLabel = new Label("NAMA IBU \t\t : ");
        ibuField = new JFXTextField("PERSON MOTHER");
        ibuField.setEditable(false);
        ibuField.setStyle("-fx-background-color : #F5F5F5");
        ibuLabel.setLabelFor(ibuField);
        
        tmptBaptisLabel = new Label("TEMPAT BAPTIS \t : ");
        tmptBaptisField = new JFXTextField("PERSON BAPTISM PLACE");
        tmptBaptisField.setEditable(false);
        tmptBaptisField.setStyle("-fx-background-color : #F5F5F5");
        tmptBaptisLabel.setLabelFor(tmptBaptisField);
        
        tglBaptisLabel = new Label("TANGGAL BAPTIS \t : ");
        tglBaptisField = new JFXTextField("PERSON BAPTISM DATE");
        tglBaptisField.setEditable(false);
        tglBaptisField.setStyle("-fx-background-color : #F5F5F5");
        tglBaptisLabel.setLabelFor(tglBaptisField);
        
        tmptKrismaLabel = new Label("TEMPAT KRISMA \t : ");
        tmptKrismaField = new JFXTextField("PERSON CHRISM PLACE");
        tmptKrismaField.setEditable(false);
        tmptKrismaField.setStyle("-fx-background-color : #F5F5F5");
        tmptKrismaLabel.setLabelFor(tmptKrismaField);
        
        tglKrismaLabel = new Label("TANGGAL KRISMA \t : ");
        tglKrismaField = new JFXTextField("PERSON CHRISM DATE");
        tglKrismaField.setEditable(false);
        tglKrismaField.setStyle("-fx-background-color : #F5F5F5");
        tglKrismaLabel.setLabelFor(tglKrismaField);
        
        kawinDgnLabel = new Label("KAWIN DENGAN \t\t : ");
        kawinDgnField = new JFXTextField("PERSON MARRIED WITH");
        kawinDgnField.setEditable(false);
        kawinDgnField.setStyle("-fx-background-color : #F5F5F5");
        kawinDgnLabel.setLabelFor(kawinDgnField);
        
        tglKawinLabel = new Label("TANGGAL KAWIN \t : ");
        tglKawinField = new JFXTextField("PERSON MARRIED DATE");
        tglKawinField.setEditable(false);
        tglKawinField.setStyle("-fx-background-color : #F5F5F5");
        tglKawinLabel.setLabelFor(tglKawinField);
        
        tglMatiLabel = new Label("TANGGAL MATI \t\t : ");
        tglMatiField = new JFXTextField("PERSON DEATH DATE");
        tglMatiField.setEditable(false);
        tglMatiField.setStyle("-fx-background-color : #F5F5F5");
        tglMatiLabel.setLabelFor(tglMatiField);
        
        bukuLabel = new Label("BUKU \t\t\t\t : ");
        bukuField = new JFXTextField("PERSON BOOK");
        bukuField.setEditable(false);
        bukuField.setStyle("-fx-background-color : #F5F5F5");
        bukuLabel.setLabelFor(bukuField);
        
        halLabel = new Label("HAL \t\t\t\t : ");
        halField = new JFXTextField("PERSON PAGE");
        halField.setEditable(false);
        halField.setStyle("-fx-background-color : #F5F5F5");
        halLabel.setLabelFor(halField);
        
        noLabel = new Label("NO \t\t\t\t\t : ");
        noField = new JFXTextField("PERSON NO");
        noField.setEditable(false);
        noField.setStyle("-fx-background-color : #F5F5F5");
        noLabel.setLabelFor(noField);
        
        printButton = new JFXButton("", new ImageView(new Image("/resources/printer.png")));
        printButton.getStyleClass().add("button-raised");
        printButton.setStyle("-fx-background-color : WHITE;"
        		+ "-fx-background-radius: 5em; "
        		+ "-fx-min-width: 3px;"
        		+ "-fx-min-height: 3px;"
        		+ "-fx-max-width: 64px;"
        		+ "-fx-max-height: 64px;");
        
        HBox namaBox = new HBox();
        HBox jnKelBox = new HBox();
        HBox tmptLahirBox = new HBox();
        HBox tglLahirBox = new HBox();
        HBox parokiBox = new HBox();
        HBox kotaParokiBox = new HBox();
        HBox namaStasiBox = new HBox();
        HBox ayahBox = new HBox();
        HBox ibuBox = new HBox();
        HBox tmptBaptisBox = new HBox();
        HBox tglBaptisBox = new HBox();
        HBox tmptKrismaBox = new HBox();
        HBox tglKrismaBox = new HBox();
        HBox kawinDgnBox = new HBox();
        HBox tglKawinBox = new HBox();
        HBox tglMatiBox = new HBox();
        HBox bukuBox = new HBox();
        HBox halBox = new HBox();
        HBox noBox = new HBox();
        HBox printBox = new HBox();
        
        VBox leftBox = new VBox();
        VBox midBox = new VBox();
        midBox.setSpacing(10);
        VBox rightBox = new VBox();
        rightBox.setSpacing(10);
        
        try {
			final Font f = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 25);
			final Font g = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 16);
			final Font i = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Bold.ttf")), 16);
			titleLabel.setFont(f);
			namaLabel.setFont(g);
			namaField.setFont(g);
			jnKelLabel.setFont(g);
			jnKelField.setFont(g);
			tmptLahirLabel.setFont(g);
			tmptLahirField.setFont(g);
			tglLahirLabel.setFont(g);
			tglLahirField.setFont(g);
			parokiLabel.setFont(g);
			parokiField.setFont(g);
			kotaParokiLabel.setFont(g);
			kotaParokiField.setFont(g);
			namaStasiLabel.setFont(g);
			namaStasiField.setFont(g);
			ayahLabel.setFont(g);
			ayahField.setFont(g);
			ibuLabel.setFont(g);
			ibuField.setFont(g);
			tmptBaptisLabel.setFont(g);
			tmptBaptisField.setFont(g);
			tglBaptisLabel.setFont(g);
			tglBaptisField.setFont(g);
			tmptKrismaLabel.setFont(g);
			tmptKrismaField.setFont(g);
			tglKrismaLabel.setFont(g);
			tglKrismaField.setFont(g);
			kawinDgnLabel.setFont(g);
			kawinDgnField.setFont(g);
			tglKawinLabel.setFont(g);
			tglKawinField.setFont(g);
			tglMatiLabel.setFont(g);
			tglMatiField.setFont(g);
			bukuLabel.setFont(g);
			bukuField.setFont(g);
			halLabel.setFont(g);
			halField.setFont(g);
			noLabel.setFont(g);
			noField.setFont(g);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        namaBox.getChildren().addAll(namaLabel, namaField);
        namaBox.setAlignment(Pos.BASELINE_LEFT);
        jnKelBox.getChildren().addAll(jnKelLabel, jnKelField);
        jnKelBox.setAlignment(Pos.BASELINE_LEFT);
        tmptLahirBox.getChildren().addAll(tmptLahirLabel, tmptLahirField);
        tmptLahirBox.setAlignment(Pos.BASELINE_LEFT);
        tglLahirBox.getChildren().addAll(tglLahirLabel, tglLahirField);
        tglLahirBox.setAlignment(Pos.BASELINE_LEFT);
        parokiBox.getChildren().addAll(parokiLabel, parokiField);
        parokiBox.setAlignment(Pos.BASELINE_LEFT);
        kotaParokiBox.getChildren().addAll(kotaParokiLabel, kotaParokiField);
        kotaParokiBox.setAlignment(Pos.BASELINE_LEFT);
        namaStasiBox.getChildren().addAll(namaStasiLabel, namaStasiField);
        namaStasiBox.setAlignment(Pos.BASELINE_LEFT);
        ayahBox.getChildren().addAll(ayahLabel, ayahField);
        ayahBox.setAlignment(Pos.BASELINE_LEFT);
        ibuBox.getChildren().addAll(ibuLabel, ibuField);
        ibuBox.setAlignment(Pos.BASELINE_LEFT);
        tmptBaptisBox.getChildren().addAll(tmptBaptisLabel, tmptBaptisField);
        tmptBaptisBox.setAlignment(Pos.BASELINE_LEFT);
        tglBaptisBox.getChildren().addAll(tglBaptisLabel, tglBaptisField);
        tglBaptisBox.setAlignment(Pos.BASELINE_LEFT);
        tmptKrismaBox.getChildren().addAll(tmptKrismaLabel, tmptKrismaField);
        tmptKrismaBox.setAlignment(Pos.BASELINE_LEFT);
        tglKrismaBox.getChildren().addAll(tglKrismaLabel, tglKrismaField);
        tglKrismaBox.setAlignment(Pos.BASELINE_LEFT);
        kawinDgnBox.getChildren().addAll(kawinDgnLabel, kawinDgnField);
        kawinDgnBox.setAlignment(Pos.BASELINE_LEFT);
        tglKawinBox.getChildren().addAll(tglKawinLabel, tglKawinField);
        tglKawinBox.setAlignment(Pos.BASELINE_LEFT);
        tglMatiBox.getChildren().addAll(tglMatiLabel, tglMatiField);
        tglMatiBox.setAlignment(Pos.BASELINE_LEFT);
        bukuBox.getChildren().addAll(bukuLabel, bukuField);
        bukuBox.setAlignment(Pos.BASELINE_LEFT);
        halBox.getChildren().addAll(halLabel, halField);
        halBox.setAlignment(Pos.BASELINE_LEFT);
        noBox.getChildren().addAll(noLabel, noField);
        noBox.setAlignment(Pos.BASELINE_LEFT);
        printBox.getChildren().add(printButton);
        printBox.setAlignment(Pos.BOTTOM_RIGHT);
        
        topPane.setLeft(backButton);
        topPane.setCenter(titleLabel);
        topPane.setAlignment(backButton, Pos.CENTER_LEFT);
        topPane.setAlignment(titleLabel, Pos.CENTER_LEFT);
        leftBox.getChildren().add(photoImage);
        midBox.getChildren().addAll(namaBox, jnKelBox, tmptLahirBox, tglLahirBox, parokiBox
        		, kotaParokiBox, namaStasiBox, ayahBox, ibuBox, tmptBaptisBox);
        rightBox.getChildren().addAll(tglBaptisBox, tmptKrismaBox, tglKrismaBox, kawinDgnBox
        		, tglKawinBox, tglMatiBox, bukuBox, halBox, noBox, printBox);
//        node().setTop(topPane);
//        node().setLeft(leftBox);
//        node().setCenter(midBox);
//        node().setRight(rightBox);
        node().setCenter(new JFXSpinner());
        node().setMargin(leftBox, new Insets(50, 50, 0, 100));
        node().setMargin(midBox, new Insets(50, 50, 0, 50));
        node().setMargin(rightBox, new Insets(50, 100, 0, 50));
	}
	
	@Override
	public void start() {
		super.start();
	}
	
	@Override
	public void reload() {
		super.reload();
	}
	
	@Override
	public void hide() {
		super.hide();
	}

	public Label getTitleLabel(){
		return titleLabel;
	}
	
	public JFXTextField getNamaField(){
		return namaField;
	}
	
	public JFXTextField getJnKelField(){
		return jnKelField;
	}
	
	public JFXTextField getTmptLahirField(){
		return tmptLahirField;
	}
	
	public JFXTextField getTglLahirField(){
		return tglLahirField;
	}
	
	public JFXTextField getParokiField(){
		return parokiField;
	}
	
	public JFXTextField getKotaParokiField(){
		return kotaParokiField;
	}
	
	public JFXTextField getNamaStasiField(){
		return namaStasiField;
	}
	
	public JFXTextField getAyahField(){
		return ayahField;
	}
	
	public JFXTextField getIbuField(){
		return ibuField;
	}
	
	public JFXTextField getTmptBaptisField(){
		return tmptBaptisField;
	}
	
	public JFXTextField getTglBaptisField(){
		return tglBaptisField;
	}
	
	public JFXTextField getTmptKrismaField(){
		return tmptKrismaField;
	}
	
	public JFXTextField getTglKrismaField(){
		return tglKrismaField;
	}
	
	public JFXTextField getKawinDgnField(){
		return kawinDgnField;
	}
	
	public JFXTextField getTglKawinField(){
		return tglKawinField;
	}
	
	public JFXTextField getTglMatiField(){
		return tglMatiField;
	}
	
	public JFXTextField getBukuField(){
		return bukuField;
	}
	
	public JFXTextField getHalField(){
		return halField;
	}
	
	public JFXTextField getNoField(){
		return noField;
	}
	
	public BorderPane getTopPane(){
		return topPane;
	}
}
