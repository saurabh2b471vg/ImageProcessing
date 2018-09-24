package image_processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFlipper {
	public void imageFlipper(String sourse, String destination)
	{
		BufferedImage image=null;
		File file=null;
		file=new File(sourse);
		try {
			image =ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//to find the type of image
		int i=image.getType();
		System.out.println(i);
		for (int rowIndex = 0; rowIndex < image.getWidth()/2; rowIndex++) {
			for (int colIndex = 0; colIndex < image.getHeight(); colIndex++) {
				int tempPixel=image.getRGB(rowIndex, colIndex);
				int lastPixel=image.getRGB(image.getWidth()-rowIndex-1, colIndex);
				image.setRGB(rowIndex, colIndex, lastPixel);
				image.setRGB(image.getWidth()-rowIndex-1, colIndex, tempPixel);
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
