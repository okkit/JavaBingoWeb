package data.beans;

/**
 * Ein Java-Bean ist eine Klasse zum temporären Speichern von Daten. <br>
 * Zum Beispiel zum Speichern der Benutzereingaben von der GUI.<br>
 * 
 * Ein Java-Bean bestäht lediglich aus Feldern. Keine Methoden.<br>
 * 
 * Diese Bohne enthält Felder für die Daten eines Beispielformulars.
 */
public class ExampleFormularBean {
	
	private String taskTitle;
	private String taskInfo;
	private boolean done;
	
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

}
