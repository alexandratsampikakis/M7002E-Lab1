import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;
 
/**
 * Programmere: Alexandra Tsampikakis, aletsa-8
 * Date: 20120117
 * Last update: 20120122, Alexandra Tsampikakis,
 * Description: 
 * Version: 1.0
 */
public class Graphics implements GLEventListener, KeyListener {
	
    public static void main(String[] args) {
        canvas.addGLEventListener(new Graphics());
        frame.add(canvas);
        frame.setSize(640, 480);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        frame.setVisible(true);
        canvas.requestFocus();
    }
    
    static GLU glu = new GLU();
    static GLCanvas canvas = new GLCanvas();
    static Frame frame = new Frame("Jogl Quad drawing");
    
    /**
     * Draw a square.
     * @param gLDrawable
     * @param topLeftX, the x-coordinate of the top left corner in the square.
     * @param toplLeftY, the y-coordinate of the top left corner in the square.
     * @param size, the sizes of the lines.
     */
    public void square(GLAutoDrawable gLDrawable, float topLeftX, float toplLeftY, float size){
    	final GL2 gl = gLDrawable.getGL().getGL2();
    	gl.glBegin(GL2.GL_QUADS);          
	        gl.glColor3f(0, 0, 1);
	        gl.glVertex2f(topLeftX, toplLeftY);
	        gl.glVertex2f( topLeftX+size, toplLeftY);    		// Top Right
	        gl.glVertex2f( topLeftX+size, toplLeftY-size);    	// Bottom Right
	        gl.glVertex2f(topLeftX, toplLeftY-size);     		// Bottom Left
        gl.glEnd();
    }
    
    /**
     * Draw a pyramid.
     * @param gLDrawable
     * @param topX, the top x-coordinator in the pyramid.
     * @param topY, the top y-coordinator in the pyramid.
     */
    public void pyramid(GLAutoDrawable gLDrawable, float topX, float topY, float topZ){
    	final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glBegin(GL2.GL_LINE_LOOP);
	        gl.glColor3f(1, 1, 1);
	        
	        //gl.glVertex3f(1.0f, 1.5f, 0.0f);		// To top
	        
	        //Draws the quad
	        gl.glVertex3f(topX-0.5f, topY-2.0f, topZ-0.5f);		// Bottom left #1
	        gl.glVertex3f(topX+0.5f, topY-2.0f, topZ-0.5f);		// Bottom right #2
	        gl.glVertex3f(topX+0.5f, topY-2.0f, topZ+0.5f);		// Top right #3
	        gl.glVertex3f(topX-0.5f, topY-2.0f, topZ+0.5f);		// Top left #4
	        
	        //To top
	        gl.glVertex3f(topX-0.5f, topY-2.0f, topZ-0.5f);		// Bottom left #1
	        gl.glVertex3f(topX, topY, 0.0f);				// To top
	        
	        gl.glVertex3f(topX+0.5f, topY-2.0f, topZ-0.5f);		// Bottom right #2
	        gl.glVertex3f(topX, topY, 0.0f);				// To top
	        
	        gl.glVertex3f(topX+0.5f, topY-2.0f, topZ+0.5f);		// Top right #3
	        gl.glVertex3f(topX, topY, 0.0f);				// To top
	        
	        gl.glVertex3f(topX-0.5f, topY-2.0f, topZ+0.5f);		// Top left #4
	        gl.glVertex3f(topX, topY, 0.0f);				// To top
        gl.glEnd();
    }
    
    /**
     * Draw a green star.
     * @param gLDrawable
     * @param middleX, the x-coordinator in the middle of the star.
     * @param middleY, the y-coordinator in the middle of the star.
     */
    public void star(GLAutoDrawable gLDrawable, float middleX, float middleY){
    	final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glBegin(GL2.GL_TRIANGLES);
    	gl.glColor3f(0, 1, 0); //Sets the color to green
    	
    	//#1
        gl.glVertex3f(middleX-1.0f, middleY+0.4f, 0.0f);		// Top
        gl.glVertex3f(middleX-0.5f, middleY, 0.0f);				// Bottom left
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom right
        
        //#2
        gl.glVertex3f(middleX-0.3f, middleY+0.4f, 0.0f);		// Top
        gl.glVertex3f(middleX-1.0f, middleY+0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom right
        
        //#3
        gl.glVertex3f(middleX, middleY+1.0f, 0.0f);				// Top
        gl.glVertex3f(middleX-0.3f, middleY+0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom right
        
        //#4
        gl.glVertex3f(middleX, middleY+1.0f, 0.0f);				// Top
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom left
        gl.glVertex3f(middleX+0.3f, middleY+0.4f, 0.0f);		// Bottom right
        
        //#5
        gl.glVertex3f(middleX+0.3f, middleY+0.4f, 0.0f);		// Top
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom left
        gl.glVertex3f(middleX+1.0f, middleY+0.4f, 0.0f);		// Bottom right
        
        //#6
        gl.glVertex3f(middleX+1.0f, middleY+0.4f, 0.0f);		// Top
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom left
        gl.glVertex3f(middleX+0.5f, middleY, 0.0f);				// Bottom right
        
        //#7
        gl.glVertex3f(middleX+0.5f, middleY, 0.0f);				// Top
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom left
        gl.glVertex3f(middleX+1.0f, middleY-0.4f, 0.0f);		// Bottom right
        
        //#8
        gl.glVertex3f(middleX, middleY, 0.0f);					// Top
        gl.glVertex3f(middleX+0.3f, middleY-0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX+1.0f, middleY-0.4f, 0.0f);		// Bottom right
        
        //#9
        gl.glVertex3f(middleX, middleY, 0.0f);					// Top
        gl.glVertex3f(middleX, middleY-1.0f, 0.0f);				// Bottom left
        gl.glVertex3f(middleX+0.3f, middleY-0.4f, 0.0f);		// Bottom right
        
        //#10
        gl.glVertex3f(middleX, middleY, 0.0f);					// Top
        gl.glVertex3f(middleX-0.3f, middleY-0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX, middleY-1.0f, 0.0f);				// Bottom right
        
        //#11
        gl.glVertex3f(middleX, middleY, 0.0f);					// Top
        gl.glVertex3f(middleX-1.0f, middleY-0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX-0.3f, middleY-0.4f, 0.0f);		// Bottom right
        
      //#12
        gl.glVertex3f(middleX-0.5f, middleY, 0.0f);				// Top
        gl.glVertex3f(middleX-1.0f, middleY-0.4f, 0.0f);		// Bottom left
        gl.glVertex3f(middleX, middleY, 0.0f);					// Bottom right
    gl.glEnd();
    }
    
    /**
     * 
     */
    public void display(GLAutoDrawable gLDrawable) {
    	final GL2 gl = gLDrawable.getGL().getGL2();
    	gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
 
        square(gLDrawable, -3.0f, 2.0f, 0.5f);
        pyramid(gLDrawable, 1.0f, 1.5f, 1.0f);
        star(gLDrawable, -1.4f, 0.3f);
    }
 
    /**
     * 
     * @param gLDrawable
     * @param modeChanged
     * @param deviceChanged
     */
    public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
    }
 
    /**
     * 
     */
    public void init(GLAutoDrawable gLDrawable) {
        GL2 gl = gLDrawable.getGL().getGL2();
        gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        ((Component) gLDrawable).addKeyListener(this);
    }
 
    /**
     * 
     */
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        GL2 gl = gLDrawable.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        float h = (float) width / (float) height;
        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(50.0f, h, 1.0, 1000.0);
        gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
 
    /**
     * 
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            exit();
        }
    }
 
    /**
     * 
     */
    public void keyReleased(KeyEvent e) {
    }
 
    /**
     * 
     */
    public void keyTyped(KeyEvent e) {
    }
 
    /**
     * 
     */
    public static void exit() {
        frame.dispose();
        System.exit(0);
    }
    
    /**
     * 
     */
    public void dispose(GLAutoDrawable gLDrawable) {
        // do nothing
    }
}