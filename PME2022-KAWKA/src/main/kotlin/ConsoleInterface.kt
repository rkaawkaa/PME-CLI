import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Scanner
import kotlin.system.exitProcess

class ConsoleInterface {

    fun Welcoming() {
        println("Hello. Welcome to our interactive HR software. :)")
    }

    fun createCompany(reader : Scanner): Company {
        println("The first step is to register your company in our software.")
        println("Name of your company: ")
        val companyName = readLine()!!
        println("Current turnover of your company : (format it this way: 'euros,pennies'. For example, if your company has a turnover of 500euros and 80 pennis, write '500,80'.)")
        val turnOver :Double = reader.nextDouble()
        val company = Company(companyName, turnOver)
        println("Your company has been correctly register.")
        println("${company.toString()}")
        return company
    }




    fun displayMenu(reader: Scanner, company : Company) {
        Thread.sleep(1500)
        println("######################################################")
        println("Here's a list of functionalities. Type the number according to the functionality you want to do :")
        println("1 => Modify the information about your company (company name or turnover).")
        println("2 => Recruit an employee to your company.")
        println("3 => Recruit an executive to your company.")
        println("4 => Display informations about the company's collaborators. (infos, salary, grade...)")
        println("5 => Change the name of an employee or of an executive. ")
        println("6 => Modify the grade of an executive working in your company.")
        println("7 => Increase the salary of an employee or of an executive.")
        println("8 => Dismiss an employee or an executive.")
        println("9 => Register the data in a json file.")
        println("10 => Exit the application.")



        // Récupère le choix de l'utilisateur et lance la bonne fonction. Une fois la fonction terminée, le menu se reaffiche.
        when(readLine()!!) {
            "1" -> {
                changeInformations(reader, company)
                displayMenu(reader, company)
            }
            "2" -> {
                recruitEmployee(reader,company)
                displayMenu(reader, company)
            }
            "3" -> {
                recruitExecutive(reader, company)
                displayMenu(reader, company)
            }
            "4" -> {
                displayInformations(reader, company)
                displayMenu(reader, company)
            }
            "5" -> {
                changeNameEmployee(reader, company)
                displayMenu(reader, company)
            }
            "6" -> {
                modifyGrade(reader, company)
                displayMenu(reader, company)
            }
            "7" -> {
                increaseSalary(reader, company)
                displayMenu(reader, company)
            }
            "8" -> {
                dismissEmployee(reader, company)
                displayMenu(reader, company)
            }
            "9" -> {
                saveData(company)
                displayMenu(reader, company)

            }
            "10" -> {
                exitProcess(0)
            }
            else -> {
                println("Please enter a valid number.")
                displayMenu(reader, company)
            }
        }
     }



    // Permet de changer le nom ou le chiffre d'affaires de l'entreprise en appelant les fonctions modifyName et modifyTurnOver
    fun changeInformations(reader: Scanner, company: Company) {
        println("What do you want to modify ?")
        println("1 => Modify your company name.")
        println("2 => Modify the turnover of your company.")
        when(readLine()!!) {
            "1" -> {
                println("Enter the new name of your company:")
                company.modifyName(readln()!!)
            }
            "2" -> {
                println("Enter the new turnover of your company. (with a ',' between the euros and the \n" +
                        "pennies.)")
                val turnOver :Double = reader.nextDouble()
                company.modifyTurnOver(turnOver)
            }
            else -> {
                println("Please enter a valid value(1 or 2).")
                changeInformations(reader, company)
            }

        }
    }

    fun recruitEmployee(reader: Scanner, company: Company) {
        println("We are going to recruit a new employee.")
        println("What is the first name of the new employee ?")
        val firstName = readLine()!!
        println("What is the last name?")
        val lastName = readLine()!!
        println("What is the employee's year of birth?")
        val birthYear : Int = reader.nextInt()
        val newEmployee = Employee(lastName, firstName, birthYear)
        company.hireEmployee(newEmployee)
        println(newEmployee.toString())

    }

    fun recruitExecutive(reader: Scanner, company: Company) {
        println("We are going to recruit a new employee.")
        println("What is the first name of the new employee ?")
        val firstName = readLine()!!
        println("What is the last name?")
        val lastName = readLine()!!
        println("What is the employee's year of birth?")
        val birthYear : Int = reader.nextInt()
        println("What is the employee's grade ? (A, B or C)")
        val communicatedGrade = readLine()!!
        var grade = Grade.ZERO
        when(communicatedGrade) {
            "A" -> grade = Grade.A
            "B" -> grade = Grade.B
            "C" -> grade = Grade.C
        }
        val newExecutive = Executive(lastName, firstName, birthYear, grade)
        company.hireEmployee(newExecutive)
        println(newExecutive.toString())
    }


    fun displayInformations(reader: Scanner, company: Company) {
        println("Do you want to display informations about :")
        println("1 => Every people that is working for your company (executives and simple employees)")
        println("2 => Only employees")
        println("3 => Only executives")
        println("4 => General Information about the salaries.")
        when(readLine()!!) {
            "1" -> {
                company.displayEveryWorkers()
            }

            "2" -> {
                company.displayEmployees()
            }

            "3" -> {
                company.displayExecutives()
            }

            "4" -> {
                company.displaySalaries()
            }

            else -> {
                println("Please enter a valid value(1,2,3 or 4).")
                displayInformations(reader, company)

            }
        }
    }

    fun changeNameEmployee(reader: Scanner, company: Company) {
        println("We are in the process of changing an employee's name.")
        println("What is the first name of this employee ?")
        val firstName = readLine()!!
        println("What is the last name ?")
        val lastName = readLine()!!
        for (employee in company.setOfEmployees) {
            if (employee.getfirstName() == firstName && employee.getlastName() == lastName) {
                println("Do you want to modify the first name (1) or the last name (2)?")
                when(readLine()!!) {
                    "1" -> {
                        println("New first name : ")
                        val firstname = readLine()!!
                        employee.setfirstName(firstname)
                        println(employee.toString())
                    }
                    "2" -> {
                        println("New Last name : ")
                        val lastname = readLine()!!
                        employee.setlastName(lastname)
                        println(employee.toString())
                    }
                    else -> {
                        println("Invalid value.")
                        changeNameEmployee(reader, company)

                    }
                }
            } else {
                println("Sorry, we haven't found this person.")
            }
        }
    }

    fun modifyGrade(reader: Scanner, company: Company) {
        println("We are currently in the process of modifying the grade of an employee.")
        println("What is the first name of this executive ?")
        val firstName = readLine()!!
        println("What is the last name?")
        val lastName = readLine()!!
        var found = false
        for(employee in company.setOfEmployees) {
            if(employee is Executive && employee.getfirstName() == firstName && employee.getlastName() == lastName) {
                println("Your executive has currently a grade of ${employee.getExeGrade()}")
                println("What new grade do you want to affect to the executive? (A, B or C)")
                val communicatedGrade = readLine()!!
                found = true
                var grade = employee.getExeGrade()
                when(communicatedGrade) {
                    "A" -> grade = Grade.A
                    "B" -> grade = Grade.B
                    "C" -> grade = Grade.C
                }
                employee.changeGrade(grade)
            }
        }
        if(!found) {
            println("We haven't found the employee in your company's list.")
        }

    }

    fun increaseSalary(reader: Scanner, company: Company) {
        println("We are currently in the process of increasing the salary of an employee.")
        println("What is the first name of this employee ?")
        val firstName = readLine()!!
        println("What is the last name ?")
        val lastName = readLine()!!
        println("Enter the new salary:")
        val salary = reader.nextInt()
        var found = false
        for (employee in company.setOfEmployees) {
            if (employee.getfirstName() == firstName && employee.getlastName() == lastName) {
                employee.newSalary(salary)
                found = true
            }
        }
        if(!found) {
            println("We haven't found this employee in your company's list.")
        }
    }

    fun dismissEmployee(reader: Scanner, company: Company) {
        println("Entering the process of dismissing an employee")
        println("What is the first name of this employee ?")
        val firstName = readLine()!!
        println("What is the last name ?")
        val lastName = readLine()!!
        var found = false
        for (employee in company.setOfEmployees) {
            if (employee.getfirstName() == firstName && employee.getlastName() == lastName) {
                company.fireEmployee(employee)
                found = true
            }
        }
        if(!found) {
            println("We haven't found the employee in your company's list.")
        }
    }

    fun saveData(company: Company) {



        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.BASIC_ISO_DATE
        val formattedDate = current.format(formatter)
        var fileName : String = "data-${company.getCompName()}-$formattedDate.json"
        // Creation du file avec le nom de fichier passé en argument
        val file = File(fileName)
        var plainText : String = "";
        // Ajout de la company
        plainText += "{\"Company\":{\"name\":\"${company.getCompName()}\",\"turnOver\":\"${company.getTurnOver()}\"},\"Employee\":["
        // Ajout des employées
        for(employee in company.setOfEmployees) {
            if(employee is Executive) {
                plainText += "{\"lastName\":\"${employee.getlastName()}\",\"firstName\":\"${employee.getfirstName()}\",\"salary\":\"${employee.getEmpSalary()}\",\"grade\":\"${employee.getExeGrade()}\"},"
            } else {
                plainText += "{\"lastName\":\"${employee.getlastName()}\",\"firstName\":\"${employee.getfirstName()}\",\"salary\":\"${employee.getEmpSalary()}\"},"
            }
        }
        // Enleve la dernière virgule avec la fermeture du tableau pour avoir un json valide, ferme le tableau et le json
        plainText = plainText.dropLast(1)
        plainText += "]}"
        println("Voici le contenu de votre fichier: $plainText")

        file.writeText(plainText, Charsets.UTF_8)

        println("The file $fileName with your data has been successfully created in the root directory.")
    }
}