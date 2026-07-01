/**
 * @author okkit (github.com/okkit)
 */
package example.data;

import example.data.beans.TaskBean;
import example.data.beans.TaskListBean;

/**
 * Definiert die Snittstelle zwischen dem Userinterface und der Datenschicht.
 * Alle Schnittstellen zwischen GUI und Datenspeicherung MÜSSEN
 * diese Schnittstelle implementieren.<br>
 * Dadurch wird sichergestellt, dass bei einem Austauschen der Persistenz<br>
 * z.B. vom Speichern als JSON durch Speichern in eine MySQL keine<br>
 * Änderungen im GUI-Code vorgenommen werden müssen (außer z.B.<br>
 * von ExampleFormularDataManager mng = ExampleSQLDataManager();<br>
 * zu ExampleFormularDataManager mng = ExampleJSONDataManager().
 */
public interface ExampleFormularDataManager {
	
	public static final String ERR_NO_DATA = "Nichts zum Speichern";
	public static final String ERR_NO_TITLE = "Kann ein Task ohne Titel nicht speichern.";
	public static final String MSG_SUCCESS = "Die Daten wurden erfolgreich gespeichert";
	
	/**
	 * Speichert die Daten, die im Formular (ISP) eingegeben wurden
	 * @param form Daten, gespeichert in einer Instanz der Klasse TaskBean
	 * @return Fehler- oder Erfolgsmeldung
	 */
	public String saveFormular(TaskBean form);
	
	/**
	 * Lädt Information zu allen permanent gespeicherten Tasks und verpakt diese<br>
	 * in einer Instanz der Klasse TaskListBean.
	 * @return
	 */
	public TaskListBean loadTaskInfoList();
	
	/**
	 * Lädt vollständig einen Task anhand seiner id (entspricht dem PK in der MySQL DB)<br>
	 * und verpackt ihn in eine Instanz der Klasse TaskBean
	 * @param id
	 * @return Instanz der Klasse TaskBean 
	 */
	public TaskBean getTaskById(Integer id);
}

