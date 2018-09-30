@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import lesson2.task1.module
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int = when {
    module(n) < 10 -> 1
    else -> digitNumber(n / 10) + digitNumber(n % 10)
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var num = 1
    var add = 1
    var temp: Int
    for (i in 3..n) {
        temp = num
        num += add
        add = temp
    }
    return num
}
/*        if (n <= 2) 1
        else fib(n - 1) + fib(n - 2) */

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var nod = 1
    if (max(m, n) % min(m, n) == 0) return max(m, n)
    for (i in min(m, n) / 2 downTo 2) {
        if (m % i == 0 && n % i == 0) {
            nod = i
            break
        }
    }
    return m * n / nod
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    if (n % 2 == 0) return 2
    for (i in 3..sqrt(n.toDouble()).toInt() step 2)
        if (n % i == 0) return i
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    if (n % 2 == 0) return n / 2
    for (i in 3..sqrt(n.toDouble()).toInt() step 2)
        if (n % i == 0) return n / i
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    if (m == 1 || n == 1) return true
    if (m % 2 == 0 && n % 2 == 0) return false
    if (max(m, n) % min(m, n) == 0) return false
    for (i in 3..sqrt(min(m, n).toDouble()).toInt() step 2)
        if (m % i == 0 && n % i == 0) return false
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i in sqrt(min(m, n).toDouble()).toInt()..sqrt(max(m, n).toDouble()).toInt())
        if (sqr(i) >= min(m, n) && sqr(i) <= max(m, n)) return true
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    if (x == 1) return 0
    return if (x % 2 == 0) 1 + collatzSteps(x / 2)
    else 1 + collatzSteps(x * 3 + 1)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val newx = x % (2 * PI)
    var rez = newx
    var i = 3
    while (newx.pow(i) / factorial(i) >= eps || -1 * newx.pow(i) / factorial(i) >= eps) {
        rez -= newx.pow(i) / factorial(i) - newx.pow(i + 2) / factorial(i + 2)
        i += 4
    }
    return rez
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    val newx = x % (2 * PI)
    var rez = 1.0
    var i = 2
    while (newx.pow(i) / factorial(i) >= eps || -1 * newx.pow(i) / factorial(i) >= eps) {
        rez -= newx.pow(i) / factorial(i) - newx.pow(i + 2) / factorial(i + 2)
        i += 4
    }
    return rez
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var rez = 0
    var num = n
    while (num > 0) {
        rez *= 10
        rez += num % 10
        num /= 10
    }
    return rez
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = n == revert(n)

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = when {
    n < 10 -> false
    n < 100 -> n % 10 != n / 10 % 10
    n % 10 == n / 10 % 10 -> hasDifferentDigits(n / 10)
    else -> true
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var i = 0
    var ibegin = 0
    var num: Int
    var j = 0
    while (i < n) {
        j++
        num = j * j
        ibegin = i + 1
        while (num > 0) {
            i++
            if (i == n) break
            num /= 10
        }
    }
    num = revert(j * j)
    for (dig in ibegin..i){
        j = num % 10
        num /= 10
    }
    return j
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var i = 2
    var ibegin = 2
    var num = 1
    var snum = 1
    var n1 = 1
    var n2: Int
    if (n == 1 || n == 2) return 1
    while (i < n) {
        n2 = n1
        n1 = num
        num = n1 + n2
        ibegin = i + 1
        snum = num
        while (num > 0) {
            i++
            if (i == n) break
            num /= 10
        }
        num = snum
    }
    num = revert(snum)
    for (dig in ibegin..i){
        snum = num % 10
        num /= 10
    }
    return snum
}
