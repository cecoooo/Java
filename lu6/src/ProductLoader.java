import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportData{
    File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private int getNumberOfRows() throws IOException{
        int rows = 0;
        BufferedReader bf = null;
        String line;
        bf = new BufferedReader(new FileReader("salesproducts.txt"));
        while ((line = bf.readLine()) != null)
            rows++;
        return rows;
    }

    @Override
    public Object[] importDataFromFile() throws IOException {
        try{
            Object[] obj = new Object[getNumberOfRows()];
            BufferedReader bf = null;
            String line;
            bf = new BufferedReader(new FileReader("salesproducts.txt"));
            while ((line = bf.readLine()) != null){
                char[] arr = new char[line.length()];
                if(arr[0] == '1'){
                    Electronics el = new Electronics();
                }
                else{
                    Book book = new Book();
                }
                String data = "";
                for (int i = 1; i < line.length(); i++){
                    if(arr[i] != '#'){
                        data += arr[i];
                    }
                    else{

                        data = "";
                    }
                }
            }
            return obj;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
