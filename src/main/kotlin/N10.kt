package main

open class Vehicle(val speed: Double = 10.0, val name: String = "Copter")
{
    open fun start()
    {
        println("$name is moving with $speed km/h");
    }
    open fun stop()
    {
        println("$name is not moving");
    }
}

class Boat(): Vehicle(5.0, "Willie")
{
    override fun start()
    {
        println("$name is swimming with $speed km/h");
    }
    override fun stop()
    {
        println("$name is sinking");
    }
}

class Tank(): Vehicle(25.0, "Shattering mass")
{
    override fun start()
    {
        println("$name is crawling with $speed km/h");
    }
    override fun stop()
    {
        println("$name stands like a monolith");
    }
}

class Plane(): Vehicle(500.0, "Enola")
{
    override fun start()
    {
        println("$name is flying with $speed km/h");
    }
    override fun stop()
    {
        println("$name is falling");
    }
}

fun N10Work()
{
    println("val vehicle = Vehicle();");
    val vehicle = Vehicle();
    println("vehicle.start()");
    vehicle.start();
    println("vehicle.stop()");
    vehicle.stop();

    println("\nval boat = Boat();");
    val boat = Boat();
    println("boat.start()");
    boat.start();
    println("boat.stop()");
    boat.stop();

    println("\nval tank = Tank();");
    val tank = Tank();
    println("tank.start()");
    tank.start();
    println("tank.stop()");
    tank.stop();

    println("\nval plane = Plane();");
    val plane = Plane();
    println("plane.start()");
    plane.start();
    println("plane.stop()");
    plane.stop();
}