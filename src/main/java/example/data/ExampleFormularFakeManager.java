package example.data;

import example.data.beans.TaskBean;
import example.data.beans.TaskListBean;
import example.data.fake.FakeDataBase;

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
	public TaskListBean loadTaskList() {
		
		beanList = new TaskListBean();
		beanList.setList(FakeDataBase.selectAllFromTask());
		
		return beanList;
	}

	@Override
	public TaskBean getTaskById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
