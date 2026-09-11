package main

class Arr(val intArray: IntArray)
{
    fun positivesSum():Int
    {
        var sum = intArray.reduce { acc, i -> acc + (if (i>0) i else 0) };
        if (intArray[0] < 0)
            sum -= intArray[0];
        return sum;
    }

    fun prodTotal():Int
    {
        return intArray.reduce { acc, i -> acc * i };
    }

    fun mean():Double
    {
        if (intArray.size == 0)
            return 0.0;
        return intArray.reduce { acc, i -> acc + i }.toDouble() / intArray.size;
    }
}

fun N8Work()
{
    val arr = Arr(intArrayOf(-3,5,5,2,-1));
    println("arr.positivesSum() " + arr.positivesSum());
    println("arr.prodTotal() " + arr.prodTotal());
    println("arr.mean() " + arr.mean());
}