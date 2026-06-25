package data;

import data.beans.ExampleFormularBean;

/**
 * Definiert die Snittstelle zwischen dem Userinterface und der Datenschicht.
 */
public interface ExampleFormularDataManager {
	
	public String saveFormular(ExampleFormularBean form);

}
