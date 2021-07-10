data class Dog(var name: String) {
    fun bark() = "bow-wow"
}

data class Man(var name: String) {
    fun hello() = "Hi I'm $name"
}

//仕様変更 Dog , Man は変更できないという条件
// greedingで各クラスのメソッドを統一して表示
class GreetingAdapter(var obj: Any) {
    val classname = obj.javaClass.name
    fun greeting(): String {
        when (classname) {
            "Dog" -> return (obj as Dog).bark()
            "Man" -> return (obj as Man).hello()
        }
        throw ClassNotFoundException()
    }
}

fun main() {
    val dog = Dog("pochi")
    val man = Man("Yamada")
    println(GreetingAdapter(dog).greeting())
    println(GreetingAdapter(man).greeting())
}
