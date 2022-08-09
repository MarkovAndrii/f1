package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputSeason {
	public static Season mapStringToSeason(String seasonSplit) { // метод mapStringToSeason отделяет поля
		String[] seasonFields = seasonSplit.split(",");
		Season s = new Season();
		s.setIdSeason(seasonFields[0]);
		s.setYearSeason(Integer.parseInt(seasonFields[1]));
		return s;
	}

	public static List<Season> mapFileToSeasonList(String pathToFile) { // метод mapFileToSeasonList читает данние из
																		// файла
		ArrayList<Season> alSeason = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Season c = mapStringToSeason(line);
				alSeason.add(c);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alSeason;

	}
}