package homework21;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {

    private static final SelenideElement cartLink = $(".shopping_cart_link");
    private static final ElementsCollection priceElement = $$(".inventory_item_price");
    private static final ElementsCollection addToCartButton = $$x("//*[text()='Add to cart']");

    private static Double maxPrice;

    public InventoryPage buyItemMaxPrice() {

        List<SelenideElement> price = new ArrayList<>();
        for (SelenideElement element : priceElement) {
            price.add(element);
        }
        maxPrice = price.stream().map(x -> x.getText().replaceAll("\\$", ""))
                .map(Double::parseDouble).max(Comparator.comparing(Double::valueOf)).get();

        for (int i = 0; i < price.size(); i++) {
            if (price.get(i).getText().equals("$" + maxPrice)) {
                addToCartButton.get(i).click();
            }
        }
        return this;
    }

    public CartPage openCartPage() {
        cartLink.click();
        return new CartPage();
    }
}
