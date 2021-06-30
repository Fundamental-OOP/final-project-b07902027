package mushroom_battle.view;

import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.*;

public class ImageJPanel extends JPanel{

    protected BufferedImage image;
    protected String imagePath;
    int imageWidth, imageHeight;

    private BufferedImage loadImage(String imagePath){
        BufferedImage result = null;
        try{
            result = ImageIO.read(new File(imagePath));
        } catch(IOException e){
            System.err.println("Error: image path " + imagePath + " doesn't exists.");
            System.exit(1);
        }
        return result;
    }

    public void setImage(String imagePath, int width, int height){
        this.imagePath = imagePath;
        image = loadImage(imagePath);
        this.imageWidth = width;
        this.imageHeight = height;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, imageWidth, imageHeight, null);
    }
}
