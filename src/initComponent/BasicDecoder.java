/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initComponent;

import init.Decoder;
import java.util.stream.IntStream;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import javafx.util.Pair;

/**
 *
 * @author acer e1
 */
public class BasicDecoder implements Decoder {

    @Override
    public String decode(Image image) {

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        PixelReader reader = image.getPixelReader();

        boolean[] bits = new boolean[width * height];

        IntStream.range(0, width * height)
                .mapToObj(i -> new Pair<>(i, reader.getArgb(i % width, i / width)))
                .forEach(pair -> {
                    String binary = Integer.toBinaryString(pair.getValue());
                    bits[pair.getKey()] = binary.charAt(binary.length() - 1) == '1';

                });
        int length = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i]) {
                length |= (1 << (31 - i));

            }
        }
        byte[] data = new byte[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 8; j++) {
                if (bits[32 + i * 8 + j]) {
                    data[i] |= (1 << (7 - j));
                }
            }
        }

        return new String(data);

    }

}
