/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.html.editor.view.controller;

import com.html.editor.main.HTMLEditor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author ahmed.wagdi
 */
public class Mainscreen extends AnchorPane {

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextArea textarea;

    @FXML
    private TreeView<String> tree;

    private String rootIconPath = "/com/html/editor/resources/rootIcon.png";
    private String filePath = "/com/html/editor/resources/file.png";
    private String folderPath = "/com/html/editor/resources/folder.png";
    private String iconImagePath = "/com/html/editor/resources/html.png";

    public Mainscreen() {
        try {
            //---------------------------- FXML Loading ---------------------------------------------------------
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/html/editor/view/fxml/MainscreenFXML.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
            Scene scene = new Scene(this);

            HTMLEditor.primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/com/html/editor/resources/mycss.css").toString());
            HTMLEditor.primaryStage.setTitle("HTML Editor");
            HTMLEditor.primaryStage.getIcons().add(new Image(iconImagePath));
            String startText = "<h1> Hello HTML Editor </h1>";
            textarea.setText(startText);
            onChangeInEditor(startText);
            HTMLEditor.primaryStage.show();
            TreeItem<String> dummyRoot = populateTheTree();
            tree.setRoot(dummyRoot);
            tree.setShowRoot(false);

            textarea.setOnKeyReleased((e) -> {
                String text = textarea.getText();
                onChangeInEditor(text);
            });

        } catch (IOException ex) {
            Logger.getLogger(Mainscreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private TreeItem<String> populateTheTree() {
        
        
        //---------------------------- Tree Loading ---------------------------------------------------------
        TreeItem<String> dummyRoot = new TreeItem<String>(" ");
        //node 0
        TreeItem<String> node_0
                = new TreeItem<String>("Home", (Node) new ImageView(new Image(getClass().getResourceAsStream(rootIconPath))));
        TreeItem<String> node_00
                = new TreeItem<String>("Services", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_01
                = new TreeItem<String>("Download", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_02
                = new TreeItem<String>("Order", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_03
                = new TreeItem<String>("Support", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        //node 1
        TreeItem<String> node_1
                = new TreeItem<String>("Level 0 Item 1", (Node) new ImageView(new Image(getClass().getResourceAsStream(rootIconPath))));
        TreeItem<String> node_10
                = new TreeItem<String>("Level 1 Item 0", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_11
                = new TreeItem<String>("Level 1 Item 1", (Node) new ImageView(new Image(getClass().getResourceAsStream(folderPath))));
        TreeItem<String> node_110
                = new TreeItem<String>("Level 2 Item 0", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_111
                = new TreeItem<String>("Level 2 Item 1", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_12
                = new TreeItem<String>("Level 1 Item 2", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        TreeItem<String> node_13
                = new TreeItem<String>("Level 1 Item 3", (Node) new ImageView(new Image(getClass().getResourceAsStream(filePath))));
        //add nodes
        node_0.getChildren().addAll(node_00, node_01, node_02, node_03);
        node_11.getChildren().addAll(node_110, node_111);
        node_1.getChildren().addAll(node_10, node_11, node_12, node_13);
        dummyRoot.getChildren().addAll(node_0, node_1);
        dummyRoot.setExpanded(true);
        node_0.setExpanded(true);
        node_1.setExpanded(true);
        return dummyRoot;
    }

    private void onChangeInEditor(String text) {
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.loadContent(text);
        scrollpane.setContent(browser);
//        System.out.println("Content setted for text  " + text);
    }

}
