package com.example.lab02intento1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab02intento1.ui.theme.Lab02Intento1Theme

class MainActivity : ComponentActivity() {
}

//Declarar lista de enteros
val listaDeEnteros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//Filtrar por numeros enteros
val listaDeImpares = listaDeEnteros.filter { it % 2 != 0 } // Si el residuo es distinto a 0 es impor
//Declarar lista de Strings
val nombres = listOf("Alicia", "Pedro", "Juan")
//Añadir un saludo a los elementos
val saludos = nombres.map { "¡Hola, $it!" }



fun main(){
    println("Hello World")

    println(calcularPromedio(listaDeEnteros))

    println(isPalindrome("oso"))
    println(isPalindrome("casa"))

    val suma = performOperation(1,2){a, b -> a+b}
    val resta = performOperation(1,2){a, b -> a-b}

    println("Resultado de la suma: $suma")
    println("Resultado de la resta: $resta")

    //Declarar personas
    val Persona1 = Persona("Juan", 18, "Male")
    //Convertir a estudiante
    val Estudiante1 = convertPersonToStudent(Persona1, "17444")
    val Estudiantes = listOf<Estudiante>(Estudiante1)
    printStudentInfo(Estudiantes)
}

//Calcular Promedios de una lista
fun calcularPromedio(numeros: List<Int>): Double {
    return numeros.reduce { acc, num -> acc + num }.toDouble() / numeros.size
}

//Revisar si es Palindrome
fun isPalindrome(cadena: String) = cadena == cadena.reversed()

fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

//Definir las clases
data class Persona(val name: String, val age: Int, val gender: String)
data class Estudiante(val name: String, val age: Int, val gender: String, val studentId: String)


//Conversor de persona a Estudiante Extrayendo datos de su clase
fun convertPersonToStudent(person: Persona, studentId: String): Estudiante {
    return Estudiante(person.name, person.age, person.gender, studentId)
}

//Imprimir información de estudiante
fun printStudentInfo(students: List<Estudiante>) {
    students.forEach { println("El estudiante ${it.name} tiene ${it.age} años") }
}

