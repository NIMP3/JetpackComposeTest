package dev.yovany.jcudemy

import androidx.compose.ui.graphics.Color

data class League(
    val name: String,
    val color: Color,
    val teams: List<Team>
) {
    companion object {
        fun createLeagues(): List<League> {
            return listOf(
                League(
                    name = "Premier League",
                    color = Color(0xFF00A0E4),
                    teams = listOf(
                        Team("Arsenal", listOf(Color(0xFFEF0107), Color(0xFF023474)), "Champions League"),
                        Team("Aston Villa", listOf(Color(0xFF95BFE5), Color(0xFF670E36)), "Champions League"),
                        Team("Brentford", listOf(Color(0xFFFFDB00), Color(0xFF000000)), "Decline"),
                        Team("Brighton & Hove Albion", listOf(Color(0xFF0057B8), Color(0xFF000000))),
                        Team("Burnley", listOf(Color(0xFF6C1D45), Color(0xFF99D6EA)), "Decline"),
                        Team("Chelsea", listOf(Color(0xFF034694), Color(0xFFDBA111))),
                        Team("Crystal Palace", listOf(Color(0xFF1B458F), Color(0xFFD3D3D3))),
                        Team("Everton", listOf(Color(0xFF003399), Color(0xFFFFFFFF)), "Decline"),
                        Team("Leeds United", listOf(Color(0xFFFFCD00), Color(0xFF1D428A))),
                        Team("Leicester City", listOf(Color(0xFF003090), Color(0xFFFDBE11))),
                        Team("Liverpool", listOf(Color(0xFFC8102E), Color(0xFF00A398)), "Champions League"),
                        Team("Manchester City", listOf(Color(0xFF6CABDD), Color(0xFF97C1E3)), "Champions League"),
                        Team("Manchester United", listOf(Color(0xFFDA291C), Color(0xFFFFE500)), "Europa League"),
                        Team("Newcastle United", listOf(Color(0xFF241F20), Color(0xFFA2AAAD))),
                        Team("Norwich City", listOf(Color(0xFFFFF200), Color(0xFF00A650))),
                        Team("Southampton", listOf(Color(0xFFD71920), Color(0xFF132257))),
                        Team("Tottenham Hotspur", listOf(Color(0xFF132257), Color(0xFFFFFFFF)), "Europa League"),
                        Team("Watford", listOf(Color(0xFFFBEE23), Color(0xFF000000))),
                        Team("West Ham United", listOf(Color(0xFF7A263A), Color(0xFF6DA544))),
                        Team("Wolverhampton Wanderers", listOf(Color(0xFFFDB913), Color(0xFF231F20)))
                    )
                ),
                League(
                    name = "La Liga",
                    color = Color(0xFFF1B708),
                    teams = listOf(
                        Team("Athletic Bilbao", listOf(Color(0xFFEE2523), Color(0xFF000000)), "Europa League"),
                        Team("Cádiz", listOf(Color(0xFFFFFF00), Color(0xFF075AB6)), "Decline"),
                        Team("Alavés", listOf(Color(0xFFD00027), Color(0xFF00529F))),
                        Team("Barcelona", listOf(Color(0xFFA50044), Color(0xFF004D98)), "Champions League"),
                        Team("Celta Vigo", listOf(Color(0xFF3A75C4), Color(0xFFFF0000))),
                        Team("Elche", listOf(Color(0xFFFFD700), Color(0xFF0070D1))),
                        Team("Espanyol", listOf(Color(0xFF0000FF), Color(0xFFFF0000))),
                        Team("Getafe", listOf(Color(0xFF0000FF), Color(0xFFFF0000))),
                        Team("Granada", listOf(Color(0xFFCF0234), Color(0xFF000000)), "Decline"),
                        Team("Levante", listOf(Color(0xFFB4053F), Color(0xFF005CA5))),
                        Team("Mallorca", listOf(Color(0xFFE30021), Color(0xFF000000))),
                        Team("Osasuna", listOf(Color(0xFFCD1229), Color(0xFF0053A4))),
                        Team("Rayo Vallecano", listOf(Color(0xFFFEDF00), Color(0xFF000000))),
                        Team("Real Betis", listOf(Color(0xFF00A650), Color(0xFF000000)), "Europa League"),
                        Team("Real Madrid", listOf(Color(0xFFFCBF00), Color(0xFF004996)), "Champions League"),
                        Team("Real Sociedad", listOf(Color(0xFF00529F), Color(0xFFFF0000))),
                        Team("Sevilla", listOf(Color(0xFFDB0007), Color(0xFF000000))),
                        Team("Valencia", listOf(Color(0xFFF00000), Color(0xFF000000))),
                        Team("Villarreal", listOf(Color(0xFFFFD800), Color(0xFF00529F))),
                        Team("Girona", listOf(Color(0xFFD00027), Color(0xFF00529F)), "Champions League"),
                        Team("Atletico Madrid", listOf(Color(0xFFCB3524), Color(0xFF1E1E1E)), "Champions League")
                    )
                ),
                League(
                    name = "Serie A",
                    color = Color(0xFF008CBA),
                    teams = listOf(
                        Team("Atalanta", listOf(Color(0xFF000000), Color(0xFF00A7E7))),
                        Team("Bologna", listOf(Color(0xFF0E3E7A), Color(0xFFFFFFFF)), "Champions League"),
                        Team("Cagliari", listOf(Color(0xFF000000), Color(0xFF00A94F)), "Decline"),
                        Team("Empoli", listOf(Color(0xFF000000), Color(0xFF00A94F))),
                        Team("Fiorentina", listOf(Color(0xFF4B90CC), Color(0xFFFFFFFF))),
                        Team("Genoa", listOf(Color(0xFF161D4A), Color(0xFFFFFFFF))),
                        Team("Hellas Verona", listOf(Color(0xFF1B1919), Color(0xFFFFFFFF))),
                        Team("Inter Milan", listOf(Color(0xFF0267AB), Color(0xFF000000)), "Champions League"),
                        Team("Juventus", listOf(Color(0xFF000000), Color(0xFFFFFFFF)), "Champions League"),
                        Team("Lazio", listOf(Color(0xFF000000), Color(0xFF78CDD1))),
                        Team("AC Milan", listOf(Color(0xFFFB090B), Color(0xFF000000)), "Champions League"),
                        Team("Napoli", listOf(Color(0xFF003e81), Color(0xFF199fd6))),
                        Team("Roma", listOf(Color(0xFF970A2C), Color(0xFFFBBA00)), "Europa League"),
                        Team("Salernitana", listOf(Color(0xFF000000), Color(0xFF00A94F)), "Decline"),
                        Team("Sampdoria", listOf(Color(0xFF0079BB), Color(0xFFDC351B))),
                        Team("Sassuolo", listOf(Color(0xFF000000), Color(0xFF00A94F)), "Decline"),
                        Team("Spezia", listOf(Color(0xFF000000), Color(0xFF00A94F))),
                        Team("Torino", listOf(Color(0xFF7A041A), Color(0xFF000000))),
                        Team("Udinese", listOf(Color(0xFF8B7D37), Color(0xFF000000))),
                        Team("Venezia", listOf(Color(0xFF000000), Color(0xFF00A94F)))
                    )
                ),
                League(
                    name = "Bundesliga",
                    color = Color(0xFFD50032),
                    teams = listOf(
                        Team("Bayern Leverkusen", listOf(Color(0xFFE32221), Color(0xFFF3E500)), "Champions League"),
                        Team("Bayern Munich", listOf(Color(0xFFDC052D), Color(0xFF0066B2)), "Champions League"),
                        Team("Bochum", listOf(Color(0xFF0B234D), Color(0xFFE31837)), "Decline"),
                        Team("Borussia Dortmund", listOf(Color(0xFF000000), Color(0xFFFDE100)), "Champions League"),
                        Team("Mönchengladbach", listOf(Color(0xFFFFFFFF), Color(0xFF000000))),
                        Team("Eintracht Frankfurt", listOf(Color(0xFF000000), Color(0xFFE31837)), "Europa League"),
                        Team("FC Augsburg", listOf(Color(0xFF00529F), Color(0xFFFFFFFF))),
                        Team("FC Köln", listOf(Color(0xFFE3000F), Color(0xFFFFFFFF))),
                        Team("Freiburg", listOf(Color(0xFF000000), Color(0xFFE31837))),
                        Team("Greuther Fürth", listOf(Color(0xFF006600), Color(0xFF000000))),
                        Team("Hertha BSC", listOf(Color(0xFF000000), Color(0xFFEBEBEB))),
                        Team("Hoffenheim", listOf(Color(0xFF0A2141), Color(0xFFEBEBEB))),
                        Team("Mainz 05", listOf(Color(0xFFE31837), Color(0xFF000000)), "Decline"),
                        Team("RB Leipzig", listOf(Color(0xFF0C2340), Color(0xFFD50032)), "Europa League"),
                        Team("Stuttgart", listOf(Color(0xFFD50032), Color(0xFF000000)), "Champions League"),
                        Team("Union Berlin", listOf(Color(0xFFDD0000), Color(0xFF000000))),
                        Team("VfL Wolfsburg", listOf(Color(0xFF0B2349), Color(0xFF00A650))),
                        Team("Arminia Bielefeld", listOf(Color(0xFF000000), Color(0xFFD50032))),
                        Team("Bochum", listOf(Color(0xFF0B234D), Color(0xFFE31837)))
                    )
                ),
                League(
                    name = "Ligue 1",
                    color = Color(0xFFD50032),
                    teams = listOf(
                        Team("Monaco", listOf(Color(0xFFE51B22), Color(0xFFCB9F18)), "Champions League"),
                        Team("Paris Saint-Germain", listOf(Color(0xFF004170), Color(0xFFe30613)), "Champions League"),
                        Team("Lille", listOf(Color(0xFFD6062A), Color(0xFF000000)), "Champions League"),
                        Team("Lyon", listOf(Color(0xFF0B4A8B), Color(0xFFE30613))),
                        Team("Marseille", listOf(Color(0xFF003399), Color(0xFFE30613)), "Europa League"),
                        Team("Nice", listOf(Color(0xFFE41F35), Color(0xFF000000)), "Europa League"),
                        Team("Rennes", listOf(Color(0xFFE41F35), Color(0xFF000000))),
                        Team("Saint-Étienne", listOf(Color(0xFF00A650), Color(0xFF000000))),
                        Team("Strasbourg", listOf(Color(0xFF000000), Color(0xFFE30613))),
                        Team("Troyes", listOf(Color(0xFFE30613), Color(0xFF000000))),
                        Team("Brest", listOf(Color(0xFFE30613), Color(0xFF000000))),
                        Team("Angers", listOf(Color(0xFF000000), Color(0xFFD9C395))),
                        Team("Metz", listOf(Color(0xFF6E0F12), Color(0xFFFFFFFF)), "Decline"),
                        Team("Montpellier", listOf(Color(0xFF344575), Color(0xFFd87043))),
                        Team("Nantes", listOf(Color(0xFFFFD700), Color(0xFF006233))),
                        Team("Reims", listOf(Color(0xFFEE2223), Color(0xFFFFFFFF))),
                        Team("Clermont", listOf(Color(0xFFE30613), Color(0xFF000000)), "Decline"),
                        Team("Lorient", listOf(Color(0xFFE30613), Color(0xFF000000)), "Decline"),
                        Team("Toulouse", listOf(Color(0xFF3E2C56), Color(0xFFE60746)))
                    )
                )
            )
        }
    }
}

data class Team(
    val name: String,
    val colors: List<Color>,
    val status: String = "Clasificatory"
)

