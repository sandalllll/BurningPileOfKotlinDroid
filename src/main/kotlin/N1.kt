package main

fun N1Work()
{
    var s: String?;
    while (true)
    {
        s = readLine();
        if (s != null)
            break;
    }
    println(s.last().toInt() + s.first().toInt() - '0'.toInt()*2);
}