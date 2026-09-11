package main

class Vector(val x: Double, val y: Double, val z: Double)
{
    fun length(): Double
    {
        return Math.sqrt(x*x+y*y+z*z);
    }
    infix fun dot(other: Vector): Double
    {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }
    operator fun times(other: Vector): Double
    {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }
}

fun dotVec(a: Vector, b: Vector): Double
{
    return a.x * b.x + a.y * b.y + a.z * b.z;
}

fun N9Work()
{
    val a = Vector(5.0, -2.0, 7.0);
    val b = Vector(4.0, 0.4, -1.0);
    println("val a = Vector(5.0, -2.0, 7.0);");
    println("val b = Vector(4.0, 0.4, -1.0);");
    println("a len " + a.length());
    println("a.dot(b) " + a.dot(b));
    println("a dot b " + (a dot b));
    println("a * b " + a * b);
    println("dotVec(a, b) " + dotVec(a, b));
}