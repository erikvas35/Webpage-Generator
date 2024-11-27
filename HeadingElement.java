package model;

/**
 * Represents a heading tag.
 * We can have levels 1 thru 6 (e.g., <h1>, <h2>, ..., <h6>)
 * @author UMCP
 *
 */
public class HeadingElement extends TagElement {
	private int level;
	
    //Constructor for a heading element
	//Able to work for any header between 1-6
	public HeadingElement(Element content, int level, java.lang.String attributes) {
		super("h" + level, true, content, attributes);
		this.level = level;
	}
	
	
	
}
