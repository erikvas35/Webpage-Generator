package model;

/**
 * Represents an image tag, <img>.  
 * For this project you can assume we will not update any of the 
 * attributes associated with this tag.
 * @author UMCP
 *
 */
public class ImageElement extends TagElement {
	private String imageURL;
	private int width;
	private int height;
	private String alt;
	
	//Constructor for image elements, adds image details into the attributes
	public ImageElement(java.lang.String imageURL, int width, int height, 
			java.lang.String alt, java.lang.String attributes) {
		super ("img", false, null, "src=\"" + imageURL + "\" width=\"" + width + "\" height=\""
				+ height + "\" alt=\"" + alt + "\"");
		
		this.imageURL = imageURL;
		this.width = width;
		this.height = height;
		this.alt = alt;
	}
	
	//Returns the image URL
	public java.lang.String getImageURL() {
		return imageURL;
	}

}
