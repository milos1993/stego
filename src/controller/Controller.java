/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Model;

/**
 *
 * @author acer e1
 */
public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void injectView(ImageView original, ImageView modified) {
        this.originalView = original;
        this.modifiedView = modified;
    }

    private ImageView originalView, modifiedView;
    private TextField fieldMessage;

    public void injectUI(ImageView original1, ImageView modified, TextField fieldMessage) {
        this.originalView = originalView;
        this.modifiedView = modified;
        this.fieldMessage = fieldMessage;
    }

    public void onEncode() {
        Image modified =  model.encode(originalView.getImage(), fieldMessage.getText());
        modifiedView.setImage(modified);
    }

    public void onDecode() {
        String message = model.decode(modifiedView.getImage());
        System.out.println(message);
    }

}
