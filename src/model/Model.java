/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import init.Decoder;
import init.Encoder;
import javafx.scene.image.Image;


/**
 *
 * @author acer e1
 */
public class Model {
   
    private Encoder encoder;
    private Decoder decoder;
    
    public Model(Encoder encoder, Decoder decoder){
        this.encoder = encoder;
        this.decoder = decoder;
        
    }
    
    public Image encode(Image image, String message){
    return encoder.encode(image, message);
}    

    public String decode(Image image) {
         return decoder.decode(image);
    }

    
    
    
    
    
}
