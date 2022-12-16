public class Test {
    public static void main(String[] args) {
        Device device1 = new Device("phone", "sony", 1500.00, "019392183");
        Device device2 = new Device("microwave", "samsung", 400.00, "0234524543");
        Device device3 = new Device("laptop", "apple", 4500.00, "0354323453");
        Device device4 = new Device("fridge", "candy", 950.00, "075674324");
        BrokenDevice brokenDevice1 = new BrokenDevice("washing-machine", "indesit", 1700.00, "0534565346", "ne bachka", 8);
        BrokenDevice brokenDevice2 = new BrokenDevice("car", "bmw", 1700.00, "0984566787", "ne bachka prez zimata", 14);
        BrokenDevice brokenDevice3 = new BrokenDevice("cooker", "gorenije", 600.00, "05465475674", "slab reotan", 3);
        Service service = new Service();
        service.Add(device1);
        service.Add(device2);
        service.Add(device3);
        service.Add(device4);
        service.Add(brokenDevice1);
        service.Add(brokenDevice2);
        service.Add(brokenDevice3);
        service.ViewAllDevice();
        System.out.println("---------------------");
        service.ViewAllBrokenDevice();
        service.DeviceIsBroken(device1, "ni bachka braaat", 2);
        System.out.println("---------------------");
        service.ViewAllDevice();
        System.out.println("---------------------");
        service.ViewAllBrokenDevice();
        System.out.println("---------------------");
        service.DeviceIsRepaired(brokenDevice2);
        service.ViewAllBrokenDevice();
        System.out.println("---------------------");
        service.ViewAllDevice();
        System.out.println("---------------------");
        service.PrintAllBrokenDevicesWithTheGivenSymptom("slab reotan");
        System.out.println("---------------------");
        System.out.println(service.PriceSumOfAllDevices());
    }
}