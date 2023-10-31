class Executive(lastName: String, firstName:String, yearsBirth: Int, private var grade:Grade) : Employee(lastName, firstName, yearsBirth){


    override fun toString(): String {
        return super.toString() + " and also has a prime of ${grade.bonus} euros."
    }

    fun getExeGrade() : Grade {
        return this.grade
    }

    // change le grade de l'employé avec le nouveau grade et recalcule son salaire.
    fun changeGrade(grade: Grade) {
        if(grade == Grade.ZERO) {
            println("You can't affect the grade ZERO to an official Executive.")
        } else {
            this.grade = grade
            salary = age * 100 + grade.bonus
            println("$lastName $firstName has now a grade of ${this.grade} and a prime of ${this.grade.bonus}.")
        }
    }

    //Si le cadre crée n'a pas l'age de travailler, on lui donne un grade de ZERO.
    init {
        if(age < 16) {
            this.grade = Grade.ZERO
        }
        salary += grade.bonus

    }
}