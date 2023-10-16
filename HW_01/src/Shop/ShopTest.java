package Shop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShopTest {
    /*
    1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
    */

    // Проверьте, что количество продуктов в магазине соответствует ожидаемому количеству
    // Проверьте, что содержимое списка продуктов в магазине соответствует ожидаемому содержимому
    @Test
    public void testGetProducts() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 200));
        products.add(new Product("Product 2", 100));
        products.add(new Product("Product 3", 150));

        shop.setProducts(products);

        List<Product> actualProducts = shop.getProducts();
        assertEquals(products.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(products));
    }

    /*
    2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    */

    // Добавьте продукты с разными стоимостями в список
    // Проверьте, что метод возвращает продукт с наибольшей стоимостью
    @Test
    public void testGetMostExpensiveProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 200));
        products.add(new Product("Product 2", 100));
        products.add(new Product("Product 3", 150));

        shop.setProducts(products);

        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertEquals("Product 1", mostExpensiveProduct.getTitle());
        assertEquals(200, mostExpensiveProduct.getCost());
    }

    /*
    3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
    */

    // Добавьте продукты с разными стоимостями в список
    // Проверьте, что список продуктов отсортирован по возрастанию цены
    @Test
    public void testSortProductsByPrice() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 200));
        products.add(new Product("Product 2", 100));
        products.add(new Product("Product 3", 150));

        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertEquals(100,
                sortedProducts.get(0).getCost());
        assertEquals(150,
                sortedProducts.get(1).getCost());
        assertEquals(200,
                sortedProducts.get(2).getCost());
    }

}