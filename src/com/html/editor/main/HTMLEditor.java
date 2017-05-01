/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.html.editor.main;

import com.html.editor.view.controller.Mainscreen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ahmed.wagdi
 */
public class HTMLEditor extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage)  {
        this.primaryStage =primaryStage;
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setMaximized(true);
        
        new Mainscreen();
        // this.primaryStage.show();
        primaryStage.setOnCloseRequest((e) -> {
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
