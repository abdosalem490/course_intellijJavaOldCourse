public class Dog extends Animal {
    private int eyes, legs, tail, teeth;
    private String coat;

    public Dog(int size, int weigth, String name, int eyes, int legs, int tail, int teeth, String coat) {
        super(1, 1, size, weigth, name);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("DOg.eat() called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        super.move(5);
    }

    public void run()
    {
        System.out.println("Dog.reu() called");
        move(10);
    }
    private void moveLegs(int speed)
    {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}