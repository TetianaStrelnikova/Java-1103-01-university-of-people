import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space {
	private boolean bomb;
	private boolean flagged;
	private boolean cleared;
	private int bombNear;
	// A BufferedImage is a type of object in Java
	// that represents an image, and it allows the program to manipulate the
	// individual pixels of that image. The image data is stored in a buffer
	// that can be accessed and modified directly by the program.
	// When you load an image file into a BufferedImage object,
	// the image data is stored in the memory (RAM) of your computer.
	// The BufferedImage object provides an accessible buffer of image data
	// that you can manipulate directly in your Java program.
	private BufferedImage img;

	public Space(boolean bomb) throws IOException {
		this.bomb = bomb;
		flagged = false;
		cleared = false;
		bombNear = 0;
		
		BufferedImage temp = ImageIO.read(new File("MineSwiper/src/img/facingDown.png"));
		img = Game.resizeImage(temp, Game.WIDTH, Game.HEIGTH);
	}

	public void setImg(String filepath) throws IOException {
		BufferedImage temp = ImageIO.read(new File(filepath/* "MineSwiper/src/img/facingDown.png" */));
		img = Game.resizeImage(temp, Game.WIDTH, Game.HEIGTH);
	}

	public boolean hasBomb() {
		return bomb;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void clear() {
		cleared = true;
	}

	public int getBombNear() {
		return bombNear;
	}

	public void setBombNear(int bombNear) {
		this.bombNear = bombNear;
	}

}
