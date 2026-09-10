package main

import kotlin.compareTo
import kotlin.text.get

fun forWork(ints: IntArray)
{
    var min = ints[0];
    var max = ints[0];
    var prod = 1;
    for (i in 0..<ints.size)
    {
        if (ints[i] < min)
            min = ints[i];
        if (ints[i] > max)
            max = ints[i];
        prod *= ints[i];
    }
    println("for min: $min, max: $max, prod: $prod");
}

fun whileWork(ints: IntArray)
{
    var min = ints[0];
    var max = ints[0];
    var prod = 1;
    var i = 0;
    while (i < ints.size)
    {
        if (ints[i] < min)
            min = ints[i];
        if (ints[i] > max)
            max = ints[i];
        prod *= ints[i];
        i++
    }
    println("while min: $min, max: $max, prod: $prod");
}

fun forEachWork(ints: IntArray)
{
    var min = ints[0];
    var max = ints[0];
    var prod = 1;
    ints.forEach { num ->
        if (num < min)
            min = num;
        if (num > max)
            max = num;
        prod *= num;
    }
    println("forEach min: $min, max: $max, prod: $prod");
}

fun reduceWork(ints: IntArray)
{
    var min = ints.reduce { acc, element -> (if (acc < element) acc else element) };
    var max = ints.reduce { acc, element -> (if (acc > element) acc else element) };
    var prod = ints.reduce { acc, element -> (acc * element) };
    println("reduce min: $min, max: $max, prod: $prod");
}

fun minMaxWork(ints: IntArray)
{
    var min = ints.min();
    var max = ints.max();
    println("minMax min: $min, max: $max");
}


fun N6Work(ints: IntArray)
{
    forWork(ints);
    whileWork(ints);
    forEachWork(ints);
    reduceWork(ints);
    minMaxWork(ints);
}