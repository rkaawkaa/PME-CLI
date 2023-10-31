import java.util.Scanner

fun main() {

    /**
     * L'importe de scanner va nous permettre d'intéragir plus facilement avec les saisies de l'utilisateur qui doivent être récupérés sous forme de type Double ou Int.
     * La variable company est l'objet de type Company associé à l'enregistrement de l'entreprise de l'utilisateur.
     * Nous lui affichons ensuite le menu, dont les fonctionnalités seront associées à son entreprise.
     */
    val reader = Scanner(System.`in`)
    val CLI = ConsoleInterface()
    CLI.Welcoming()
    var company = CLI.createCompany(reader)


    CLI.displayMenu(reader, company)


}