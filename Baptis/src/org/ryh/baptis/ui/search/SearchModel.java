package org.ryh.baptis.ui.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.object.DefaultObjectModel;
import org.jrebirth.af.core.wave.WBuilder;
import org.ryh.baptis.beans.Databaptis;
import org.ryh.baptis.beans.DatabaptisProperty;
import org.ryh.baptis.command.IndexCommand;
import org.ryh.baptis.ui.BaptisWaves;
import com.jfoenix.controls.JFXListCell;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class SearchModel extends DefaultObjectModel<SearchModel, SearchView, DatabaptisProperty>{
	
	public Databaptis selectedData;

	@Override
	protected void initModel() {
		callCommand(IndexCommand.class);
		listen(BaptisWaves.DO_SHOW_RESULT);
	}

	@Override
	protected void initInnerComponents() {

	}

	@Override
	protected void bind() {
		
	}

	@Override
	protected void processWave(final Wave wave) {

	}

	public String getSearchObject() {
		return view().getSearchField().getText();
	}

	public void doShowResult(final ObservableList<Databaptis> result, final Wave wave){
		view().hideLoadingAnimation();
		view().showSearchResult();
		view().setTotalResult("Total ditemukan "+ result.size() +" hasil");
		view().getList().setItems(result);
		
		if(result.size() == 0 || result == null){
			view().showNotFoundImage();
		}

		view().getList().setCellFactory(new Callback<ListView<Databaptis>, ListCell<Databaptis>>() {
			
			@Override
			public ListCell<Databaptis> call(ListView<Databaptis> arg0) {
				final JFXListCell<Databaptis> cell = new JFXListCell<Databaptis>() {
					@SuppressWarnings("static-access")
					@Override
					public void updateItem(Databaptis item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null && !empty) {
							
							VBox container = new VBox();
							
							Label NAMA = new Label(item.getNAMA());
							NAMA.setPrefHeight(50);
							
							Label PAROKI = new Label(item.getPAROKI());
							PAROKI.getStyleClass().add("detail");
							
							Label KOTAPAROKI = new Label(item.getKOTAPAROKI());
							KOTAPAROKI.getStyleClass().add("detail");
							
							try {
								final Font g = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 12);
								final Font f = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 12);
								NAMA.setFont(g);
								PAROKI.setFont(f);
								KOTAPAROKI.setFont(f);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							
							ImageView personImg = new ImageView(new Image("resources/user.png"));
							ImageView churchImg = new ImageView(new Image("resources/church.png"));
							ImageView cityImg = new ImageView(new Image("resources/placeholder.png"));
							
							HBox personBox = new HBox(personImg, NAMA);
							HBox churchBox = new HBox(churchImg, PAROKI);
							HBox cityBox = new HBox(cityImg, KOTAPAROKI);
							
							personBox.setAlignment(Pos.CENTER_LEFT);
							personBox.setSpacing(10);
							churchBox.setAlignment(Pos.CENTER_LEFT);
							churchBox.setSpacing(10);
							cityBox.setAlignment(Pos.CENTER_LEFT);
							cityBox.setSpacing(10);
							
							container.setMargin(NAMA, new Insets(5, 0, 0, 0));
							container.setMargin(KOTAPAROKI, new Insets(0, 0, 5, 0));
							
							container.setSpacing(5);
							
							container.getChildren().add(personBox);
							container.getChildren().add(churchBox);
							container.getChildren().add(cityBox);
							setGraphic(container);
						}
					}
				};
				return cell;
			}
		});
	}
	
	public void doNotifyResult(final Wave wave){
		sendWave(BaptisWaves.DO_SHOW_DATA, WBuilder.waveData(BaptisWaves.DATA, selectedData));
	}
}
