package image_processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

public class ImageProcessing {
	public static void main(String args[])
	{
		NoiseRmover nR=new NoiseRmover();
		nR.removeSaltAndPaper("image/large.jpg", "flipped/noiseless.jpg", 13);
	}
}
