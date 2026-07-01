package example.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.data.beans.TaskBean;
import example.data.beans.TaskListBean;

/**
 * Implementiert die Schnittstelle zwischen der GUI-Schicht und der Datenzugriffsschicht.<br>
 * 
 * Diese Klasse ist keine Schittstelle zu einer Datenpersistenz, sie simuliert nur eine.<br>
 * Sie ist gut zu gebrauchen, wenn man GUI implementiert und Testdaten ben�tigt.
 * 
 */
public class ExampleFormularFakeManager implements ExampleFormularDataManager {
	
	TaskListBean beanList;
	
	
	/** 
	 * Der Standardkonstruktor wird unbedingt benötigt (Reflection)
	 */
	public ExampleFormularFakeManager() {
		super();
	}

	/**
	 * Liefert eine Bean-Instanze mit Fake-Daten
	 * @return
	 */
	public static TaskBean getTestData() {
		
		TaskBean bean = new TaskBean();
		
		bean.setTaskTitle("Test-Task");
		bean.setTaskInfo("Das sind Testdaten um zu testen, ob sie angezeigt werden k�nnen");
		bean.setDone(true);
		
		return bean;
	}
	
	@Override
	public String saveFormular(TaskBean form) {
		
		if (form == null)
			return ERR_NO_DATA;
		if (form.getTaskTitle() == null)
			return ERR_NO_TITLE;
		return MSG_SUCCESS;
	}

	@Override
	/**
	 * Simuliert einen Zugriff auf eine relationale DB:<br>
	 * ähnlich wie "select id, title from taskTable;"<br>
	 * Das Ergebnis wir als eine List<Map<Integer, String>> geliefert.<br>
	 * In Map<Integer, String> entspricht das Indeger-Key dem PK<br>
	 * die String-Value dem Titel in der Tabelle TskTable.
	 * 
	 * Die Ergebnisse werden in eine TaskListBean-Instanz verpackt
	 */
	public TaskListBean loadTaskInfoList() {
		List<Map<Integer, String>> fakeResult = new ArrayList<Map<Integer, String>>();

		Map<Integer, String> map;
		for (int i = 1; i < 10; i++) {
			map = new HashMap<Integer, String>(1);
			map.put(i, "Title of the Task with id " + i);

			fakeResult.add(map);
		}
		
		TaskListBean list = new TaskListBean();
		list.setList(fakeResult);

		return list;
	}

	@Override
	public TaskBean getTaskById(Integer id) {

		TaskBean bean = new TaskBean();
		
		bean.setTaskTitle("Test-Task mit id " + id);
		bean.setTaskInfo("Eine Simulation eines aus der DB geladenen Tasks");
		bean.setDone(true);
		bean.setId(id);
		
		return bean;
	}
}
