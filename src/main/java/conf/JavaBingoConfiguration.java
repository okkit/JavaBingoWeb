package conf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import example.data.ExampleFormularDataManager;

public class JavaBingoConfiguration {

	private static final String INI_FILE = "JavaBingo.ini";

	public static ExampleFormularDataManager getDataManager() {

		try (InputStream in = JavaBingoConfiguration.class.getClassLoader().getResourceAsStream(INI_FILE)) {

            if (in == null) {
                throw new RuntimeException(INI_FILE + " wurde nicht gefunden");
            }

            Properties properties = new Properties();
			properties.load(in);

			// Klassenname auslesen. In der JavaBingo.ini: dataManager=example.data.ExampleFormularFakeManager
			String className = properties.getProperty("dataManager");

			if (className == null || className.isBlank()) {
				throw new IllegalArgumentException("Name der Klasse fehlt in " + INI_FILE);
			}

			// Klasse laden
			Class<?> clazz = Class.forName(className);

			// Instanz erzeugen
			ExampleFormularDataManager instance = (ExampleFormularDataManager) clazz
					.getDeclaredConstructor().newInstance();
			
			return instance;

		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.println("Klasse wurde nicht gefunden: " + e.getMessage());

		} catch (NoSuchMethodException e) {
			System.out.println("Die Klasse hat keinen parameterlosen Konstruktor.");

		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println("Instanz konnte nicht erzeugt werden: " + e.getMessage());
		}
		return null;

	}

}
