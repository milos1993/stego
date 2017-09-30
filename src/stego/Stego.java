/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stego;

import controller.Controller;
import initComponent.BasicDecoder;
import initComponent.BasicEncoder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import view.View;

/**
 *
 * @author acer e1
 */
public class Stego extends Application {
    
    private Model makeModel(){
        return new Model(new BasicEncoder(), new BasicDecoder());
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new View(new Controller(makeModel())));
        primaryStage.setTitle("StegoAplikacija");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
