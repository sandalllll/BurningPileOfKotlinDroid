package main

fun N3Work()
{
    val a = (0..100).random();
    while (true)
    {
        val s = readLine() ?: "0";
        val entered = s.toInt();
        if (entered == a)
        {
            println("Угадал")
            break;
        }
        if (entered > a)
            println("Много")
        else
            println("Мало")
    }
}