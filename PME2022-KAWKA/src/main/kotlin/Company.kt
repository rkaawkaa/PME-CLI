import kotlin.math.abs
import kotlin.math.roundToInt

class Company(private var companyName: String, private var turnOver: Double) {

    var setOfEmployees: MutableSet<Employee> = mutableSetOf()

    override fun toString(): String {
        return "The company $companyName has a turnover of $turnOver euros. "
    }



    fun modifyName(newCompanyName: String) {
        val oldCompanyName = this.companyName
        this.companyName = newCompanyName
        println("The company $oldCompanyName has changed its name. It is now named as ${this.companyName}.")
    }
    /**
    *Modifie le chiffre d'affaires et indique les bénéfices ou les pertes depuis la dernière saisie du CA.
    */
    fun modifyTurnOver(newTurnOver: Double) {
        val oldTurnOver = this.turnOver
        this.turnOver = newTurnOver
        println("The company $companyName who had a turnover of $oldTurnOver euros has now a turnover of ${this.turnOver} euros.")
        var difference = (this.turnOver - oldTurnOver).roundToInt()
        if(difference > 0) {
            println("The company has won $difference euros.")
        } else {
            difference = abs(difference)
            println("The company has lost $difference euros.")
        }
    }
    /**
    *Affiche les cadres de l'entreprise
    */
    fun displayExecutives() {

        println("Here's the list of all executive of ${this.companyName}:")
        var i = 1
        for(employee in setOfEmployees) {

            if (employee is Executive) {

                println("Executive $i : ${employee.getfirstName()} ${employee.getlastName()}")
                i++
            }
        }
    }

    /**
     *Affiche les employés de l'entreprise
     */
    fun displayEmployees() {
        if(setOfEmployees.size == 0) {
            println("You currently have not employees at all at ${this.companyName}.")
        } else {
            println("Here's the list of all employees (and not executive) of ${this.companyName}:")
            var j = 1
            for(employee in setOfEmployees) {

                if (employee !is Executive) {

                    println("Employee $j : ${employee.getfirstName()} ${employee.getlastName()}")
                    j++
                }
            }
        }

    }

    /**
     *Affiche les cadres et les employés de l'entreprise.
     */
    fun displayEveryWorkers() {
        this.displayExecutives()
        this.displayEmployees()
    }

    /**
     *Affiche les salaires de chaque entreprise, la moyenne de salaire des entreprises et le total de la masse salariale.
     */
    fun displaySalaries() {
        var totalSalary = 0
        val numberOfEmployee = setOfEmployees.size

        for(employees in setOfEmployees) {
            println("${employees.getfirstName()} ${employees.getlastName()} has a salary of ${employees.getEmpSalary()}")
            totalSalary += employees.getEmpSalary()
        }
        val averageSalary = totalSalary/numberOfEmployee
        println("The total payroll (salaries) per month is: $totalSalary euros.")
        println("The average salary in the company is $averageSalary euros.")
    }

    /**
     *ajoute l'employé à la liste des collaborateurs de l'entreprise après avoir vérifier que l'employé est en age de travailler et que celui-ci n'est pas déjà dans l'entreprise, puis l'ajoute.
     */
    fun hireEmployee(employee: Employee) {
        if(employee.isRecruitable) {
            if (setOfEmployees.contains(employee)) {
                println("The employee ${employee.getfirstName()} ${employee.getlastName()} is already in the employee list.")
            } else {
                setOfEmployees.add(employee)
                employee.setEmployerName(this.companyName)
                println("${employee.getlastName()} ${employee.getfirstName()} is now working at ${this.companyName} and has been added to the employee list.")
            }
        } else {
            println("The employee ${employee.getfirstName()} ${employee.getlastName()} is only ${employee.age} years old so he/she is not recruitable.")
        }
    }

    /**
     *Retire l'employé de la liste des employés après avoir vérifié que celui-ci était bien dans la liste.
     */
    fun fireEmployee(employee: Employee) {
        if(setOfEmployees.contains(employee)) {
            setOfEmployees.remove(employee)
            println("${employee.getlastName()} ${employee.getfirstName()} is not working at ${this.companyName} anymore. He/She has been brutally fired.")
        } else {
            println("${employee.getlastName()} ${employee.getfirstName()} is not working at ${this.companyName}, so you can't dismiss him/her.")
        }

    }

    // Pour les Tests
    fun getCompName(): String {
        return this.companyName
    }
    fun getTurnOver(): Double {
        return this.turnOver
    }


}