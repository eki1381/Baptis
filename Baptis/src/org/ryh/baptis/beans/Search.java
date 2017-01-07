package org.ryh.baptis.beans;

import javafx.beans.property.SimpleStringProperty;

public class Search {

	private final SimpleStringProperty searchFieldProperty = new SimpleStringProperty();

	public SimpleStringProperty searchFieldProperty() {
		return searchFieldProperty;
	}
	
	public void setSearchFieldProperty(String searchFieldProperty) {
		this.searchFieldProperty.set(searchFieldProperty);
	}
	
	public String getSearchFieldProperty() {
		return searchFieldProperty.get();
	}
	
}
