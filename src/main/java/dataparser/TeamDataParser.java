package dataparser;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class TeamDataParser {
	public static String createWinnerMessageString(com.fasterxml.jackson.databind.JsonNode payload) {

		String winnerTeams = "Los equipos ganadores son: ";
		int bestScore = -1;

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			// read JSON file and convert to a customer object
			Teamdata teams = objectMapper.readValue(payload.toString(), Teamdata.class);
			
			ArrayList<Team> winnerTeamList = new ArrayList<Team>();
			for (Team team : teams.getTeamdata()) {
				if (team.getTotalPuntos() > bestScore) {
					winnerTeamList.clear();
					winnerTeamList.add(team);
					bestScore = team.getTotalPuntos();
				} else if (team.getTotalPuntos() == bestScore){
					winnerTeamList.add(team);
				}
			}
			
			if (winnerTeamList.size()>1) {
				for (Team team : winnerTeamList) {
					winnerTeams = winnerTeams + "%0A - " + team.getName() + " - puntuacion: " + team.getTotalPuntos();
				}
			}else {
				winnerTeams = "El equipo ganador es: " + winnerTeamList.get(0).getName() + " - puntuacion: " + winnerTeamList.get(0).getTotalPuntos();
			}
			
		} catch (IOException e) {
			return e.getMessage();
		}
		return winnerTeams;
	}
}
