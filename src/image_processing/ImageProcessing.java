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
		nR.removeSaltAndPaper("image/balloons_noisy.png", "flipped/balloons_noisynoisefree (2).png", 7);
	}
}
