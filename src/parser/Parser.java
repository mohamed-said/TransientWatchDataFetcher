package parser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.select.Elements;

public interface Parser {
	public Elements fetch_html_table(String url, int id) throws IOException;
	public void parse_html_table() throws IOException;
	public ArrayList<Transient> getData();
}
