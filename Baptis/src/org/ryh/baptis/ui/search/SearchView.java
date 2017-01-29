package org.ryh.baptis.ui.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.api.ui.annotation.OnAction;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.DefaultView;
import org.ryh.baptis.beans.Databaptis;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.controls.JFXDialog.DialogTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.util.Duration;

@RootNodeId("SearchPanel")
public class SearchView extends DefaultView<SearchModel, StackPane, SearchController>{
    
	private BorderPane root;
    private JFXTextField searchField, nameAdvField, parishAdvField, parishCityAdvField;
    private JFXSpinner loadingSpinner;
    private Label totalResult, advSearchLabel;
    private VBox notFoundContainer;
	private JFXListView<Databaptis> list = new JFXListView<Databaptis>();
	private JFXPopup popUp, advPopUp;
	private JFXListView<Label> menuList;
	private ImageView downArrowImg;
	private JFXDatePicker datePicker;
	
	private JFXButton advOkButton;
	private JFXButton advCancelButton;
	
	@OnAction(name = "Choose")
	private JFXButton settingMenuButton;
	private FileChooser fileChooser;
	
    @OnAction(name = "Search")
    private JFXButton searchButton;
    
    @OnAction(name = "Settings")
    private JFXButton settingButton;
    
    private JFXDialog nullErrorDialog;

    public SearchView(final SearchModel model) throws CoreException {
        super(model);
    }

    @SuppressWarnings("static-access")
	@Override
    protected void initView() {
    	fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(
    		    new FileChooser.ExtensionFilter("Database File", "*.dbf")
    		);
    	root = new BorderPane();
    	
    	DropShadow ds = new DropShadow();
        ds.setOffsetY(1.0);
        ds.setOffsetX(1.0);
        ds.setColor(Color.GRAY);
    	
    	BorderPane topPane = new BorderPane();
        ImageView logoImage = new ImageView();
        logoImage.setFitWidth(150);
        logoImage.setFitHeight(150);
        
        VBox searchPane = new VBox();
        searchPane.setSpacing(30);
    	
    	this.searchField = new JFXTextField();
    	this.searchField.setLabelFloat(false);
    	this.searchField.setPromptText("Masukkan kode");
    	this.searchField.getStylesheets().add("/resources/searchfieldcustomization.css");
    	this.searchField.setPrefWidth(700);
    	
        this.searchButton = new JFXButton("",new ImageView(new Image("/resources/search.png")));
        this.searchButton.getStyleClass().add("button-raised");
        this.searchButton.setStyle("-fx-background-color : WHITE;"
        		+ "-fx-background-radius: 5em; "
        		+ "-fx-min-width: 3px;"
        		+ "-fx-min-height: 3px;"
        		+ "-fx-max-width: 40px;"
        		+ "-fx-max-height: 40px;");
        
        advSearchLabel = new Label("Pencarian Lanjutan");
        advSearchLabel.setStyle("-fx-text-fill : WHITE;");
        downArrowImg = new ImageView(new Image("resources/sort-down.png"));
        
        HBox topSearchPane = new HBox(searchField,searchButton);
        topSearchPane.setSpacing(20);
        topSearchPane.setAlignment(Pos.BASELINE_LEFT);
        HBox botSearchPane = new HBox(advSearchLabel, downArrowImg);
        botSearchPane.setAlignment(Pos.CENTER_LEFT);
        botSearchPane.setMargin(advSearchLabel, new Insets(0, 0, 0, 540));
        botSearchPane.setSpacing(10);

        searchPane.getChildren().addAll(topSearchPane, botSearchPane);
        searchPane.setAlignment(Pos.CENTER_LEFT);
        
        this.totalResult = new Label();
        totalResult.getStyleClass().add("hasil");
        topPane.setMargin(totalResult, new Insets(0,20,10,0));
        topPane.setAlignment(totalResult, Pos.CENTER_RIGHT);
        
        settingButton = new JFXButton("", new ImageView(new Image("/resources/settings.png")));
        settingButton.setStyle("-fx-background-color : #5264AE;"
        		+ "-fx-background-radius: 5em; "
        		+ "-fx-min-width: 3px;"
        		+ "-fx-min-height: 3px;"
        		+ "-fx-max-width: 30px;"
        		+ "-fx-max-height: 30px;");
        
        menuList = new JFXListView<Label>();
        menuList.setStyle("-fx-vertical-gap : 0;");
        Label chgDirMenu = new Label("Buka direktori index ...");
        chgDirMenu.setStyle("-fx-font-weight : normal;"
        		+ "-fx-font-size : 12");
        menuList.getItems().add(chgDirMenu);
        settingMenuButton = new JFXButton("Buka direktori index ...");
             
        topPane.setLeft(logoImage);
        topPane.setCenter(searchPane);
        topPane.setBottom(totalResult);
        topPane.setRight(settingButton);
        topPane.setStyle("-fx-background-color : #5264AE");
        topPane.setEffect(ds);
        topPane.setAlignment(settingButton, Pos.CENTER_RIGHT);
        topPane.setMargin(settingButton, new Insets(0, 20, 0, 0));
        
        popUp = new JFXPopup();
		popUp.setContent(settingMenuButton);
		popUp.setPopupContainer(topPane);
		popUp.setSource(settingButton);
		
		VBox advBox = new VBox();
		HBox topAdvBox = new HBox();
		nameAdvField = new JFXTextField();
		nameAdvField.setPromptText("Nama");
		datePicker = new JFXDatePicker();
		datePicker.setPromptText("Tanggal Lahir");
		topAdvBox.getChildren().addAll(nameAdvField, datePicker);
		HBox midAdvBox = new HBox();
		parishAdvField = new JFXTextField();
		parishAdvField.setPromptText("Paroki");
		parishCityAdvField = new JFXTextField();
		parishCityAdvField.setPromptText("Kota Paroki");
		midAdvBox.getChildren().addAll(parishAdvField, parishCityAdvField);
		HBox botAdvBox = new HBox();
		advOkButton = new JFXButton("OK");
		advOkButton.getStyleClass().add("button-raised");
		advOkButton.setStyle("-fx-pref-width : 40");
		advCancelButton = new JFXButton("Cancel");
		botAdvBox.getChildren().addAll(advOkButton, advCancelButton);
		botAdvBox.setAlignment(Pos.CENTER_RIGHT);
		advBox.getChildren().addAll(topAdvBox, midAdvBox, botAdvBox);
		advBox.setSpacing(10);
		advBox.setMargin(topAdvBox, new Insets(20, 20, 0, 20));
		advBox.setMargin(midAdvBox, new Insets(0, 20, 0, 20));
		advBox.setMargin(botAdvBox, new Insets(0, 20, 20, 20));
		
		advPopUp= new JFXPopup();
		advPopUp.setContent(advBox);
		advPopUp.setPopupContainer(topPane);
		advPopUp.setSource(downArrowImg);
        
        root.setTop(topPane);
        root.setStyle("-fx-background-color : #F5F5F5");
        
        JFXDialogLayout nullErrorLayout = new JFXDialogLayout();
        JFXButton nullErrorButton = new JFXButton("OK");
        nullErrorButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				nullErrorDialog.close();
				
			}
		});
        nullErrorLayout.setHeading(new Label("KATA KUNCI KOSONG"));
        Label body = new Label("Silakan isi kata kunci pada field pencarian.");
        nullErrorLayout.setBody(body);
        nullErrorLayout.setAlignment(body, Pos.BOTTOM_LEFT);
        nullErrorLayout.setActions(nullErrorButton);
        nullErrorDialog = new JFXDialog(node(), nullErrorLayout, DialogTransition.CENTER);
        
        node().getChildren().add(root);
        
        try{
        	final Font f = Font.loadFont(new FileInputStream(new File("src/resources/Roboto-Regular.ttf")), 14);
        	advSearchLabel.setFont(f);
        }catch(FileNotFoundException e){
        	
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void hide() {
        list.getSelectionModel().clearSelection();
    }

	public JFXTextField getSearchField() {
		return searchField;
	}
	
	public JFXButton getSearchButton() {
		return searchButton;
	}
	
	public void showLoadingAnimation(){
		totalResult.setText("");
		loadingSpinner = new JFXSpinner();
		loadingSpinner.setRadius(25);
		root.setCenter(loadingSpinner);
		FadeTransition ft = new FadeTransition(Duration.millis(2000), loadingSpinner);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
	}

	public void hideLoadingAnimation(){
		FadeTransition ft = new FadeTransition(Duration.millis(2000), loadingSpinner);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.play();
	}
	
	public void showNotFoundImage(){
		notFoundContainer = new VBox();
		ImageView notFoundImg = new ImageView(new Image("/resources/looking.png"));
		Label notFoundLabel = new Label("Tidak ditemukan hasil apapun");
		notFoundContainer.getChildren().addAll(notFoundImg,notFoundLabel);
		notFoundContainer.setAlignment(Pos.CENTER);
		notFoundContainer.setSpacing(20);
		
		root.setCenter(notFoundContainer);
	}
	
	@SuppressWarnings("static-access")
	public void showSearchResult(){
		
		list.getStyleClass().add("mylistview");
		
		root.setCenter(list);
		root.setMargin(list, new Insets(20));
		list.depthProperty().set(1);
	}
	
	public void setTotalResult(String total){
		totalResult.setText(total);
	}
	
	public JFXListView<Databaptis> getList(){
		return this.list;
	}
	
	public JFXDialog getNullErrorDialog(){
		return nullErrorDialog;
	}
	
	public JFXPopup getPopUp(){
		return popUp;
	}

	public JFXListView<Label> getMenuList() {
		return menuList;
	}

	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public Label getAdvSearchLabel() {
		return advSearchLabel;
	}

	public JFXButton getSettingButton() {
		return settingButton;
	}

	public ImageView getDownArrowImg() {
		return downArrowImg;
	}

	public JFXPopup getAdvPopUp() {
		return advPopUp;
	}

	public JFXButton getAdvOkButton() {
		return advOkButton;
	}

	public JFXButton getAdvCancelButton() {
		return advCancelButton;
	}

	public BorderPane getRoot() {
		return root;
	}

	public JFXTextField getNameAdvField() {
		return nameAdvField;
	}

	public JFXTextField getParishAdvField() {
		return parishAdvField;
	}

	public JFXTextField getParishCityAdvField() {
		return parishCityAdvField;
	}

	public JFXDatePicker getDatePicker() {
		return datePicker;
	}
	
	public JFXButton getSettingMenuButton(){
		return settingMenuButton;
	}
}
