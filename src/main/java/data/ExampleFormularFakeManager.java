package data;

import data.beans.ExampleFormularBean;

/**
 * Implementiert die Schnittstelle zwischen der GUI-Schicht und der Datenzugriffsschicht.<br>
 * 
 * Diese Klasse ist keine reale Schittstelle, sie simuliert nur eine.<br>
 * Sie ist gut zu gebrauchen, wenn man GUI implementiert und Testdaten benötigt.
 * 
 */
public class ExampleFormularFakeManager implements ExampleFormularDataManager {

	@Override
	public String saveFormular(ExampleFormularBean form) {
		
		if (form.getTaskTitle() == null)
			return "Kann ein Task ohne Titel nicht speichern.";
		return null;
	}

}
