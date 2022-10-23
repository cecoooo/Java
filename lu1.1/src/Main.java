import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printIntroduction();
        Scanner sc = new Scanner(System.in);
        double index = getBMI(sc);
        String res = getStatus(index);
        ReportResults(1, index, res);
    }
    public static void printIntroduction(){
        System.out.println("BMI Calculator.");
    }
    public static double getBMI(Scanner sc){
        System.out.println("Enter your height: ");
        double cm = sc.nextInt();
        System.out.println("Enter your weight: ");
        double kg = sc.nextInt();
        double height = kg * 0.3937;
        double weight = cm/`2.2046;
        return bmiFor(height, weight);
    }
    public static double bmiFor(double h, double w){
        return w*703/ (h*h);
    }
    public static String getStatus(double index){
        if(index <= 18.5) return "underweight";
        else if(index <= 25) return "normal";
        else if(index <= 30) return "overweight";
        else return "obese";
    }
    public static void ReportResults(int num, double bmi, String status){
        System.out.println("Number: " + num + "\n" + "BMI index: " + Math.round(bmi) + "\n" + "Status: " + status);
    }
}

