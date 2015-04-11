package parser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		HTMLParser obj = new HTMLParser();
		String test = obj.fetchDocument();
		System.out.println(test);
	}

}
