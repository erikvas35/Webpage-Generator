package model;

import java.util.ArrayList;

/**
 * 
 * Represents a paragraph tag, <p>.
 * This class relies on an ArrayList track of the Element objects
 * that are part of the paragraph.
 * @author UMCP
 *
 */
public class ParagraphElement extends TagElement {
	private ArrayList<Element> items;
	
	//Constructor for paragraph elements, starts new array list for items
	public ParagraphElement (java.lang.String attributes) {
		super("p", true, null, attributes);
		items = new ArrayList<>();
	}
	
	//Adds element item to the array list
	public void addItem(Element item) {
		items.add(item);
	}
	
	//Return the HTML of the element
	@Override
	public java.lang.String genHTML(int indentation){
		StringBuilder data = new StringBuilder();
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append(getStartTag()).append(">");
		for(Element item : items) {
			data.append("\n");
			data.append(item.genHTML(indentation+3));
		}
		data.append("\n");
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append(getEndTag());
		
		return data.toString();
	}
	
}
