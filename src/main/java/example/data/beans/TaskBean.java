package example.data.beans;

import java.io.Serializable;

/**
 * Eine Java-Bean ist eine Klasse zum tempor�ren Speichern von Daten. <br>
 * Zum Beispiel zum Speichern der Benutzereingaben von der GUI.<br>
 * 
 * Ein Java-Bean best�ht lediglich aus Feldern. Keine Methoden.<br>
 * 
 * Diese Bohne enth�lt Felder f�r die Daten eines Beispielformulars.
 */
public class TaskBean implements Serializable {

	public static final long serialVersionUID = 1L;

	private Integer id;
	private String taskTitle;
	private String taskInfo;
	private boolean done;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String toString() {
		return "Task 		" + taskTitle + "\n" + taskInfo + "\nErledigt?		" + done;
	}

}
