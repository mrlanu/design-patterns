package io.lanu.design_patterns.kotlin

// client
fun main() {
    val remoteControl = RemoteControl()
    remoteControl.pushMinusButton()
}


interface Command {
    fun execute()
}

class Add: Command {
    override fun execute() {
        // receiver (here should be an instance)
        println("Calculator started")
        println("Executing add operation")
        println("Done")
    }
}

class Minus: Command {
    override fun execute() {
        // receiver
        println("Calculator started")
        println("Executing minus operation")
        println("Done")
    }
}

class Multiply: Command {
    override fun execute() {
        // receiver
        println("Calculator started")
        println("Executing multiply operation")
        println("Done")
    }
}

// invoker
class RemoteControl{
    private val commands = mapOf("ADD" to Add(), "MINUS" to Minus(), "MULTIPLY" to Multiply())
    private val executedCommands = mutableListOf<Command>()

    fun pushPlusButton(){
        val comm = commands["ADD"]
        comm!!.execute()
        executedCommands.add(comm)
    }

    fun pushMinusButton(){
        val comm = commands["MINUS"]
        comm!!.execute()
        executedCommands.add(comm)
    }
}
