package model;

/**
 * Represents the anchor tag, <a>.
 * @author UMCP
 *
 */
public class AnchorElement extends TagElement {
	private String linkText;
	private String url;
	
	//Constructor Method
	public AnchorElement(java.lang.String url, java.lang.String linkText, java.lang.String attributes) {
		super("a", true, null, attributes);
		this.linkText = linkText;
		this.url = url;
	}

	// Returns linkText
	public java.lang.String getLinkText(){
		return linkText;
	}
	
	// Returns the URL
	public java.lang.String getUrlText(){
		return url;
	}
	
	// Return the HTML of the element
	@Override
	public java.lang.String genHTML(int indentation){
		StringBuilder data = new StringBuilder();
		
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		
		data.append(getStartTag());
	
		data.append(getEndTag());
		
		return data.toString();
	}

}
