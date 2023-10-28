package sections_1_8.entities;

public class Student {
    public String name;
    public double gradeQuarter1, gradeQuarter2, gradeQuarter3;

    public void setGrades(double g1, double g2, double g3){
        if ((0 <= g1 && g1 <= 30) || (0 <= g2 && g2 <= 35) || (0 <= g3 && g3 <= 35)) {
            gradeQuarter1 = g1;
            gradeQuarter2 = g2;
            gradeQuarter3 = g3;
        }
        else{
            System.out.println("Invalid grades.");
        }
    }

    public void determine(){
        boolean passed = ((gradeQuarter1 + gradeQuarter2 + gradeQuarter3) >= 60) ? true : false;
        if (passed){
            System.out.println("PASSED.");
        }
        else{
            System.out.println("FAILED.");
            System.out.printf("MISSING %.2f POINTS", (60 - (gradeQuarter1 + gradeQuarter2 + gradeQuarter3)));
        }
    }
    
}
