package entities;

public class Collaborator {
    private int id;
    private String name;
    private double salary;

    public Collaborator(){}

    public Collaborator(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
   }

   public void setId(int newId){
    this.id = newId;
   }
    public void changeSalary(double raise){
        this.salary += raise;
   }

   public double getSalary(){
    return salary;
   }

   public int getId(){
    return id;
   }

   public String getName(){
    return name;
   }
}
