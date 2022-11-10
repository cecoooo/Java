public class Main {
    public static void main(String[] args) {
        House house = new House();
        House house1 = new House();
        House house2 = new House();
        house.EnterDataForObject();
        house1.EnterDataForObject();
        house2.EnterDataForObject();
        House[] arr = new House[]{house, house1, house2};
        System.out.println(house.heightestGrade(arr).toString());
    }
}