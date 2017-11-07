package iris;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
/**
 *
 * @author chamomi
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iris Detection", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setName("StartLabel"); // NOI18N
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setName("ResultLabel"); // NOI18N
        jLabel2.setOpaque(true);

        jButton1.setText("Browse");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseClick(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveClick(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText(">>");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Transform(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Initial image");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Resulting image");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(186, 186, 186))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler for opening initial image file and displaying it in jLabel1
     * @param evt mouse click
     */
    private void BrowseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrowseClick
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(500, 400));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg", "bmp"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Image picture = ImageIO.read(new File( file.getAbsolutePath()));
                if(jLabel1.getIcon() != null) jLabel1.setIcon(null);
                jLabel1.setIcon(new ImageIcon(resize((BufferedImage)picture, jLabel1.getWidth(), jLabel1.getHeight())));
            } catch (IOException ex) {
                System.out.println("Problem accessing file"+file.getAbsolutePath());
            }
            } else {
                System.out.println("File access cancelled by user.");
            }
    }//GEN-LAST:event_BrowseClick

    /**
     * Event handler for saving resulting image to file from jLabel2
     * @param evt mouse click
     */
    private void SaveClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveClick
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(500, 400));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg", "bmp"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BufferedImage img = (BufferedImage)((Image)((ImageIcon)jLabel2.getIcon()).getImage());
            
            try {
                ImageIO.write(img, "jpg", file);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }//GEN-LAST:event_SaveClick

    /**
     * Event handler for image transformation button
     * Implements main logic
     * Gets image opened by BrowseClick(..) from jLabel1, displays result image jLabel2
     * @param evt mouse click
     */
    private void Transform(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Transform
        BufferedImage img = (BufferedImage)((Image)((ImageIcon)jLabel1.getIcon()).getImage());
        Mat mimg = BufferedImageToMat(img);
        Mat mimg1 = mimg.clone();
               
        Mat dest = new Mat();
        dest = FindPupil(mimg);
        dest = FindIris(mimg1, dest);

        try {
            img = MatToBufferedImage(dest);
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel2.setIcon(new ImageIcon(resize(img, jLabel2.getWidth(), jLabel2.getHeight())));
        
        dest.release();
        mimg.release();
        mimg1.release();
    }//GEN-LAST:event_Transform

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
        
        System.out.println(m==null);
        Imgproc.GaussianBlur(m, m, new Size(9, 9), NORMAL);
        
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
        int hmax = histmax(horp), vmax = histmax(vertp);
        int dmax = histmax(diagp), dmax1 = histmax(diagp1);
        
        double newx = hmax;
        double newy = vmax;
        int rad = (findRadius(horp, hmax) + findRadius(vertp, vmax) + findRadius(diagp, dmax) + findRadius(diagp1, dmax1))/4;
        
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
        int hmax = histmax(horp), vmax = histmax(vertp);
        
        double newx = hmax;
        double newy = vmax;
        int rad = (findRadius(horp, hmax) + findRadius(vertp, vmax))/2;
        
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
    public int findRadius(int[] h, int center)
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
    public int histmax(int[] h)
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
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                File opencvLibrary = new File(System.mapLibraryName("opencv_java330"));
                System.load(opencvLibrary.getAbsolutePath());
                
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
