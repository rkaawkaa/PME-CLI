abstract class Person(protected var lastName:String,protected var firstName:String,protected val yearsBirth: Int) {


    override fun toString(): String {
        return "$lastName $firstName is born in $yearsBirth"
    }

    fun getfirstName(): String {
        return this.firstName
    }
    fun getlastName(): String {
        return this.lastName
    }

    fun setfirstName(newFirstName: String) {
        this.firstName = newFirstName
    }

    fun setlastName(newLastName: String) {
        this.lastName = newLastName
    }


}
