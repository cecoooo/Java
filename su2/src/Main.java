import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Boolean compareString(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        for(int i = 0; i < str1.length(); i++){
            int char1 = (int)str1.charAt(i);
            int char2 = (int)str2.charAt(i);
            if(char1 != char2){
                return false;
            }
        }
        return true;
    }
    static void ex1() {
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(a + b + c);
    }

    static void ex2() {
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        int max = a > b ? a : b;
        System.out.println(max);
    }

    static void ex3() {
        int a, b, c, d, e;
        a = sc.nextInt();
        ;
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        System.out.println(a + b + c + d + e);
    }

    static void ex4() {
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        Arrays.stream(arr).sorted();
        System.out.println(arr[0] + arr[2]);
    }

    static void ex5() {
        double x, y;
        x = sc.nextDouble();
        y = sc.nextDouble();
        if (x > y) {
            x += +y;
            y = x - y;
            x -= y;
        }
        System.out.println(x);
        System.out.println(y);
    }

    static void ex6() {
        int a, b, c, max;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if (a >= b && a >= c) {
            max = a;
        } else if (b >= a && b >= c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println(max);
    }

    static void ex7() {
        int a, b, c, max = Integer.MIN_VALUE;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            if (a >= b && a >= c) {
                max = a;
            } else if (b >= a && b >= c) {
                max = b;
            } else {
                max = c;
            }
            System.out.println(max);
            if (max == a) {
                a = Integer.MIN_VALUE;
            } else if (max == b) {
                b = Integer.MIN_VALUE;
            } else {
                c = Integer.MIN_VALUE;
            }
            max = Integer.MIN_VALUE;
        }
    }

    static void ex8() {
        String word = sc.next();
        switch (word) {
            case "1":
                word = "one";
                break;
            case "2":
                word = "two";
                break;
            case "3":
                word = "three";
                break;
            case "4":
                word = "four";
                break;
            case "5":
                word = "five";
                break;
            case "6":
                word = "six";
                break;
            case "7":
                word = "seven";
                break;
            case "8":
                word = "eight";
                break;
            case "9":
                word = "nine";
                break;
            case "10":
                word = "ten";
                break;
            default:
                word = "not a digit";
                break;
        }
        System.out.println(word);
    }

    static void ex9() {
        int[] arr = new int[5];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        System.out.println(Arrays.stream(arr).max());
    }

    static void ex10() {
        System.out.println("Enter what type you want to use:");
        String type = sc.next();
        if (compareString(type, "String")) {
            String str = sc.next();
            str += "*";
            System.out.println(str);
        } else if (compareString(type, "int")) {
            int num = sc.nextInt();
            num += 1;
            System.out.println(num);
        } else if(compareString(type, "double")) {
            double num = sc.nextDouble();
            num += 1;
            System.out.println(num);
        }
        else System.out.println("Invalid or unsupported type...");
    }

    static void ex11(){
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) System.out.println(i);
    }

    static void ex12(){

    }

    static void ex13(){
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) arr[i] = sc.nextInt();
        System.out.println(Arrays.stream(arr).sum());
    }

    public static void main(String[] args) {
        System.out.println("Enter exercise: ");
        int ex = sc.nextInt();
        switch (ex) {
            case 1:
                ex1();
                break;
            case 2:
                ex2();
                break;
            case 3:
                ex3();
                break;
            case 4:
                ex4();
                break;
            case 5:
                ex5();
                break;
            case 6:
                ex6();
                break;
            case 7:
                ex7();
                break;
            case 8:
                ex8();
                break;
            case 9:
                ex9();
                break;
            case 10:
                ex10();
                break;
            case 11:
                ex11();
                break;
            case 12:
                ex12();
                break;
            case 13:
                ex13();
                break;
        }
    }
}