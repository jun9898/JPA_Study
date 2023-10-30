package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 커넥션 풀 열기
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            // 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // em 안의 영속성 컨텍스트에 속하게 되어 영속 상태가 된다
            System.out.println("====BEFORE=====");
            em.persist(member);
            // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            em.detach(member);
            System.out.println("====AFTER=====");
/*
            insert
            Member member = new Member();
            member.setId(2L);
            member.setName("hello2");

            em.persist(member);
*/
/*
            select
*/
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

/*
            테이블을 기준으로한것이 아닌 Member 객체를 대상으로 쿼리를 돌린다.
*/
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

/*
            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
*/

/*
            업데이트 같은 경우 한번 가져온 엔티티를 계속해서 관리한다.
            만약 해당 Entity가 변경되었다면 EntityManager가 자동으로 update 쿼리를 날려준다
*/
            findMember.setName("Hello JPA");

/*
            delete는 해당 객체를 고대로 넘기면 삭제된다
            em.remove(findMember);
*/

            // EntityManager가 작업을 완료하면 commit
            tx.commit();
        } catch (Exception e) {
            // insert를 실패하면 롤백해준다
            tx.rollback();
        } finally {
            // 성공 여부와 상관 없이 EntityManager를 닫아준다
            em.close();
        }
        // 전체 애플리케이션이 모두 종료되면 emf까지 닫아준다.
        // 하지만 이는 정석일뿐 웬만한건 스프링이 다 해준단다
        emf.close();
    }
}
