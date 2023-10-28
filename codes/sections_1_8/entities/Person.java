package sections_1_8.entities;

public class Person {
    private double height;
    private int age;
    private String name;

    public Person(double height,int age,String name){
        this.height = height;
        this.name = name;
        this.age = age;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getHeight(){
        return height;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
    
}
