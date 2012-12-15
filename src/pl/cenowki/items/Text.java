package pl.cenowki.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "text")
public class Text extends LabelObject {
	
	@XmlElement(name="text")
	String text;
	@XmlElement(name="textType")
	TextType textType;
	
	
	public Text() {
		super();
		font = new Font("serif", Font.PLAIN, 15);
	}
	
	@Override
	public void draw(Graphics g) {
		if(text == null) return;
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
