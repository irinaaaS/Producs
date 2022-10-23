package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();


    Book book1 = new Book(1, "book1", 50, "Author1");
    Book book2 = new Book(2, "book2", 60, "Author2");
    Book book3 = new Book(3, "book3", 70, "Author3");


    @Test
    public void removeById() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        repo.removeById(3);
        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}