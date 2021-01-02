// write your class here
class Box {
    // public variables
    public double length;
    public double height;
    public double width;
    public Box innerBox;

    // Constructors
    public Box() {
        // No arguments.
    }

    public Box(double length, double height, double width, Box innerBox) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.innerBox = innerBox;
    }
}