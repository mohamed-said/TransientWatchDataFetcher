package parser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {
	private String url = "http://integral.esac.esa.int/bexrbmonitor/webpage_oneplot.php";
	ArrayList<Transient> TABLE_DATA = new ArrayList<Transient>();
	
	public String fetchDocument() throws IOException {
		Document doc = Jsoup.connect(url).get();
		String page_title = doc.title();
		Element data_table = doc.select("table").get(0);
		/**
		 * Table:
		 * Name - Right Ascension - Declination - Orbital Period - MAXI - SWIFT - FERMI - PLOT 
		 * 
		 */
		
		// X per (HD24534 Herbig Ae/Be Star)
		Elements table_header = data_table.select("th");
		for (int i = 0; i < table_header.size(); i++) {
			System.out.print(table_header.get(i).text() + " | ");
		}
		System.out.println("\n---------------------------");
		Elements all_rows = data_table.select("tr");
		
		
		for (int row = 1; row < all_rows.size(); row++) {
			
			Element tuple = all_rows.get(row);
			Elements attributes = tuple.select("td");
			String link = attributes.get(0).childNode(0).attr("href");
			System.out.println("internal link = " + link);
			/**
			 * Object for every row representing a transient
			 */
			Transient obj = new Transient();
			
			/**
			 * Transient attributes
			 */
			obj.setName(attributes.get(0).text());
			obj.setRight_ascention(attributes.get(1).text());
			obj.setDeclination(attributes.get(2).text());
			obj.setOrbital_period(attributes.get(3).text());
			
			obj.setMAXI_prob_change(attributes.get(4).text());
			obj.setMAXI_average_flux(attributes.get(5).text());
			obj.setMAXI_data(attributes.get(6).text());
			
			obj.setSWIFT_BAT_prob_change(attributes.get(7).text());
			obj.setSWIFT_BAT_average_flux(attributes.get(8).text());
			obj.setSWIFT_BAT_data(attributes.get(9).text());
			
			obj.setFERMI_GBM_prob_change(attributes.get(10).text());
			obj.setFERMI_GBM_average_flux(attributes.get(11).text());
			obj.setFERMI_GBM_data(attributes.get(12).text());
			
			TABLE_DATA.add(obj);
		}
		
		return page_title;
	}
	
}
