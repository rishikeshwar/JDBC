
import java.applet.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.awt.event.*;

public class ScopusCheck {
	
	public static void check(String n) throws IOException, URISyntaxException {
		Desktop desktop=Desktop.getDesktop();
		String s = new String();
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == ' ') {
				s += "+";
			} else
				s += n.charAt(i);
		}
		String link1 = "http://www.bing.com/search?q=" + s
				+ "&go=Submit&qs=bs&form=QBLH";
		String link2 = "https://www.google.co.in/?gfe_rd=cr&ei=CqouWPevKs6L8Qfd_ZjQCw#q="
				+ s;
		String link3 = "https://in.search.yahoo.com/search?p=" + s
				+ "&fr=yfp-t-704";
		desktop.browse(new URI(link1));
	}
}