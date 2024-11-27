package model;

/**
 * 
 * Represents an HTML tag element (<p>, <ul>, etc.).
 * Each tag has an integer id (ids start at 1).  By default the start tag
 * of a TagElement will have an id attribute consisting of its tagName and its 
 * integer id. The id attribute is only included in the TagElement's start tag 
 * if enableId is set to true. For example, a ParagraphElement with integer id
 * 1 would have the start tag <p id="p1"> and end tag still </p> when the HTML
 * for the tag is generated. 
 * @author UMCP
 *
 */
public class TagElement implements Element {
	static int ID = 1;
	private String tagName;
	private Boolean endTag;
	private Element content;
	private String attributes;
	private int uniqueID;
	
	static boolean endID;
	
	//Constructor for TagElements
	public TagElement(java.lang.String tagName, boolean endTag, Element content, java.lang.String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		uniqueID = ID++;
	}
	
	//Returns the unique ID for each tag element
	public int getID() {
		return uniqueID;
	}
	
	//Returns the unique ID plus the tag name
	public java.lang.String getStringID() {
		return tagName + this.getID();
	}
	
	//Returns the starting tag for the tag element along with any attributes
	public java.lang.String getStartTag() {
		StringBuilder startTag = new StringBuilder("<" + tagName);
	    
	    if (endID == true) {
	        startTag.append(" id=\"").append(getStringID()).append("\"");
	    }
	    
	    if(this instanceof AnchorElement) {
	    	AnchorElement anchor = (AnchorElement) this;
	    	startTag.append(" href=\"" + anchor.getUrlText() + "\"");
	    }
	    
	    if (attributes != null && !attributes.isEmpty()) {
	        startTag.append(" ").append(attributes);
	    } 
	    
	    if(this instanceof AnchorElement) {
	    	AnchorElement anchor = (AnchorElement) this;
	    	startTag.append(">");
	    	startTag.append(anchor.getLinkText());
	    }
	    
	    
	    return startTag.toString();	
	}
	
	//Returns the end tag if the condition is true
	public java.lang.String getEndTag() {
		if(endTag == true) {
			return "</" + tagName + ">";
		} else {
			return "";
		}
		
	}
	
	//Sets the attributes of the tag element
	public void setAttributes​(java.lang.String attributes) {
		this.attributes = attributes;
	}
	
	//Resets the static value for unique IDs
	public static void resetIds() {
		ID = 1;
	}
	
	//Allows unique IDs in the start tag method
	public static void enableId(boolean choice) {
		endID = choice;
		
	}
	
	//Provides HTML for a tag element
	@Override
	public String genHTML(int indentation) {
		StringBuilder data = new StringBuilder();
		
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		
	    data.append(getStartTag()).append(">");
	    if (content != null) {
	        data.append(content.genHTML(0));
	    }
		 
	    data.append(getEndTag());
	
		return data.toString();
	}


	
}