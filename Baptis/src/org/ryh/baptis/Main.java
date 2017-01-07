package org.ryh.baptis;
import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.core.application.DefaultApplication;
import org.ryh.baptis.resources.BaptisStyle;
import org.ryh.baptis.ui.page.PageModel;

import com.jfoenix.controls.JFXDecorator;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends DefaultApplication<StackPane>{
	
	/**
     * Application launcher.
     * 
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        preloadAndLaunch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> firstModelClass() {
        return PageModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
        stage.setMaximized(true);
    }
    
    @Override
    protected String applicationTitle() {
    	return "Baptis v0.0.1(Alpha)";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeScene(final Scene scene) {
    	JFXDecorator decorator = new JFXDecorator(stage(), rootNode());
    	decorator.setCustomMaximize(true);
    	scene.setRoot(decorator);
    	addCSS(scene, BaptisStyle.MAIN);
    	addCSS(scene, BaptisStyle.COMPONENTS);
    	addCSS(scene, BaptisStyle.DEMO);
    }
    
}
