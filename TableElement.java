package model;

/**
 * Represents the <table> tag.
 * A two dimensional array is used to keep track of the Element objects of table.
 * @author UMCP
 *
 */
public class TableElement extends TagElement {
	private Element[][] items;
	
	//Constructor for the Table element, starts new items array list
	public TableElement(int rows, int cols, java.lang.String attributes) {
		super("table", true, null, attributes);
		items = new Element [rows][cols];
	}
	
	//Adds element item to the 2D array
	public void addItem(int rowIndex, int colIndex, Element item) {
		items[rowIndex][colIndex] = item;
	}
	
	//Adds up all used spaces in 2D Array and divides by total spaces
	public double getTableUtilization() {
		int totalSize = 0;
		int used = 0;
		
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items[i].length; j++) {
				totalSize++;
				if(items[i][j] != null) {
					used++;
				}
			}
		}
		if(totalSize == 0) {
			return 0.0;
		}
		
		return (double) used/totalSize*100;
	}
	
	//Returns HTML of the element
	public java.lang.String genHTML (int indentation){
		StringBuilder data = new StringBuilder();
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		
		data.append(getStartTag()).append(">").append("\n");
		
		for(int i = 0; i < items.length; i++) {
			for(int k = 0; k < indentation+3; k++) {
				data.append(" ");
			}
			data.append("<tr>");
			for(int j = 0; j < items[i].length; j++) {
				data.append("<td>");
				if(items[i][j] != null) {
					data.append(items[i][j].genHTML(0));
				}
				data.append("</td>");
			}
			data.append("</tr>");
			data.append("\n");
		}
		for(int i = 0; i < indentation; i++) {
			data.append(" ");
		}
		data.append(getEndTag());
		return data.toString();
	}
}
