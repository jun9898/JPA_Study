package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        book.setName("변경 테스트");


    }
}
