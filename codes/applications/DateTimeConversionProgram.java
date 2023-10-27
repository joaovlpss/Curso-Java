package applications;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class DateTimeConversionProgram {
    public static void main(String[] args){

        LocalDate d04 = LocalDate.parse("2023-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2023-07-20T01:30:26");
        Instant d06 = Instant.parse("2023-07-20T01:30:26Z");

        // Converting d06 to a local date.
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal")); // of() method takes any argument from getAvaliableZoneIds()
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);

        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        // Getting instance's values separately
        System.out.println("d04 day = " + d04.getDayOfMonth());
        System.out.println("d04 day = " + d04.getMonthValue());
        System.out.println("d04 day = " + d04.getYear());
        System.out.println("d05 hour = " + d05.getHour());
        System.out.println("d05 minute = " + d05.getMinute());

        // Using DateTime operations
        LocalDate pastWeekLocalDate = d04.minusWeeks(1);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusWeeks(1);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

        // Since instant doesn't have (minus/plus)Days/Weeks(), we use minus()/plus() with ChronoUnit
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("pastWeekInstant = " + pastWeekInstant);

        // Calculating duration
        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay()); // LocalDate has to be converted to LocalDateTime 
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(nextWeekInstant, pastWeekInstant); // First date posterior to second should return -N.

        System.out.println("t1 days = " + t1.toDays());
        System.out.println("t2 days = " + t2.toDays());
        System.out.println("t3 days = " + t3.toDays());
        System.out.println("t4 days = " + t4.toDays());
    }
    
}
