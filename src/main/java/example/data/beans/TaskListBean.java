package example.data.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hält eine Liste der geladenen Tasks<br>
 * Die Liste selbst besteht aus Map-Instanzen.
 */
public class TaskListBean {

//	In Map<Integer, String> entspricht das Indeger-Key dem PK<br>
//	   Map<   Key,   Value> <br>
//	die String-Value dem Titel in der Tabelle TskTable.
	
	List<Map<Integer, String>> list;

	/**
	 * Liefert die Liste aller Tasks. <br>
	 * Gibt es keinen "gespeicherten" Task, wird ein (Pseudo)task erzeugt und als
	 * eine Liste bestehend aus einem einzigen Task geliefert.
	 * 
	 * @return
	 */
	public List<Map<Integer, String>> getList() {

		if (list == null) {
			list = new ArrayList<Map<Integer, String>>(1);

			Map<Integer, String> map = new HashMap<Integer, String>(1);
			map.put(-1, "Noch keine Einträge");

			list.add(map);
		}
		return list;
	}

	public void setList(List<Map<Integer, String>> list) {
		this.list = list;
	}
}


