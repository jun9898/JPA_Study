package study.datajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.datajpa.entity.TestEntity;

@Transactional
@SpringBootTest
public class EntityTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void entityTest() {

        TestEntity testEntity = new TestEntity();
        // 변경된부분 ====================================
        testEntity.setTestId(5L);
        // 변경된부분 ====================================
        System.out.println("testEntity.getTestId() = " + testEntity.getTestId());
        em.merge(testEntity);
    }
}
