package io.lanu.design_patterns.kotlin

fun main() {
    val customer = Customer.build {
        firstName("FirstName")
        lastName("LastName")
        build()
    }

    println(customer)
}

class Customer private constructor(
    private val firstName: String?,
    private val lastName: String?){

    private constructor(builder: Builder) : this(builder.firstName, builder.lastName)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }


    class Builder(var firstName: String? = null, var lastName: String? = null) {

        fun firstName(name: String) {
            this.firstName = name
        }

        fun lastName(name: String) {
            this.lastName = name
        }

        fun build() = Customer(this)
    }

    override fun toString(): String {
        return "Customer(firstName=$firstName, lastName=$lastName)"
    }

}
