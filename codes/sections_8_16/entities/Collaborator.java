package sections_8_16.entities;

import java.util.List;

import sections_8_16.entities.enums.WorkerLevel;

import java.util.ArrayList;

public class Collaborator {
    private int id;
    private String name;
    private double baseSalary;
    private WorkerLevel level;
    private List<HourContract> contracts = new ArrayList<HourContract>();
    private Department dep;

    public Collaborator(){}

    public Collaborator(int id, String name, double baseSalary){
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
   }

   public Collaborator(int id, String name, double baseSalary, WorkerLevel level, Department dep){
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.dep = dep;
   }

    public void setId(int newId){
    this.id = newId;
   }
    public void changeBaseSalary(double raise){
    this.baseSalary += raise;
   }

    public void addContract(HourContract contract){
    contracts.add(contract);
   }

    public void removeContract(HourContract contract){
    contracts.remove(contract);
   }

    public int getId(){
    return id;
   }

    public String getName(){
    return name;
   }

    public String getWorkerLevel(){
    return level.toString();
   }

    public String getDep(){
    return dep.getDepName();
   }

   // For compatibility with CollaboratorProgram, which still uses only baseSalary.
    public double getBaseSalary(){
    return baseSalary;
   }

   // Calculates all money earned in that month and year, by multiplying the valueperhour with hours for every given contract within that timespan.
   public double income(int year, int month){
    double accumulator = 0.00;

    for (HourContract contract : contracts){
        if (contract.getDate().getYear() == year &&
            contract.getDate().getMonthValue() == month){
                accumulator += (contract.getValuePerHour() * contract.getHours());
            }
    }

    return accumulator + baseSalary;
   }

   public List<HourContract> getContracts(){
    return contracts;
   }

}
