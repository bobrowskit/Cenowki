package pl.cenowki.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import pl.cenowki.items.LabelObject;
import pl.cenowki.items.Text;

public class LabelEdition extends JPanel  {
	
	
	private static final long serialVersionUID = 1L;
	private Image offscreen;
	private Graphics2D offgc;
	private LabelObject selectedRectangle;
	private LinkedList<LabelObject> list = new LinkedList<LabelObject>();
	private Class<? extends LabelObject> objectToDraw;
	JTextField textEditor = null; 
	
	private boolean leftUpperCorner  = false;
	private boolean rightUpperCorner = false;
	private boolean leftLowerCorner  = false;
	private boolean rightLowerCorner = false;

	public LabelEdition() {
		super();
		initMouseListeners();
	}
	
	public void unselectAll() {
		for(LabelObject r : list) {
			r.setSelected(false);
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {

		offscreen = createImage(this.getWidth(), this.getHeight());
		offgc = (Graphics2D) offscreen.getGraphics();
		offgc.setStroke(new BasicStroke(2.0f));
		offgc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		offgc.setColor(Color.WHITE);
		offgc.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(LabelObject r : list) {
			r.draw(offgc);
		}
		g.drawImage(offscreen, 0, 0, this);
		super.paint(g); //draw swing components on top
	}

	public void setClassToDraw(Class<? extends LabelObject> lo) {
		objectToDraw = lo;
	}
	
	public void setFontSize(int size) {
		if(selectedRectangle != null) {
			selectedRectangle.setFontSize(size);
			repaint();
		}
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
	}
	
	
	public void removeSelectedObject() {
		if(selectedRectangle != null) {
			list.remove(selectedRectangle);
			repaint();
		}
	}
	
	private void initMouseListeners() {
		addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectedRectangle != null) {
					selectedRectangle = null;
					return;
				}
				if(objectToDraw == null) return;
				LabelObject newObject;
				try {
					newObject = objectToDraw.newInstance();
					newObject.setPosition(e.getPoint());
					list.add(newObject);
					repaint();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				leftUpperCorner = false;
				rightUpperCorner = false;
				leftLowerCorner = false;
				rightLowerCorner = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectedRectangle = null;
				unselectAll();
				for(LabelObject r : list) {
					if(r.isUnderCursor(e.getPoint())) {
						selectedRectangle = r;
						selectedRectangle.setOffsetPostion(e.getPoint());
						repaint();
					}
				}
			}

		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e) && selectedRectangle != null ) {
					if(selectedRectangle.isLeftUpperCorner(e.getPoint())) leftUpperCorner = true;
					else if (selectedRectangle.isLeftLowerCorner(e.getPoint())) leftLowerCorner = true;
					else if (selectedRectangle.isRightUpperCorner(e.getPoint())) rightUpperCorner = true;
					else if (selectedRectangle.isRightLowerCorner(e.getPoint())) rightLowerCorner = true;
					
					if(leftUpperCorner)  selectedRectangle.setLocation(e.getX(), e.getY(), selectedRectangle.getX()-e.getX()+selectedRectangle.getWidth(), selectedRectangle.getY()-e.getY()+selectedRectangle.getHeight());
					else if(leftLowerCorner) selectedRectangle.setLocation(e.getX(), selectedRectangle.getY(), selectedRectangle.getX()-e.getX()+selectedRectangle.getWidth(), e.getY() - selectedRectangle.getY());	
					else if(rightUpperCorner) selectedRectangle.setLocation(selectedRectangle.getX(), e.getY(), e.getX() - selectedRectangle.getX(), selectedRectangle.getY() - e.getY() + selectedRectangle.getHeight() );	
					else if(rightLowerCorner) selectedRectangle.setLocation(selectedRectangle.getX(), selectedRectangle.getY(), e.getX() - selectedRectangle.getX(),e.getY() - selectedRectangle.getY());	
					 else  {
						selectedRectangle.setPosition(e.getPoint());
					}
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				if(selectedRectangle != null && selectedRectangle.isUnderCursor(e.getPoint())) {
					if(selectedRectangle.isLeftUpperCorner(e.getPoint())) {
						setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
					} else if(selectedRectangle.isRightUpperCorner(e.getPoint())) {
						setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
					} else if (selectedRectangle.isLeftLowerCorner(e.getPoint())) {
						setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
					} else if (selectedRectangle.isRightLowerCorner(e.getPoint())) {
						setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
					} 
				}
			}
		});
	}
	
	public void openTextEditor() {
		if(selectedRectangle == null ) return;
		if(!(selectedRectangle instanceof Text)) return;
		
		textEditor = new JTextField(selectedRectangle.getText());
		textEditor.setLocation(selectedRectangle.getX(), selectedRectangle.getY());
		textEditor.setSize(selectedRectangle.getWidth(), selectedRectangle.getHeight());
		this.add(textEditor);
		textEditor.requestFocus();
		textEditor.selectAll();
		textEditor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					selectedRectangle.setText(textEditor.getText());
					System.out.println(textEditor.getText());
					removeTextEditor(textEditor);	
					repaint();
				}
			}

		});
	}
	
	public void removeTextEditor(JTextField t) {
		this.remove(t);
	}
}
