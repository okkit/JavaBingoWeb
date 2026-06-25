package data;

import data.beans.ExampleFormularBean;

/**
 * Definiert die Snittstelle zwischen dem Userinterface und der Datenschicht.
 */
public interface ExampleFormularDataManager {
	
	public static final String ERR_NO_DATA = "Nichts zum Speichern";
	public static final String ERR_NO_TITLE = "Kann ein Task ohne Titel nicht speichern.";
	public static final String MSG_SUCCESS = "Die Daten wurden erfolgreich gespeichert";
	
	public String saveFormular(ExampleFormularBean form);

}

