package pl.cenowki.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends LabelObject {
	
	String text = "";

	public Text() {
		super();
		font = new Font("serif", Font.PLAIN, 15);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString(text , x+5, y+getHeight()-5);
	}

	@Override
	public void setText(String s) {
		this.text = s; 
	}

	@Override
	public String getText() {
		return text;
	}
	
	
	
	
}
