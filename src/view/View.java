/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author acer e1
 */
public class View extends Pane {

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        
        setPrefSize(421*2, 500);
        
        Image image = new Image("http://static.igre123.net/slike/214278-124164/zmaj-moj-zastitni-znak-kickbox-ekipe.jpg");
        ImageView originalView = new ImageView(image);

        ImageView modifiedView = new ImageView();
        modifiedView.setTranslateX(421);

        TextField field = new TextField("Unesite poruku i pritisnite enter"); 
        field.setPrefWidth(200);
        field.setTranslateY(409);
        field.setOnAction(e -> controller.onEncode());
        
        Button btnDecode = new Button("DECODE");
        btnDecode.setTranslateX(421);
        btnDecode.setTranslateY(409);
        btnDecode.setOnAction(e -> controller.onDecode());

        controller.injectUI(originalView, modifiedView, field);

        controller.injectView(originalView, modifiedView);
        getChildren().addAll(originalView, modifiedView, field, btnDecode);
    }

}
