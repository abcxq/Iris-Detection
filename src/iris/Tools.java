package iris;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Class provides tools for working with images
 * @author chamomi
 */
public class Tools {
    /**
     * Function for conversion of opencv Mat image to BufferedImage
     * @param m Mat image to be converted
     * @return BufferedImage
     * @throws Exception 
     */
    public static BufferedImage MatToBufferedImage(Mat m)throws Exception {        
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".jpg", m, mob);
        byte ba[] = mob.toArray();
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(ba));
        return bi;
    } 
    
    /**
     * Function for conversion of BufferedImage to opencv Mat image
     * @param in BufferedImage to be converted
     * @return Mat image
     */
    public static Mat BufferedImageToMat(BufferedImage in) {
        Mat out = new Mat(in.getHeight(), in.getWidth(), CvType.CV_8UC3);
        byte[] data = new byte[in.getWidth() * in.getHeight() * (int) out.elemSize()];
        int[] dataBuff = in.getRGB(0, 0, in.getWidth(), in.getHeight(), null, 0, in.getWidth());
        for (int i = 0; i < dataBuff.length; i++) {
                data[i * 3] = (byte) ((dataBuff[i]));
                data[i * 3 + 1] = (byte) ((dataBuff[i]));
                data[i * 3 + 2] = (byte) ((dataBuff[i]));
        }
        out.put(0, 0, data);
        return out;
    }
    
    /**
     * Function for resizing of BufferedImage given new width and height
     * @param image BufferedImage to be resized
     * @param width int value, representing new width
     * @param height int value representing new height
     * @return BufferedImage
     */
    public static BufferedImage Resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }    
}
