package pl.cenowki;

import java.awt.Font;
import java.io.InputStream;

public class EANFonts {

	public static Font getFont() {
		Font font = null;

		String fName = "/fonts/eanbwrp36tt.ttf";
		try {
			InputStream is = EANFonts.class.getResourceAsStream(fName);
			font = Font.createFont(Font.TRUETYPE_FONT, is);
			//is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return font;
	}
}