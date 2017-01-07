package org.ryh.baptis.ui.result;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jrebirth.af.api.ui.annotation.OnAction;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.DefaultView;

import com.jfoenix.controls.JFXButton;
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
	, tglKrismaLabel, kawinDgnLabel, tglKawinLabel;
	
	private JFXTextField namaField, jnKelField, tmptLahirField, tglLahirField, parokiField, kotaParokiField
	, namaStasiField, ayahField, ibuField, tmptBaptisField, tglBaptisField, tmptKrismaField, tglKrismaField
	, kawinDgnField, tglKawinField;
	
	public ResultView(ResultModel model) {
		super(model);
	}
	
	@SuppressWarnings("static-access")
	@Override
	protected void initView() {
		DropShadow ds = new DropShadow();
        ds.setOffsetY(1.0);
        ds.setOffsetX(1.0);
        ds.setColor(Color.GRAY);
        
        BorderPane topPane = new BorderPane();
        topPane.setStyle("-fx-background-color : #5264AE");
        topPane.setEffect(ds);
        topPane.setPrefHeight(100);
        
        backButton = new JFXButton("", new ImageView(new Image("/resources/left-arrow.png")));
        backButton.setPrefSize(100, 100);
        
        titleLabel = new Label("PERSON NAME");
        titleLabel.setPrefHeight(100);
        titleLabel.setStyle("-fx-text-fill : WHITE");
        
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
        
        ibuLabel = new Label("NAMA IBU \t : ");
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
        
        kawinDgnLabel = new Label("KAWIN DENGAN \t : ");
        kawinDgnField = new JFXTextField("PERSON MARRIED WITH");
        kawinDgnField.setEditable(false);
        kawinDgnField.setStyle("-fx-background-color : #F5F5F5");
        kawinDgnLabel.setLabelFor(kawinDgnField);
        
        tglKawinLabel = new Label("TANGGAL KAWIN \t : ");
        
        HBox namaBox = new HBox();
        HBox jnKelBox = new HBox();
        HBox tmptLahirBox = new HBox();
        HBox tglLahirBox = new HBox();
        VBox leftBox = new VBox();
        
        try {
			final Font f = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 25);
			final Font g = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 16);
			titleLabel.setFont(f);
			namaLabel.setFont(g);
			namaField.setFont(g);
			jnKelLabel.setFont(g);
			jnKelField.setFont(g);
			tmptLahirLabel.setFont(g);
			tmptLahirField.setFont(g);
			tglLahirLabel.setFont(g);
			tglLahirField.setFont(g);
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
        topPane.setLeft(backButton);
        topPane.setCenter(titleLabel);
        topPane.setAlignment(backButton, Pos.CENTER_LEFT);
        topPane.setAlignment(titleLabel, Pos.CENTER_LEFT);
        leftBox.getChildren().addAll(namaBox, jnKelBox, tmptLahirBox, tglLahirBox);
        node().setTop(topPane);
        node().setLeft(leftBox);
        node().setMargin(leftBox, new Insets(10));
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

}
