package parser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		EsaHTMLParser obj = new EsaHTMLParser();
		obj.parse_html_table();
	}
}
