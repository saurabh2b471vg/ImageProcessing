package image_processing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class NoiseRmover {
	public void removeSaltAndPaper(String source, String destination, int windowSize) {
		BufferedImage image = null;
		File file = new File(source);
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int windowBlue[] = new int[windowSize * windowSize];
		int windowRed[] = new int[windowSize * windowSize];
		int windowGreen[] = new int[windowSize * windowSize];
		int windowAlpha[] = new int[windowSize* windowSize];
		int red,green,blue,alpha;
		for (int rowIndex = windowSize / 2; rowIndex < image.getHeight() - (windowSize / 2); rowIndex++) {
			for (int colIndex = windowSize / 2; colIndex < image.getWidth() - (windowSize / 2); colIndex++) {
				int count=0;
				for (int windowX = rowIndex-(windowSize/2); windowX < rowIndex+(windowSize/2); windowX++) {
					for (int windowY = colIndex-(windowSize/2); windowY < colIndex+(windowSize/2); windowY++) {
						Color pixel=new Color(image.getRGB(windowX, windowY));
						red=pixel.getRed();
						blue=pixel.getBlue();
						green=pixel.getGreen();
						System.out.println(red+" "+green+" "+blue);
						alpha=pixel.getAlpha();
						windowRed[count] = red;
						windowGreen[count]=green;
						windowBlue[count]=blue;	
						windowAlpha[count]=alpha;
						count++;
						
					}
				}
				Arrays.sort(windowGreen);
				Arrays.sort(windowRed);
				Arrays.sort(windowBlue);
				Arrays.sort(windowAlpha);
								
				Color pixel=new Color(windowRed[windowRed.length/2], windowGreen[windowGreen.length/2],windowBlue[windowBlue.length/2]);
				image.setRGB(rowIndex, colIndex, pixel.getRGB());

			}

		}

		File outputfile = new File(destination);
		try {
			boolean fileWriteStatus = ImageIO.write(image, "png", outputfile);
			System.out.println("status: " + fileWriteStatus);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
