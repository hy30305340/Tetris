package Tetris;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * author: Jingyu Wang ( JingyuWang1988@gmail.com), Date: 2017-12-24, Time: 11:31 PM
 * Description:
 */

public class ImageLoader {

    public static Image[] loadImage(String path, int width) throws IOException{
        BufferedImage load = ImageIO.read(ImageLoader.class.getResource(path));
        Image[] images = new Image[load.getWidth() / width];
        for(int i = 0; i < images.length; i++){
            images[i] = load.getSubimage(i * width, 0, width, width);
        }
        return images;
    }
}
