package main

fun N2Work()
{
    var count = 0
    var sum = 0
    while (true)
    {
        val s = readLine() ?: "0"
        val entered = s.toInt()
        if (entered == 0)
            break
        count++
        sum += entered
    }
    println("count=" + count +
            ", sum=" + sum +
            ", mid=" + (if (count > 0) (sum / count) else "0"))
}