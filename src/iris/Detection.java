package iris;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 * Class provides instruments for detection of iris and pupil on an image
 * @author chamomi
 */
public class Detection {
    public Detection(){}
    
    /**
     * Function to detect and draw contours of iris on image
     * @param in Mat image on which to perform detection
     * @param out Mat image on which to draw detected contours
     * @return Mat image given as parameter out with iris contours drawn
     */
    public Mat FindIris(Mat in, Mat out)
    {      
        Imgproc.cvtColor(in, in, Imgproc.COLOR_BGR2GRAY);
        Mat m = in.clone();
        
        //adaptive thresholding
        int max = -1, min = 10000;
        for(int i=0;i < in.rows();i++)
            for(int j=0; j < in.cols(); j++)
            {
                if(in.get(i, j)[0] > max) max = (int) in.get(i, j)[0];
                if(in.get(i, j)[0] < min) min = (int) in.get(i, j)[0];
            }              
        int threshold = (int) (0.5 * (max + min) + 0.5);
        int thchange = 3;
        
        while(thchange > 1)
        {
            Imgproc.threshold(in, m, threshold, 255.0, Imgproc.THRESH_BINARY_INV);
            
            int g1 = 0, g2 = 0;
            int num1 = 0, num2 = 0;
            
            for(int i=0; i < in.rows(); i++)
                for(int j=0; j < in.cols(); j++)
                {
                    if(m.get(i, j)[0] == 0)
                    {
                        g1 += in.get(i, j)[0];
                        num1++;
                    }
                    if(m.get(i, j)[0] == 1) 
                    {
                        g2 += in.get(i, j)[0];
                        num2++;
                    }
                }
            thchange = (int) (0.5 * (g1/num1 + g2/num2)) - threshold;
            threshold = (int) (0.5 * (g1/num1 + g2/num2));
        }   
        
        Imgproc.GaussianBlur(m, m, new Size(9, 9), Imgproc.CV_GAUSSIAN);
        
        //perform erosion and dilation
        Mat elemente = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(7, 7));
        Mat elementd = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(3, 3));
        Imgproc.erode(m, m, elemente);
        Imgproc.dilate(m, m, elementd);
        
        //find projections
        int[] vertp = new int[m.rows()];
        int[] horp = new int[m.cols()];
        for(int i=0; i < m.rows(); i++)
            for(int j=0; j < m.cols(); j++)
            {
                if(m.get(i, j)[0] > 200)
                {
                    vertp[i] += 1;
                    horp[j] += 1;
                }
            }
        
        //find diagonal projections
        int[] diagp = new int[m.rows() * m.cols()];
        int[] diagp1 = new int[m.rows() * m.cols()];
        double constx = Math.sqrt(2)/2, consty = Math.sqrt(2)/2;
        for(int i=0; i < m.rows(); i++)
            for(int j=0; j < m.cols(); j++)
            {
                if(m.get(i, j)[0] > 200) 
                {
                    diagp[(int)(i * constx + j * consty)] += 1;
                    diagp1[(int)(i * constx + j * consty * (-1) + m.width() * Math.sqrt(2)/2)] += 1;
                }
            }
     
        //find indexes of max of projections, draw circle based on center given by maxes
        int hmax = HistMax(horp), vmax = HistMax(vertp);
        int dmax = HistMax(diagp), dmax1 = HistMax(diagp1);
        
        double newx = hmax;
        double newy = vmax;
        int rad = (FindRadius(horp, hmax) + FindRadius(vertp, vmax) + FindRadius(diagp, dmax) + FindRadius(diagp1, dmax1))/4;
        
        Point pt = new Point(newx, newy);
        Imgproc.circle(out, pt, rad, new Scalar(255, 0, 0), 2);    

        return out;
    }
    
    /**
     * Function to detect and draw pupil on image
     * @param m Mat image for detection
     * @return Mat image as input one with drawn pupil circle
     */
    public Mat FindPupil(Mat m)
    {
        Mat mnew = m.clone();
        
        //grayscale and threshold
        Imgproc.cvtColor(m, m, Imgproc.COLOR_BGR2GRAY);       
        Imgproc.threshold(m, m, 50, 255, Imgproc.THRESH_BINARY);
        
        //perform erosion and dilation
        Imgproc.erode(m, m, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(3, 3)));
        Imgproc.dilate(m, m, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(6, 6)));
        
        //find projections
        int[] vertp = new int[m.rows()];
        int[] horp = new int[m.cols()];
        for(int i=0; i < m.rows(); i++)
            for(int j=0; j < m.cols(); j++)
            {
                if(m.get(i, j)[0] == 0)
                {
                    vertp[i] += 1;
                    horp[j] += 1;
                }
            }
     
        //find indexes of max of projections, draw circle based on center given by maxes
        int hmax = HistMax(horp), vmax = HistMax(vertp);
        
        double newx = hmax;
        double newy = vmax;
        int rad = (FindRadius(horp, hmax) + FindRadius(vertp, vmax))/2;
        
        Point pt = new Point(newx, newy);
        Imgproc.circle(mnew, pt, rad, new Scalar(0, 255, 0), 2);  
        
        return mnew;
    }
    
    /**
     * Finds radius on projection array with given center(index)
     * @param h int[] h array, representing image projection, on which radius is to be found
     * @param center integer representing center of prospecting center, is an index of array int[] h
     * @return integer representing radius
     */
    public int FindRadius(int[] h, int center)
    {
        int i = center;
        while((i < h.length-1) && (h[i] > h[center]/5)) i++;
        int j = center;
        while((j >= 0) && (h[j] > h[center]/5)) j--;
        
        return (i - j)/2;
    }
    
    /**
     * Function to find averaged position of maximal elements
     * @param h input array for search
     * @return integer representing index of array found as mean of 3 maximal peaks
     */
    public int HistMax(int[] h)
    {
        int hmax1 = -1, hmax2 = -1, hmax3 = -1;
        int imax1 = -1, imax2 = -1, imax3 = -1;
        
        for(int i=0; i < h.length; i++)
        {
            if(h[i] > hmax1)
            {
                hmax3 = hmax2;
                imax3 = imax2;
                
                hmax2 = hmax1;
                imax2 = imax1;
                
                hmax1 = h[i];
                imax1 = i;
            }
            else if(h[i] > hmax2)
            {
                hmax3 = hmax2;
                imax3 = imax2;
                
                hmax2 = h[i];
                imax2 = i;
            }
            else if(h[i] > hmax3)
            {
                hmax3 = h[i];
                imax3 = i;
            }
        }  
        
        return (imax1 + imax2 + imax3)/3;
    }
}
