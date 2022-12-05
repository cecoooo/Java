import java.io.*;
import java.util.ArrayList;

public class Service {
    private ArrayList<Device> devices;
    private ArrayList<BrokenDevice> brokenDevices;
    private final String databaseBrokenDevicesPath = "C:\\Users\\User\\Desktop\\databaseBrokenDevices.ser";
    private final String databaseDevicesPath = "C:\\Users\\User\\Desktop\\databaseDevices.ser";

    private FileOutputStream FileDevices(){
        try{
            return new FileOutputStream(databaseDevicesPath);
        }catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private FileOutputStream FileBrokenDevices(){
        try{
            return new FileOutputStream(databaseBrokenDevicesPath);
        }catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void AddToDevice(Device device){
        if(device instanceof BrokenDevice) {
            this.brokenDevices.add((BrokenDevice) device);
            try{
                ObjectOutputStream out = new ObjectOutputStream(FileBrokenDevices());
                out.writeObject(device);
                out.close();
                try {
                    FileBrokenDevices().close();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            this.devices.add(device);
            try{
                ObjectOutputStream out = new ObjectOutputStream(FileDevices());
                out.writeObject(device);
                out.close();
                try {
                    FileDevices().close();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void RepairDevice(Device device){
        Device e = null;
        try {

            do{
            FileInputStream fileIn = new FileInputStream(databaseBrokenDevicesPath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Device) in.readObject();
            in.close();
            fileIn.close();
            }while(in != null);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}
