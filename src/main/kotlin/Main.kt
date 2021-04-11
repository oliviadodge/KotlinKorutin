import kotlinx.coroutines.*


fun main(args: Array<String>) {
    runExampleOfSuspendingFunctions()
}

private fun runExampleOfSuspendingFunctions() = runBlocking { // this: CoroutineScope
    launch {
        hello()
    }

    launch {
        world()
    }
}


private suspend fun hello() {
    delay(1000L)
    println("Hello, ")
}

private suspend fun world() {
    delay(500L)
    println("World!")
}

private fun runExampleOfRunBlocking() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("World!")
    }

    println("Hello, ")
}


private fun runExampleOfCoroutineScope() {
    runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch completes
    }
}