package example.data.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simuliert als hätten wir eine Datenbank<br>
 * Bietet Methoden an, die einen Zugriff auf eine relationale DB simulieren.
 */
public class FakeDataBase {

	/**
	 * Simuliert einen Zugriff auf eine relationale DB:<br>
	 * ähnlich wie "select id, title from taskTable;"<br>
	 * Das Ergebnis wir als eine List<Map<Integer, String>> geliefert.<br>
	 * In Map<Integer, String> entspricht das Indeger-Key dem PK<br>
	 * die String-Value dem Titel in der Tabelle TskTable.
	 * 
	 * @return Eine Liste aus Maps - List<Map<Integer, String>>
	 */
	public static List<Map<Integer, String>> selectAllFromTask() {
		List<Map<Integer, String>> fakeResult = new ArrayList<Map<Integer, String>>();

		Map<Integer, String> map;
		for (int i = 1; i < 10; i++) {
			map = new HashMap<Integer, String>(1);
			map.put(i, "Title of the Task with id " + i);

			fakeResult.add(map);
		}

		return fakeResult;
	}

}
