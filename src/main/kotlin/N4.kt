package main

fun isPrime(number: Int): Boolean {
    val upperBound = kotlin.math.sqrt(number.toDouble()).toInt()
    return (2..upperBound).none { number % it == 0 }
}

fun N4Work() {
    val n = (readLine() ?: "0").toInt();
    var i = 1;
    var cursor = 2;
    while (i <= n)
    {
        if (isPrime(cursor))
        {
            println("$i-ое число: $cursor");
            i++;
        }
        cursor++;
    }
}