package image_processing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GrayConverter {

	public void convertToBlueGray(String source,String destination) {
		BufferedImage image=null;
		File file=null;
		
		file=new File(source);
		try {
			image=ImageIO. read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int rowIndex = 0; rowIndex < image.getWidth(); rowIndex++) {
			for (int colIndex = 0; colIndex < image.getHeight(); colIndex++) {
				Color pixel=new Color(image.getRGB(rowIndex, colIndex));
				int red=pixel.getRed();
				int blue=pixel.getBlue();
				int green=pixel.getGreen();
				int alpha=pixel.getAlpha();
				int average=(red+blue+green)/3;
				red=average;
				blue=average;
				green=average;
				pixel=new Color(red,green,blue);
				int grayValue=pixel.getRGB();
				image.setRGB(rowIndex, colIndex, grayValue);						
				
			}			
			
		}	
		File outputfile = new File(destination);
		try {
			boolean fileWriteStatus=ImageIO.write(image, "jpg", outputfile);
			System.out.println("status: "+fileWriteStatus);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
