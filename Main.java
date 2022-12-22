import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    // a project to calculate a price of a rental assuming it is worth $40 for each hour and $1 per minute after that
    static Scanner inputDevice;

    static DecimalFormat dollarAmt;
    public static void main(String[] args) {
        init();
        int iMinutes = input();
        int cHours = hours(iMinutes);
        double cAdditionalMinutes = AdditionalMinutes(iMinutes);
        double cRentalCost = RentalCost(cHours, cAdditionalMinutes);
        formatDate();
        output(cHours, cAdditionalMinutes, cRentalCost);


    }


    public  static  String formatDate() {
        String enteredDate;
        System.out.println("Enter a date (mm/dd/yyyy)");
        enteredDate = inputDevice.nextLine();
        String enteredPattern = "MM/dd/yyyy";
        String newPattern = "MMM dd, yyyy";


        SimpleDateFormat sdf = new SimpleDateFormat(enteredPattern);
        try{
            Date d = sdf.parse(enteredDate);
            sdf.applyPattern(newPattern);
            String newDateString = sdf.format(d);
            System.out.println("Entered date formatted: " + newDateString);
        } catch(ParseException e){
            System.out.println("Invalid Date simulator");
        }

        return enteredDate;
    }
    public static int input(){ //gets the minutes the user wants to rent for
       String iData;
       int iMinutes;
       System.out.println("Please enter the minutes you plan to rent");
       iData = inputDevice.nextLine();

       try{
           iMinutes = Integer.parseInt(iData);
       }
       catch (Exception e){
           iMinutes = 60;
        }
       return iMinutes;
    }

    public static int hours(int iMinutes){ // calculates the hours
        int cHours;
        cHours = iMinutes / 60;
        return cHours;
    }

    public static double AdditionalMinutes(double iMinutes){
        double AdditionalMinutes;

        AdditionalMinutes = iMinutes % 60;

        return AdditionalMinutes;
    }

    private static void init(){
        inputDevice=new Scanner(System.in);

        dollarAmt = new DecimalFormat("$#,###.00");



    }

    public static double RentalCost (double cHours, double cAdditionalMinutes){
        double cRentalCost;
        cRentalCost = cHours * 40 + cAdditionalMinutes;
        return cRentalCost;
    }




    public  static String getdatefromuser(){
        String enteredDate;
        System.out.println("Enter Rental Date (mm/dd/yyyy)");
        enteredDate = inputDevice.nextLine();
        return enteredDate;
    }

    private static void output(int iHours, double cAdditionalMinutes, double cRentalCost){
        String oHours, oAdditionalMinutes, oRentalCost;
        oHours = Integer.toString(iHours);
        oAdditionalMinutes = Double.toString(cAdditionalMinutes);

        oRentalCost = dollarAmt.format(cRentalCost);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate));
        Motto.main();

        System.out.printf("%-5s%10s%-17s%10s%-11s\n", "Hours", "", "AdditionalMinutes", "", "Rental Cost");
        System.out.printf("%-5s%10s%-17s%10s%-11s\n", oHours, "", oAdditionalMinutes, "", oRentalCost );


    }
}
