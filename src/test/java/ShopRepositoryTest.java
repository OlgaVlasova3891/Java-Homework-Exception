import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldGetTitle() {

        Product product = new Product(11, "платье белое", 3_000);

        String expected = "платье белое";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetTitle() {
        Product product = new Product(11, "платье белое", 3_000);
        product.setTitle("платье красное");

        String expected = "платье красное";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPrice() {

        Product product = new Product(11, "платье белое", 3_000);

        int expected = 3_000;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrice() {

        Product product = new Product(11, "платье белое", 3_000);

        product.setPrice(3_700);

        int expected = 3_700;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "платье белое", 3_000);
        Product product2 = new Product(23, "жакет чёрный", 1_500);
        Product product3 = new Product(36, "шарф белый", 800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(36);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testThrowExceptionIfNoId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "платье белое", 3_000);
        Product product2 = new Product(23, "жакет чёрный", 1_500);
        Product product3 = new Product(36, "шарф белый", 800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(35));

    }
}



