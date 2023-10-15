package homework11;

import org.testng.annotations.Test;

public class LibraryTest {


    LibraryFunc libraryFunc = new LibraryFunc();

    Library book1 = new Book("A Song of Ice and Fire", "George R. R. Martin", Genre.FANTASY, "Book");
    Library audioBook = new AudioBook("Treasure Island", "Robert Louis Stevenson", Genre.ADVENTURE, "Audio Book");
    Library magazine = new Magazine("Der Spiegel", "SPIEGEL-Verlag", "Magazine");


    @Test
    public void addingMaterialsToLibrary() {

        //повернення матеріалів
        System.out.println("\n############## Test1 adding Materials ############");
        libraryFunc.giveItem(book1);
        libraryFunc.giveItem(audioBook);
        libraryFunc.giveItem(magazine);

        libraryFunc.getAllItemsInfo();
    }

    @Test
    public void removalOfMaterialsFromLibrary() {
        //видачі матеріалів

        System.out.println("\n############## Test2 removal Of Materials ############");

        libraryFunc.takeItem(book1);

    }

    @Test
    public void searchingForMaterialsInLibrary() {
        //пошуку матеріалів
        System.out.println("\n############# Test3 search #############");

        libraryFunc.searchItem("Stevenson");
        libraryFunc.searchItem("Spiegel");
        libraryFunc.searchItem("West");


    }

}
