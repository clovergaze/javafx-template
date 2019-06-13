package org.infokin.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.infokin.Global;
import org.infokin.controller.api.Controller;
import org.infokin.util.LayoutLoader;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for main view.
 */
public class MainViewController extends Controller {

    /*------------------
    | Member variables |
    ------------------*/

    // ...

    /*---------------------------
    | User interface components |
    ---------------------------*/

    /**
     * The root node of this view.
     */
    @FXML
    private BorderPane rootNode;

    /*--------------------
    | Life cycle methods |
    --------------------*/

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /*-------------------------
    | User interface handlers |
    -------------------------*/

    @FXML
    private void handleCloseApplication() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void handleAboutApplication() {
        Stage dialogStage = new Stage();
        AboutDialogViewController aboutViewController = null;

        try {
            // Load dialog layout
            aboutViewController = (AboutDialogViewController) LayoutLoader.loadLayout(Global.ABOUT_DIALOG_VIEW_LAYOUT).getController();
        } catch (LoadException e) {
            e.printStackTrace();

            Platform.exit();
            System.exit(0);
        }

        // Add event handler to close dialog
        aboutViewController.getOkButton().setOnAction(event -> dialogStage.close());

        dialogStage.setScene(new Scene(aboutViewController.getRootNode()));
        dialogStage.setResizable(false);

        dialogStage.initOwner(Global.primaryStage);
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        dialogStage.show();
    }

    /*---------
    | Methods |
    ---------*/

    // ...

    /*---------------------
    | Getters and Setters |
    ---------------------*/

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderPane getRootNode() {
        return rootNode;
    }
}
