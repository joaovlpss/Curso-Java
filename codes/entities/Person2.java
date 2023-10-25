package entities;

public class Person2 {
    private double height;
    private char gender;

    public Person2(double height, char gender){
        this.height = height;
        this.gender = gender;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public double getHeight(){
        return height;
    }

    public char getGender(){
        return gender;
    }
}
