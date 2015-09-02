import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Panel;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StanfordPyramid {

    private final Color BLACK      = Color.BLACK;
    private JFrame frame;
    private BufferedImage image;
    private Graphics2D boxGraphic;
    private int heighth;
    private int width;
    private int baseCount;
	private JLabel boxLabel;
	private String title;
	
	public StanfordPyramid() {
		this.frame = new JFrame();
	}

	public StanfordPyramid(int width, int heighth, int baseCount, String title) {
		this.frame = new JFrame();
		setLayout(width, heighth, baseCount);
		setTitle(title);
		setImage();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void show() {
        this.frame = this.setFrameProperties(this.frame, this.boxLabel, false, JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.requestFocusInWindow();
        this.frame.setVisible(true);
        this.frame.repaint();
		
	}

	public void setLayout(int width, int heighth, int baseCount) {
		this.width = width;
		this.heighth = heighth;
		this.baseCount = baseCount;
	}
	public void setImage() {
		this.image = new BufferedImage(	getWindowWidth(this.width, this.baseCount), 
										getWindowHeighth(this.heighth, this.baseCount),
										BufferedImage.TYPE_INT_ARGB);
		setGraphic();
		setBoxLabel();
	}
	public void setBoxLabel() {
        ImageIcon icon = new ImageIcon(this.image);
        this.boxLabel = new JLabel(icon);
	}
	
	public void setGraphic() {
        boxGraphic = this.image.createGraphics();
        boxGraphic.setPaint(Color.BLACK);
        boxGraphic = this.fillBoxes(boxGraphic);
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public  JFrame setFrameProperties(JFrame frame, JLabel label, boolean resizeable, int defaultCloseOperation) {
        frame.setContentPane(label);
        frame.setResizable(resizeable);
        frame.setDefaultCloseOperation(defaultCloseOperation);            // closes all windows
        frame.setTitle(this.title);
        return frame;
	}
	
	public  Graphics2D fillBoxes(Graphics2D boxGraphic) {
        for (int i=0; i < this.baseCount ;i++) {
        	int startingX = getWindowWidth(this.width, this.baseCount)/2 - (((i+1)*this.width)/2);
        	int startingY = i * this.heighth;
        	System.out.println("startingX: " + startingX);
        	System.out.println("startingY: " + startingY);
        	for (int j=0; j < i; j++) {
                boxGraphic.draw(new Rectangle2D.Double(	(startingX+(j*this.width)), 
                										startingY, 
                										this.width, 
                										this.heighth));
        	}
        }
        return boxGraphic;
	}
	
	public  int getWindowWidth(int width, int baseCount) {
		return width*baseCount;
	}
	
	public int getWindowHeighth(int heighth, int baseCount) {
		return heighth*baseCount;
	}
	
}
