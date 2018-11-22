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
		BoundaryValuesHandeler bVH=new BoundaryValuesHandeler();
		image = bVH.addPadding(windowSize/2, image);
		int windowBlue[] = new int[windowSize * windowSize];
		int windowRed[] = new int[windowSize * windowSize];
		int windowGreen[] = new int[windowSize * windowSize];
		int windowAlpha[] = new int[windowSize* windowSize];
		int red,green,blue,alpha;
		for (int y = windowSize / 2; y < image.getHeight() - (windowSize / 2); y++) {
			for (int x = windowSize / 2; x < image.getWidth() - (windowSize / 2); x++) {
				int count=0;
				for (int windowY = y-(windowSize/2); windowY < y+(windowSize/2); windowY++) {
					for (int windowX = x-(windowSize/2); windowX < x+(windowSize/2); windowX++) {
						Color pixel=new Color(image.getRGB(windowX, windowY));
						red=pixel.getRed();
						blue=pixel.getBlue();
						green=pixel.getGreen();
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
				/*for(int i=0;i<9;i++)
				System.out.print(windowGreen[i]+ "   ");
				System.out.println(x);*/
								
				Color pixel=new Color(windowRed[windowRed.length/2], windowGreen[windowGreen.length/2],windowBlue[windowBlue.length/2],windowAlpha[windowAlpha.length/2]);
				image.setRGB(x, y, pixel.getRGB());

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
