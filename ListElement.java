package model;

import java.util.ArrayList;

/**
 * Represents the ordered and unordered list tags, <ol> and <ul> respectively.
 * An ArrayList is used to keep track of the Element objects of the list.
 * List elements for both ordered and unordered lists use the <li> tag.
 * @author UMCP
 *
 */
public class ListElement extends TagElement {
	private ArrayList<Element> items;
	
	//Constructor that establishes new items array list
	public ListElement(boolean ordered, java.lang.String attributes) {
		super(ordered == true ? "ol" : "ul", true, null, attributes);
		items = new ArrayList<>();
	}
	
	//Adds element item to array list 
	public void addItem(Element item) {
		items.add(item);
	}
	
	// Return the HTML of the element
	@Override
	public java.lang.String genHTML(int indentation){
		StringBuilder data = new StringBuilder();
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append(getStartTag()).append(">");
		for(Element item : items) {
			data.append("\n");
			for(int i = 0; i < indentation+3; i++) {
				data.append(" ");
			}
			data.append("<li>").append("\n");
			data.append(item.genHTML(indentation+6)).append("\n");
			for(int i = 0; i < indentation+3; i++) {
				data.append(" ");
			}
			data.append("</li>");
		}
		data.append("\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append(getEndTag());
		return data.toString();
	}
	
}
