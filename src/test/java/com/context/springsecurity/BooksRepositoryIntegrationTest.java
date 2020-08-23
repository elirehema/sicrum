package com.context.springsecurity;

import com.context.springsecurity.models.Books;
import com.context.springsecurity.models.ERole;
import com.context.springsecurity.models.Role;
import com.context.springsecurity.repository.BookRepository;
import com.context.springsecurity.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BooksRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByName_thenReturnBook() {
        //given
        Books book = new Books("Javascript for nerds", "hgd7213128","John Doe", "O`reilly");
        entityManager.persist(book);
        entityManager.flush();

        //when
        Optional<Books> found = bookRepository.findByName(book.getName());

        //then
        assertThat(found.get().getName())
                .isEqualTo(book.getName());

    }

}
