package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "book1", 50, "Author1");
    Book book2 = new Book(2, "book2", 60, "Author2");
    Book book3 = new Book(3, "book3", 70, "Author3");
    Smartphone smartphone1 = new Smartphone(1, "smartphone", 1000, "nokia");

    @Test
    public void addingBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("journal");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchDifferentProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }


}