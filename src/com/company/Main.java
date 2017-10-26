package me.aoa4eva;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String DateFormat="dd/MM/yyyy";
        //Get the current time
        LocalDateTime rightNow= LocalDateTime.now();
        //Date from the user
        LocalDate userDate=null;
//

        //Set up formatters so that you can use them later
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter shortMonthFormat1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        DateTimeFormatter shortMonthFormat2 = DateTimeFormatter.ofPattern("dd MM yyyy");
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        //Time formatter (time only)
        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");

        //Output today's date in formats that have been preset
        System.out.println("The current date is: "+rightNow.format(longFormat));
        System.out.println("This is the current date and time unformatted: "+rightNow);

        //Output the current time in formats that have been preset
        System.out.println("This is the current system time: "+ LocalTime.now());
        System.out.println("This is the current system time (24 h format): "+LocalTime.now().format(hr24));


        do{
            System.out.println("Enter a date on or before Today (dd/mm/yyyy)");
            try{
                userDate = LocalDate.parse(keyboard.nextLine(),dTF);

            }catch(Exception e)



            {
                if(userDate.isAfter(LocalDate.now())&&userDate!=null)
                    System.out.println("The date must be in the past");

                System.out.println("Unable to convert the string you entered to date. Please try again!");

            }

        }while(userDate.compareTo(LocalDate.now())>0);          //This will compare the userdate against the local date and if the userdate is greater then it will ask to ret

        //Display the date entered
        System.out.println("This will show user in format of date entered in day, Month (3 letters) and year (4 digit) format is: " +userDate.format(shortMonthFormat));
        System.out.println("This will show user in format of date entered in Month (3 letters), day  and year (4 digit) format is: " +userDate.format(shortMonthFormat1));
        System.out.println("This will show user in format of date entered in day, month (2 digits) and year format is: " +userDate.format(shortMonthFormat2));

    }
}
