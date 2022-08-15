package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputScore {
	public static Score mapStringToScore(String scoreSplit) { // метод mapStringToScore отделяет поля
		String[] scoreFields = scoreSplit.split(",");
		Score s = new Score();
		s.setPlace(Integer.parseInt(scoreFields[0]));
		s.setPoint(Integer.parseInt(scoreFields[1]));
		return s;
	}

	public static List<Score> mapFileToScoreList(String pathToFile) { // метод mapFileToScoreList читает данние из
																		// файла
		ArrayList<Score> alScore = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Score d = mapStringToScore(line);
				alScore.add(d);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alScore;

	}
}
