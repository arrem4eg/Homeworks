package homework11;

import java.util.ArrayList;
import java.util.List;

public class LibraryFunc implements Func {

    private final List<Library> libList = new ArrayList<>();

    public void getAllItemsInfo() {
        for (Library lib : libList) {
            System.out.println(lib.printItemInfo());
        }
    }

    @Override
    public void takeItem(Library obj) {
        System.out.println("Material has been removed:");
        System.out.println(obj.printItemInfo());
        libList.remove(obj);

    }

    @Override
    public void giveItem(Library obj) {
        libList.add(obj);
    }

    @Override
    public void searchItem(String search) {

        int count = 0;
        for (Library lib : libList) {
            if (lib.getType().toLowerCase().contains(search.toLowerCase()) ||
                    lib.getAuthor().toLowerCase().contains(search.toLowerCase()) ||
                    lib.getTitle().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(lib.printItemInfo());
                count++;
            }
        }
        if (count == 0)
            System.out.println("There are no materials in the library");


    }
}
