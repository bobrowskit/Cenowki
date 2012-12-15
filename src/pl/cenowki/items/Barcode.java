package pl.cenowki.items;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.cenowki.BarcodeFont;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Barcode")
public class Barcode extends LabelObject {
	
	public static String exampleEAN = "01234567891234";

	public Barcode() {
		super();
		font = BarcodeFont.getFont().deriveFont((float) fontSize);
	}
	
	public Barcode(int x, int y) {
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
