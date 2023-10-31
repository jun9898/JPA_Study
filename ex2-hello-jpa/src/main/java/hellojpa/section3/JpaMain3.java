package hellojpa.section3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
/*
        Member member = new Member(200L, "member200");
        em.persist(member);

        // entityManager의 flush 기능은 여태까지 캐시에 쌓인 작업을 sql로 만들어 db에 전송해준다
        // commit
        em.flush();
        System.out.println("==================================");
        // 커밋이 일어나기 전에 insert가 일어나서 ================= 상단에 insert 쿼리를 생성한다
        // flush를 실행한다고 해서 캐시를모두 비우지 않는다 캐시까지 같이 지워주고 싶다면 em.clear()로 캐시를 지워줘야 한다.
*/

            // find로 엔티티를 찾아오는 순간 영속화 된다
            Member1 member1 = em.find(Member1.class, 150L);
            member1.setName("AAAAAA");

            em.clear();

            Member1 member12 = em.find(Member1.class, 150L);
            // detach를 사용해 준영속화 시켜 컨텍스트에서 제외한다
//            em.detach(member);
            System.out.println("============================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
