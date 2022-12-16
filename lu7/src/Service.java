import java.io.*;
import java.util.ArrayList;

public class Service {
    private ArrayList<Device> devices;
    private ArrayList<BrokenDevice> brokenDevices;
    private final String databaseBrokenDevicesPath = "C:\\Users\\User\\Desktop\\databaseBrokenDevices.ser";
    private final String databaseDevicesPath = "C:\\Users\\User\\Desktop\\databaseDevices.ser";

    public ArrayList<Device> getDevices() {
        return devices;
    }
    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }
    public ArrayList<BrokenDevice> getBrokenDevices() {
        return brokenDevices;
    }
    public void setBrokenDevices(ArrayList<BrokenDevice> brokenDevices) {
        this.brokenDevices = brokenDevices;
    }

    public Service(){
        this.devices = new ArrayList<>();
        this.brokenDevices = new ArrayList<>();
    }

    public void Add(Device device){
        if(device instanceof BrokenDevice){
            try{
                this.brokenDevices.add((BrokenDevice) device);
                FileOutputStream fileOutputStream = new FileOutputStream(databaseBrokenDevicesPath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (int i = 0; i < this.brokenDevices.size(); i++) {
                    objectOutputStream.writeObject(this.brokenDevices.get(i));
                }
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                this.devices.add(device);
                FileOutputStream fileOutputStream = new FileOutputStream(databaseDevicesPath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (int i = 0; i < this.devices.size(); i++) {
                    objectOutputStream.writeObject(this.devices.get(i));
                }
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void ViewAllDevice(){
        try{
            FileInputStream fileInputStream = new FileInputStream(databaseDevicesPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for(int i = 0; i  < this.devices.size(); i++){
                Device device = (Device) objectInputStream.readObject();
                System.out.println(device.toString());
            }
            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void ViewAllBrokenDevice(){
        try{
            FileInputStream fileInputStream = new FileInputStream(databaseBrokenDevicesPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for(int i = 0; i  < this.brokenDevices.size(); i++){
                Device device = (Device) objectInputStream.readObject();
                System.out.println(device.toString());
            }
            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void DeviceIsBroken(Device device, String symptoms, int daysToRecover){
        if(!(device instanceof Device)){
            try{
                throw new NotDevice();
            }catch (NotDevice e){
                e.printStackTrace();
            }
        }
        if(this.devices.contains(device)){
            this.devices.remove(device);
        }
        else{
            return;
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(databaseDevicesPath);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
            for(int i = 0; i < this.devices.size(); i++){
                objectInputStream.writeObject(this.devices.get(i));
            }
            objectInputStream.close();
            BrokenDevice brokenDevice = new BrokenDevice(device.getBrand(), device.getModel(), device.getPrice(), device.getId(), symptoms, daysToRecover);
            this.brokenDevices.add(brokenDevice);
            FileOutputStream fileOutputStream1 = new FileOutputStream(databaseBrokenDevicesPath);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
            for (int i = 0; i < this.brokenDevices.size(); i++){
                objectOutputStream1.writeObject(this.brokenDevices.get(i));
            }
            objectOutputStream1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void DeviceIsRepaired(BrokenDevice device){
        if(!(device instanceof BrokenDevice)){
            try{
                throw new NotBrokenDevice();
            }catch (NotBrokenDevice e){
                e.printStackTrace();
            }
        }
        if(this.brokenDevices.contains(device)){
            this.devices.remove(device);
        }
        else{
            return;
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(databaseBrokenDevicesPath);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
            for(int i = 0; i < this.brokenDevices.size(); i++){
                objectInputStream.writeObject(this.brokenDevices.get(i));
            }
            objectInputStream.close();
            Device notBrokenDevice = new Device(device.getBrand(), device.getModel(), device.getPrice(), device.getId());
            this.devices.add(notBrokenDevice);
            FileOutputStream fileOutputStream1 = new FileOutputStream(databaseDevicesPath);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
            for (int i = 0; i < this.devices.size(); i++){
                objectOutputStream1.writeObject(this.devices.get(i));
            }
            objectOutputStream1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PrintAllBrokenDevicesWithTheGivenSymptom(String symptom){
        for (int i = 0; i < this.brokenDevices.size(); i++){
            if(this.brokenDevices.get(i).getSymptoms().equals(symptom)){
                System.out.println(this.brokenDevices.get(i).toString());
            }
        }
    }

    public double PriceSumOfAllDevices(){
        double sum = 0;
        for(int i = 0; i < this.devices.size(); i++){
            sum += this.devices.get(i).getPrice();
        }
        for(int i = 0; i < this.brokenDevices.size(); i++){
            sum += this.brokenDevices.get(i).getPrice();
        }
        return sum;
    }
}