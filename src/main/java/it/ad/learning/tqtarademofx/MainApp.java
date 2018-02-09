/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alfonso
 */
public class MainApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("/fxml/app.fxml"));

        Scene scene = new Scene(loader.load());
        
        AppController controller = loader.getController();
        
        controller.setMainStage(primaryStage);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop...");
        System.exit(0);
    }

}
