package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

/* Para crear la clase Equipo con todos sus atributos hemos usado una página que se llama quicktype.io,
en la que le hemos dado la estructura JSON de cada equipo que obtenemos de la api y le hemos indicado
que queremos la clase en java, a lo cual nos la ha devuelto hecha para poder copiarla y pegarla. */
public class Equipo {
    private String idStanding;
    private String intRank;
    private String idTeam;
    private String strTeam;
    private String strBadge;
    private String idLeague;
    private String strLeague;
    private String strSeason;
    private String strForm;
    private String strDescription;
    private String intPlayed;
    private String intWin;
    private String intLoss;
    private String intDraw;
    private String intGoalsFor;
    private String intGoalsAgainst;
    private String intGoalDifference;
    private String intPoints;
}