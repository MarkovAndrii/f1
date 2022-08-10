package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputTeam {
	public static Team mapStringToTeam(String teamSplit) { // метод mapStringToTeam отделяет поля
		String[] teamFields = teamSplit.split(",");
		Team t = new Team();
		t.setIdTeam(teamFields[0]);
		t.setTeamName(teamFields[1]);
		t.setSeo(teamFields[2]);
		return t;
	}

	public static List<Team> mapFileToTeamList(String pathToFile) { // метод mapFileToTeamList читает данние из файла
		ArrayList<Team> alTeam = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Team a = mapStringToTeam(line);
				alTeam.add(a);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alTeam;

	}
}