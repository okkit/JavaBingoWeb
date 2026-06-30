package conf;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import example.data.ExampleFormularDataManager;

public class Initialisation {

	
	public static ExampleFormularDataManager getDataManager() {

		String className = getClassName();
		if (className == null)
			return null;
		Class<?> mngClass;
		try {
			mngClass = Class.forName(className);
			ExampleFormularDataManager manager = (ExampleFormularDataManager) mngClass.getConstructor().newInstance();
			return manager;

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String getClassName() {
		String name = null;
		try {
			File myObj = new File("data.ini");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				name = myReader.nextLine();
				if (name.indexOf("//") < 0)
					break;
			}
			myReader.close();
			return name;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
