package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeExistingProduct() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Булка", 50);
        Product product2 = new Product(2, "Кофе", 300);
        Product product3 = new Product(3, "Диван", 20000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistingProduct() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Булка", 50);
        Product product2 = new Product(2, "Кофе", 300);
        Product product3 = new Product(3, "Диван", 20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });

    }






}