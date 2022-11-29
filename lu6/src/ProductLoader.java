import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportData {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ProductLoader(){

    }
    public ProductLoader(File file){
        this.file = file;
    }

    private int getNumberOfRows() throws IOException {
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
        try {
            Object[] obj = new Object[getNumberOfRows()];
            BufferedReader bf = null;
            String line;
            int objCount = 0;
            bf = new BufferedReader(new FileReader("salesproducts.txt"));
            while ((line = bf.readLine()) != null) {
                char[] arr = new char[line.length()];
                String[] dataArr = new String[7];
                String data = "";
                int c = 0;
                for (int i = 2; i < line.length()-1; i++){
                    if(arr[i] != '#')
                        data+=arr[i];
                    else{
                        dataArr[c] = data;
                        c++;
                        data = "";
                    }
                }
                if(arr[0] == '1'){
                    Electronics electronic = new Electronics();
                    electronic.provider.name = dataArr[0];
                    electronic.provider.phoneNumber = dataArr[1];
                    electronic.inventoryNumber = dataArr[2];
                    electronic.price = Double.parseDouble(dataArr[3]);
                    electronic.quantity = Integer.parseInt(dataArr[4]);
                    electronic.model = dataArr[5];
                    electronic.manufacturer = dataArr[6];
                    obj[objCount] = electronic;
                }
                else{
                    Book book = new Book();
                    book.provider.name = dataArr[0];
                    book.provider.phoneNumber = dataArr[1];
                    book.inventoryNumber = dataArr[2];
                    book.price = Double.parseDouble(dataArr[3]);
                    book.quantity = Integer.parseInt(dataArr[4]);
                    book.author = dataArr[5];
                    book.title = dataArr[6];
                    obj[objCount] = book;
                }
            }
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0];
    }
}
