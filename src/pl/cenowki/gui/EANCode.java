package pl.cenowki.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import pl.cenowki.EANFonts;

public class EANCode extends LabelObject {
	
	public static String exampleEAN = "01234567891234";

	public EANCode() {
		super();
		font = EANFonts.getFont().deriveFont((float) fontSize);
	}
	
	public EANCode(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics(font);
		if(getHeight() < fm.getHeight()) setHeight(fm.getHeight()+20);
		if(getWidth() < fm.stringWidth(exampleEAN)) setWidth(fm.stringWidth(exampleEAN)+20);
		super.draw(g);
		g.setColor(Color.RED);
		g.drawString(exampleEAN, x+10, y+getHeight()-fm.getDescent()-10);
	}

}
