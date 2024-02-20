package MainComponents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private BufferedReader reader;

	private int lineNumber = 0;
	private int bigger = 5;

	private File file = new File("test.csv");
	 private List<String> valuesList;
	
	public CSVReader() {
		valuesList = new ArrayList<>();
		reader();
	}
	
	public void reader() {
		try {
			reader = new BufferedReader(new FileReader("test.csv"));

			String line;
			
			valuesList.clear();
			for (int i = 0; i <= bigger; i++) {

				line = reader.readLine();

				if (i >= lineNumber && i < bigger && line != null) {

					String[] words = line.split(";");

					for (String word : words) {
						System.out.print(word + " ");
						valuesList.add(word);
					}
					
					System.out.println();
				}
			}

			reader.close();

			lineNumber += 6;
			bigger += 6;

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String[] getValues() {
		return valuesList.toArray(new String[0]);
	}
	
}