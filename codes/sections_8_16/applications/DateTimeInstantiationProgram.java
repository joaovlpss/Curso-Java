package sections_8_16.applications;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class DateTimeInstantiationProgram {
    public static void main(String[] args){

        // Instantiating DateTime instances on runtime.
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        // Instantiating ISO 8601 Formatted DateTimes.
        LocalDate d04 = LocalDate.parse("2023-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2023-07-20T01:30:26");
        Instant d06 = Instant.parse("2023-07-29T01:30:26Z");// UTC Timezone
        Instant d07 = Instant.parse("2023-07-29T01:26-03:00"); // BRT being stored as UTC

        // Instantiating Custom-Format Datetimes.
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatting to PT-BR format.
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d08 = LocalDate.parse("20/07/2023", fmt1); 
        LocalDateTime d09 = LocalDateTime.parse("20/07/2023 01:30", fmt2);

        // Instantiating DateTimes from parameters.
        LocalDate d10 = LocalDate.of(2023, 7, 20);
        LocalDateTime d11 = LocalDateTime.of(2023, 7, 20, 1, 30);

        System.out.println("d01 = " + d01); // Equivalent to d0N.toString();
        System.out.println("d02 = " + d02); // Automatically returns ISO 8601-formatted data string.
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);
        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);
        System.out.println("d11 = " + d11);

    }    
}
