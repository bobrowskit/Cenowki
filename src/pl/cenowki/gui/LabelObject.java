package pl.cenowki.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public abstract class LabelObject {
	
	protected int x;
	protected int y;
	private int width = 100;
	private int height = 50;
	private int widthRectCorner  = 8;
	private int heightRectCorner = 8;
	protected int fontSize = 10;
	protected Font font;
	
	private Point offsetPosition = new Point(0,0);
	private boolean selected;

	
	protected LabelObject() {
	}
	
	public LabelObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setLocation(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width  = width;
		this.height = height;
	}
	
	public void setFontSize(int size) {
		font = font.deriveFont((float)size);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		if(selected) {
			drawSelection(g);
		}
	}
	
	public void drawSelection(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.fillRect(x-widthRectCorner/2, y-heightRectCorner/2, widthRectCorner, heightRectCorner);
		g.fillRect(x-widthRectCorner/2, y+height-heightRectCorner/2, widthRectCorner, heightRectCorner);	    
		g.fillRect(x+width-widthRectCorner/2, y-heightRectCorner/2, widthRectCorner, heightRectCorner);
		g.fillRect(x+width-widthRectCorner/2, y+height-heightRectCorner/2, widthRectCorner, heightRectCorner);
	}
	
	public void setPosition(Point pos) {
		setX((int) (pos.getX() - offsetPosition.getX()));
		setY((int) (pos.getY() - offsetPosition.getY()));
	}
	
	public boolean isLeftUpperCorner(Point p) {
		if(p.getX() >= x-widthRectCorner/2 && p.getX() <= x+widthRectCorner/2 && p.getY() >= y-heightRectCorner/2 &&  p.getY() <= y+heightRectCorner/2) {
			return true;
		}
		return false;
	}

	public boolean isRightUpperCorner(Point p) {
		if(p.getX() >= x+width-widthRectCorner/2 && p.getX() <= x+width+widthRectCorner/2 && p.getY() >= y-heightRectCorner/2 &&  p.getY() <= y+heightRectCorner/2) {
			return true;
		}
		return false;
	}
	
	public boolean isLeftLowerCorner(Point p) {
		if(p.getX() >= x-widthRectCorner/2 && p.getX() <= x+widthRectCorner/2 && p.getY() >= y+height-heightRectCorner/2 &&  p.getY() <= y+height+heightRectCorner/2) {
			return true;
		}
		return false;
	}
	
	public boolean isRightLowerCorner(Point p) {
		if(p.getX() >= x+width-widthRectCorner/2 && p.getX() <= x+width+widthRectCorner/2 && p.getY() >= y+height-heightRectCorner/2 &&  p.getY() <= y+height+heightRectCorner/2) {
			return true;
		}
		
		return false;
	}
	
	public boolean isUnderCursor(Point p) {
		if(p.getX() >= x && p.getX() <= x + width && p.getY() >= y && p.getY() <= y + height ) {
			selected = true;
			return true;
		}
		return false;
	}
	
	public void setOffsetPostion(Point pOffset) {
		offsetPosition = new Point((int) (pOffset.getX() - x), (int) (pOffset.getY() - y));
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setText(String s) {}
	
	public String getText() {return "";};
	
}
