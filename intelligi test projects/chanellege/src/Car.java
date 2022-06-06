public class Car
{
    private int cylinders , wheels ;
    private String name ;
    private boolean engine;

    public Car(int cylinders, String name)
    {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }
    public String startEngine()
    {
        return getClass().getSimpleName() + " -> startEngine()";
    }
    public String accelerate()
    {
        return getClass().getSimpleName() + " -> accelerate()";
    }
    public String brake()
    {
        return getClass().getSimpleName() + " -> brake()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

