package org.book.store.repository;

import org.book.store.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@TestPropertySource(locations = "classpath:test.properties")
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void simpleTest() {
        Book book = new Book();
        book.setAuthor("Some Author");
        book.setName("Name of the book");
        book.setYear(1995);

        Book bookAfterSave = bookRepository.save(book);

        assertNotNull(bookAfterSave.getId());
    }

}