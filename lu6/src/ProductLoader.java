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
        bf = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\PushToGithub\\java\\lu6\\src\\salesproducts.txt"));
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
            bf = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\PushToGithub\\java\\lu6\\src\\salesproducts.txt"));
            while ((line = bf.readLine()) != null) {
                StringBuffer[] dataArr = new StringBuffer[7];
                StringBuffer data = new StringBuffer();
                int c = 0;
                for (int i = 2; i < line.length(); i++){
                    if(line.charAt(i) != '#')
                        data.append(line.charAt(i));
                    else{
                        dataArr[c] = data;
                        data = new StringBuffer();
                        c++;
                    }
                }
                if(line.charAt(0) == '1'){
                    Electronics electronic = new Electronics();
                    Provider provider = new Provider();
                    provider.setName(dataArr[0].toString());
                    provider.setPhoneNumber(dataArr[1].toString());
                    electronic.setProvider(provider);
                    electronic.setInventoryNumber(dataArr[2].toString());
                    electronic.setPrice(Double.parseDouble(dataArr[3].toString()));
                    electronic.setQuantity(Integer.parseInt(dataArr[4].toString()));
                    electronic.setModel(dataArr[5].toString());
                    electronic.setManufacturer(dataArr[6].toString());
                    obj[objCount] = electronic;
                    objCount++;
                }
                else{
                    Book book = new Book();
                    Provider provider = new Provider();
                    provider.setName(dataArr[0].toString());
                    provider.setPhoneNumber(dataArr[1].toString());
                    book.setProvider(provider);
                    book.setInventoryNumber(dataArr[2].toString());
                    book.setPrice(Double.parseDouble(dataArr[3].toString()));
                    book.setQuantity(Integer.parseInt(dataArr[4].toString()));
                    book.setAuthor(dataArr[5].toString());
                    book.setTitle(dataArr[6].toString());
                    obj[objCount] = book;
                    objCount++;
                }
            }
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
