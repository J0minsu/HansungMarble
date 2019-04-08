package Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CustomImage {
	//filename
	private String fileName;
	//where to draw them x and y
	private int x;
	private int y;	
	//width and height
	private int width;
	private int heght;
	//animated
	boolean m_animated;
	
	//loads big image
	private BufferedImage m_boardSprites;
	//loads small image
	private BufferedImage m_image;
	
	public CustomImage(String fileName, int w, int h, int x, int y) {
		//default is not animated
		m_animated = false;
		try {
			//set big image
			m_boardSprites = ImageIO.read(new File (fileName));
			//get sprite
			m_image = m_boardSprites.getSubimage(x, y, w, h);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	//return image
	public BufferedImage getImage() {
		return m_image;
	}
	//Getters
	public String getFilename() {
		return fileName;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return heght;
	}
	public boolean isAnimated() {
		return m_animated;
	}
}