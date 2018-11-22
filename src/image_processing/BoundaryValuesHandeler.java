package image_processing;

import java.awt.image.BufferedImage;
import java.io.File;

public class BoundaryValuesHandeler {
	public BufferedImage addPadding(int size, BufferedImage image)
	{
		
		BufferedImage image2=new BufferedImage(image.getWidth()+(2*size), image.getHeight()+(2*size), image.getType() );
		for(int y=0;y<image.getHeight();y++)
		{
			for(int x=0;x<image.getWidth();x++)
			{
				image2.setRGB(x+size, y+size, image.getRGB(x, y));				
			}
		}
		return image2;
	}

}
