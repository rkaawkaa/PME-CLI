import java.time.LocalDateTime

open class Employee(lastName: String, firstName:String, yearsBirth: Int):Person(lastName, firstName, yearsBirth) {
    protected var employer: String ="no company"

    fun setEmployerName(employer: String) {
        this.employer = employer
    }

    fun getEmpSalary() : Int{
        return this.salary
    }
    override fun toString(): String {
        return super.toString() + " and is working at $employer, has a base salary of $salary euros since he/she is $age years old"
    }

    protected var salary: Int = 0
    var isRecruitable = false
    val age : Int = (LocalDateTime.now().year - yearsBirth)

    /**
     * Vérifie que l'employé est en age de travailler et que le nouveau salaire est supérieur à l'ancien.
     */
    fun newSalary(salary: Int) {
        if(isRecruitable) {
            val oldSalary = this.salary
            if(oldSalary > salary) {
                println("You can only increase the salary. You can't lower it.")
            } else {
                val difference = salary - oldSalary
                this.salary = salary
                println("$firstName $lastName has now a salary of $salary euros. It has been increased of $difference euros.")
            }
        } else {
            println("$firstName $lastName is too young and can't work, so you can't increase his/her salary.")
        }

    }

    init {
        employabilityInfos()
    }

    open fun employabilityInfos() {

        if(age > 16) {
            salary = age*100
            isRecruitable = true
        }
    }
}