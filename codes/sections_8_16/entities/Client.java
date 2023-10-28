package sections_8_16.entities;
import java.time.LocalDate;

public class Client {
    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(String name, String email, LocalDate birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
	public String toString() {
		return "Client [Name = " + name + ", email = " + email + ", birthDate = " + birthDate + "]";
	}
}
