package sections_17_20.applications;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.time.Instant;

import sections_17_20.entities.Entry;
import sections_17_20.entities.User;


public class UserProgram {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        List<Entry> entries = new ArrayList<>();

        String currentWorkingDir = System.getProperty("user.dir");
        String relativePath = "codes/sections_17_20/data/Entries.csv";
        String fullPath = currentWorkingDir + "/" + relativePath;

        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            br.readLine(); // Skip header

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                
                String name = fields[0];
                Integer id = Integer.parseInt(fields[1]);
                String ipAddress = fields[2];
                Instant accessTime = Instant.parse(fields[3]);
                
                User user = new User(name, id, ipAddress);
                
                users.add(user);
                entries.add(new Entry(user, accessTime));
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<User> uniqueUsers = new HashSet<>();
        for(Entry entry : entries){
            if(uniqueUsers.contains(entry.getUser())){
                continue;
            }
            uniqueUsers.add(entry.getUser());
        }
        
        System.out.println("Unique users: " + uniqueUsers.size());
        for(User user : uniqueUsers){
            System.out.println(user);
        }
    }
}
