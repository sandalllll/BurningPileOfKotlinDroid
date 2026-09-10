package main

fun N5Work(ints: IntArray)
{
    for (i in 1..(ints.size-2))
    {
        if (ints[i] > ints[i-1] && ints[i] > ints[i+1])
            print(" " + ints[i]);
    }
    print("\n");
    var i = 1;
    while (i  < ints.size-1)
    {
        if (ints[i] > ints[i-1] && ints[i] > ints[i+1])
            print(" " + ints[i]);
        i++;
    }
    print("\n");
    ints.forEachIndexed { index, num ->
        if (index !=0 && index != (ints.size-1) && num > ints[index-1] && num > ints[index+1])
            print(" " + num);
    }
    print("\n");
}