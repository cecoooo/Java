public class Test {
    public static void main(String[] args) {
        BlackFriday blackFriday = new BlackFriday();
        blackFriday.processSales();
        for (int i = 0; i < blackFriday.electronicsArray.length; i++){
            System.out.println(blackFriday.electronicsArray[i].getModel());
        }
        for (int i = 0; i < blackFriday.booksArray.length; i++){
            System.out.println(blackFriday.booksArray[i].getAuthor());
        }
    }
}