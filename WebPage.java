package model;

import java.util.*;

/**
 * Represents a web page.  Web page elements are
 * stored in an ArrayList of Element objects.  A title
 * is associated with every page.  This class implements
 * the Comparable interface.  Pages will be compared
 * based on the title. The HTML for an empty WebPage
 * (one with no Elements) should be inferred from the 
 * WebPage public tests.
 * @author UMCP
 *
 */
public class WebPage implements Comparable<WebPage> {
	private ArrayList<Element> elements;
	private String title;
	private static List<WebPage> allWebPages = new ArrayList<>();

	//Constructor for a webpage and adds to a static list of websites
	public WebPage(java.lang.String title) {
		this.title = title;
		elements = new ArrayList<>();
		allWebPages.add(this);
	}
	
	//Adds element to the elements array list
	public int addElement(Element element) {
		if(element instanceof TagElement == false) {
			elements.add(element);
			return -1;
		}else {
			elements.add(element);
			return ((TagElement)element).getID();
		}
	}
	
	//Generate HTML for the entire webpage and all elements
	public java.lang.String getWebPageHTML(int indentation){
		StringBuilder data = new StringBuilder();
		data.append("<!doctype html>\n<html>\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append("<head>\n");
		for(int i = 0; i < indentation+3; i++) {
			data.append(" ");
		}
		data.append("<meta charset=\"utf-8\"/>\n");
		for(int i = 0; i < indentation+3; i++) {
			data.append(" ");
		}
		data.append("<title>" + title + "</title>");
		
		data.append("\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append("</head>\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append("<body>");
		for(Element element : elements) {
			data.append("\n");
			data.append(element.genHTML(indentation+1));
		}
		data.append("\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append("</body>\n</html>");
		return data.toString();
	}
	
	//Uses the Utilities writeToFile method
	public void writeToFile(java.lang.String filename, int indentation) {
		Utilities.writeToFile(filename, this.getWebPageHTML(indentation));
	}
	
	//Searches through element array list and searces for ID
	public Element findElem(int id) {
		for(Element element : elements) {	
			if(((TagElement)element).getID() == id) {
				return element;
			}
		}
		return null;
	}
	
	//Goes through array list and keeps track of all types of element
	//Adds up all table utilizations and divides by total tableCount
	public java.lang.String stats(){
		StringBuilder data = new StringBuilder();
		int listCount = 0;
		int paraCount = 0;
		int tableCount = 0;
		double tableUti = 0.0;
		
		for(Element element : elements) {
			if(element instanceof ListElement) {
				listCount++;
			}
			if(element instanceof ParagraphElement) {
				paraCount++;
			}
			if(element instanceof TableElement) {
				tableCount++;
				tableUti += ((TableElement)element).getTableUtilization();
			}
		}
		tableUti = tableUti/tableCount;
		
		data.append("List Count: " + listCount);
		data.append("\nParagraph Count: " + paraCount);
		data.append("\nTable Count: " + tableCount);
		data.append("\nTableElement Utilization: " + tableUti);
		
		return data.toString();
	}
	
	//Compares two webpages
	public int compareTo(WebPage webPage) {
		return this.compareTo(webPage);
	}
	
	//Searches through all websites and elements and enables TagElement IDs
	public static void enableID(boolean choice) {
		for(WebPage webPage : allWebPages) {
			for(Element element : webPage.elements) {
				if(element instanceof TagElement) {
					((TagElement) element).enableId(choice);
				}
			}
		}
	}
	
	
	
}
