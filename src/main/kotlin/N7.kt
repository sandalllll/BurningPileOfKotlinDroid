package main

fun sqr(num: Double): Double
{
    return  num*num;
}

fun discriminant(a: Double, b: Double, c: Double): Double
{
    return b*b - a*c*4.0;
}

fun rootsNumber(a: Double, b: Double, c: Double): Int
{
    val d = discriminant(a, b, c);
    return when
    {
        d > 0.0 -> 2;
        d < 0.0 -> 0;
        else -> 1;
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double)
{
    val rs = rootsNumber(a,b,c);
    when (rs)
    {
        0 -> println("no roots");
        1 -> println(-b/a/2.0);
        else -> {
            val dr = Math.sqrt(discriminant(a, b, c));
            val a2 = a * 2.0;
            println("" + ((-b-dr)/a2) + " " + ((-b+dr)/a2));
        }
    }
}

fun N7Work()
{
    println("sqr(5.0) " + sqr(5.0));
    println("discriminant(-2.0, 3.0, -1.0) " + discriminant(-2.0, 3.0, -1.0));
    println("rootsNumber(-2.0, 3.0, -1.0) " + rootsNumber(-2.0, 3.0, -1.0));
    println("quadraticRoot(-2.0, 3.0, -1.0)");
    quadraticRoot(-2.0, 3.0, -1.0);
}