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
	
	public static ExampleFormularBean getTestData() {
		
		ExampleFormularBean bean = new ExampleFormularBean();
		
		bean.setTaskTitle("Test-Task");
		bean.setTaskInfo("Das sind Testdaten um zu testen, ob sie angezeigt werden können");
		bean.setDone(true);
		
		return bean;
	}
	
	

	@Override
	public String saveFormular(ExampleFormularBean form) {
		
		if (form.getTaskTitle() == null)
			return "Kann ein Task ohne Titel nicht speichern.";
		return null;
	}


}
