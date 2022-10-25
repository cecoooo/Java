import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static<T> void println(T text){
        System.out.println(text);
    }
    static<T> void print(T text){
        System.out.print(text);
    }

    static int[] inputIntArray(){
        print("Enter Array length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            print("Enter Array element: ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        print("Enter exercise: ");
        int ex = sc.nextInt();
        switch (ex){
            case 1: ex1(); break;
            case 2: ex2(); break;
            case 3: ex3(); break;
            case 4: ex4(); break;
            case 5: ex5(); break;
            case 6: ex6(); break;
            case 7: ex7(); break;
            case 8: ex8(); break;
            case 9: ex9(); break;
            case 10: ex10(); break;
            case 11: ex11(); break;
        }
    }

    static void ex1(){
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        if(a > b){
            a = a+b;
            b = a-b;
            a = a-b;
        }
        println(a);
        println(b);
    }

    static void ex2(){
        int points = sc.nextInt();
        if(points > 9 || points < 1){
            println("Invalid result");
            return;
        }
        else if(points >= 1 && points <= 3){
            points *= 10;
        }
        else if(points >= 4 && points <= 6){
            points *= 100;
        }
        else if(points >= 7 && points <= 9){
            points *= 1000;
        }
        println(points);
    }

    static void ex3(){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int res = a*b*c;
        if(res < 0){
            println('-');
        }
        else if(res > 0){
            println('+');
        }
        else {
            println(0);
        }
    }

    static void ex4(){
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            if(i % 3 != 0 && i % 7 != 0){
                print(i + " ");
            }
        }
    }

    static void ex5(){
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            print(i + " ");
        }
        println("");
        for(int i = n-1; i >= 1; i--){
            print(i + " ");
        }
    }

    static void ex6(){
        int n = sc.nextInt();
        if(n < 1 || n > 20){
            println("Invalid number");
            return;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n; j++) {
                print(i+j + " ");
            }
            println("");
        }
    }

    static void ex7(){
        println("-First Array-");
        int[] arr1 = inputIntArray();
        println("-Second Array-");
        int[] arr2 = inputIntArray();
        Boolean bool = Arrays.equals(arr1, arr2);
        if(bool)
            println("Equal");
        else
            println("Not equal");
    }

    static void ex8(){
        int[] arr = inputIntArray();
        int[] newArr = new int[arr.length];
        int i =0;
        for (int x: arr) {
            newArr[i] = x;
            i++;
        }
        Arrays.sort(newArr);
        if(Arrays.equals(arr, newArr))
            println("Yes");
        else
            println("No");
    }

    static void ex9(){
        int[] arr = inputIntArray();
        boolean bool = true;
        for(int i = 0, j = arr.length-1; i < j; i++, j--){
            if(arr[i] != arr[j]){
                bool = false;
                break;
            }
        }
        if(bool)
            println("Yes");
        else
            println("No");
    }

    static void ex10(){
        int[] arr = inputIntArray();
        int repNum = 0;
        List<Integer> listRepNums = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    repNum = arr[j];
                    count++;
                }
            }
            if (count > 1 && !listRepNums.contains(repNum)) {
                println("Repeated number: " + repNum);
                listRepNums.add(repNum);
            }
        }
    }
    static void ex11(){
        print("Enter number: ");
        int n = sc.nextInt();
        int[] arr = inputIntArray();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] + arr[j] == n){
                    println(arr[i]+ ", " + arr[j]);
                    return;
                }
            }
        }
    }
}