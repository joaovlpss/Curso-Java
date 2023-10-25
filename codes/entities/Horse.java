package entities;

public class Horse {
    private int age;
    private String name;
    private double height;
    private double length;
    private double distanceGalloped;
    private double timeGalloped;

    public Horse(){
    }

    public Horse(int age, String name){
        this.age = age;
        this.name = name;
    }

    public Horse(int age, String name, double height, double length){
        this.age = age;
        this.name = name;
        this.height = height;
        this.length = length;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void setHeight(double newHeight){
        this.height = newHeight;
    }

    public void setLength(double newLength){
        this.length = newLength;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getHeight(){
        return height;
    }

    public double getLength(){
        return length;
    }
    
    public double getDistanceGalloped(){
        return distanceGalloped;
    }

    public double getTimeGalloped(){
        return timeGalloped;
    }

    public void gallop(double time, double distance){
        this.timeGalloped += time;
        this.distanceGalloped += distance;
        this.age += (time/365*24);

        System.out.printf("Galloping %.2f kilometers...%n", distance);
        System.out.printf("Clop clop clop...%n");
        System.out.printf("It's been %.2f hours... Time to stop galloping.", time);
    }
}
