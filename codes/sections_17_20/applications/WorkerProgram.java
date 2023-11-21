package sections_17_20.applications;

import java.util.List;

import sections_17_20.entities.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.BufferedReader;

public class WorkerProgram {
    public static void main(String[] args){
        List<Worker> workers = new ArrayList<>();
        String dataPath = System.getProperty("user.dir");

        try(BufferedReader br = new BufferedReader(new FileReader(dataPath + "/codes/sections_17_20/data/Employees.csv"))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                workers.add(new Worker(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Workers:");
        Collections.sort(workers);
        for(Worker worker : workers){
            System.out.println(worker.getName() + " - $ " + String.format("%.2f", worker.getSalary()));
        }
    }
}
