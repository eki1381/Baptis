package org.ryh.baptis.ui.search;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.api.ui.annotation.OnAction;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.DefaultView;
import org.ryh.baptis.beans.Databaptis;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

@RootNodeId("SearchPanel")
public class SearchView extends DefaultView<SearchModel, BorderPane, SearchController>{
    
    private JFXTextField searchField;
    private JFXSpinner loadingSpinner;
    private Label totalResult;
    private VBox notFoundContainer;
	private JFXListView<Databaptis> list = new JFXListView<Databaptis>();;
	    
    @OnAction(name = "Search")
    private JFXButton searchButton;

    public SearchView(final SearchModel model) throws CoreException {
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
        ImageView logoImage = new ImageView();
        logoImage.setFitWidth(150);
        logoImage.setFitHeight(150);
        
        HBox searchPane = new HBox();
        searchPane.setSpacing(20);
    	
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

        searchPane.getChildren().addAll(searchField,searchButton);
        searchPane.setAlignment(Pos.CENTER_LEFT);
        
        this.totalResult = new Label();
        totalResult.getStyleClass().add("hasil");
        topPane.setMargin(totalResult, new Insets(0,20,10,0));
        topPane.setAlignment(totalResult, Pos.CENTER_RIGHT);
             
        topPane.setLeft(logoImage);
        topPane.setCenter(searchPane);
        topPane.setBottom(totalResult);
        topPane.setStyle("-fx-background-color : #5264AE");
        topPane.setEffect(ds);
        
        node().setTop(topPane);
        node().setStyle("-fx-background-color : #F5F5F5");
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
		node().setCenter(loadingSpinner);
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
		
		node().setCenter(notFoundContainer);
	}
	
	@SuppressWarnings("static-access")
	public void showSearchResult(){
		
		list.getStyleClass().add("mylistview");
		
		node().setCenter(list);
		node().setMargin(list, new Insets(20));
		list.depthProperty().set(1);
	}
	
	public void setTotalResult(String total){
		totalResult.setText(total);
	}
	
	public JFXListView<Databaptis> getList(){
		return this.list;
	}
	
}
