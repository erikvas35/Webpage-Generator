package model;

/**
 * 
 * Represents text that can appear in an HTML document
 * @author UMCP
 *
 */
public class TextElement implements Element {
	private String text;

	//Constructor for the text element
	public TextElement(java.lang.String text) {
		this.text = text;
	}
	
	//Returns HTML for the element
	@Override
	public String genHTML(int indentation) {
		StringBuilder data = new StringBuilder();
		
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		
		return data + text;

	}
	
}
