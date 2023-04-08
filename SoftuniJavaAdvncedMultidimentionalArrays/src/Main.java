import java.util.Scanner;
import java.util.Arrays;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arrSize = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[arrSize[0]][arrSize[1]];
        int c = 1;
        for (int i = 0; i < arrSize[0]; i++) {
            for (int j = 0; j < arrSize[1]; j++) {
                arr[i][j] = c;
                c++;
            }
        }
        while(true) {
            String rowInput = sc.nextLine();
            if(rowInput.equals("Nuke it from orbit")) break;
            int[] input = Arrays.stream(rowInput.split(" ")).mapToInt(Integer::parseInt).toArray();
            int iCoordinate = input[0];
            int jCoordinate = input[1];
            int radius = input[2];
            if(arr[iCoordinate][jCoordinate] == 0) continue;
            for (int i = 0; i < arrSize[0]; i++)
            {
                for(int j = 0; j < arrSize[1]; j++)
                {
                    if(i == iCoordinate)
                    {
                        if(j >= jCoordinate - radius && j <= jCoordinate + radius) arr[i][j] = 0;
                    }
                    if(j == jCoordinate)
                    {
                        if(i >= iCoordinate - radius && i <= iCoordinate + radius) arr[i][j] = 0;
                    }
                }
            }
            Shift(arr);
        }
        Arrays.stream(arr).forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                if(y != 0) System.out.print(y + " ");
                else System.out.print(" ");
            });
            System.out.println();
        });
    }

    private static void Shift(int[][] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length-1; j++)
            {
                if(arr[i][j] == 0 && arr[i][j+1] != 0)
                {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                }
            }
        }
    }
}
