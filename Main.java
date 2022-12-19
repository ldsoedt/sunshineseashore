import java.text.DecimalFormat;
import java.util.Scanner;

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
        output(cHours, cAdditionalMinutes, cRentalCost);


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



    private static void output(int iHours, double cAdditionalMinutes, double cRentalCost){
        String oHours, oAdditionalMinutes, oRentalCost;
        oHours = Integer.toString(iHours);
        oAdditionalMinutes = Double.toString(cAdditionalMinutes);
        oRentalCost = dollarAmt.format(cRentalCost);
        Motto.main();
        System.out.printf("%-5s%10s%-17s%10s%-11s\n", "Hours", "", "AdditionalMinutes", "", "Rental Cost");
        System.out.printf("%-5s%10s%-17s%10s%-11s\n", oHours, "", oAdditionalMinutes, "", oRentalCost );


    }
}