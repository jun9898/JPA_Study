package hellojpa.section3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // 커넥션 풀 열기
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            // 비영속 상태
/*
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
*/

            // em 안의 영속성 컨텍스트에 속하게 되어 영속 상태가 된다
/*
            System.out.println("====BEFORE=====");
            em.persist(member);
            System.out.println("====AFTER=====");
*/

//            em.find(Member.class, 101L);

            // 영속성 컨텍스트 내부 1차캐시를 먼저 select 한다
/*
            System.out.println("member.getId() = " + member.getId());
            System.out.println("member.getName() = " + member.getName());
*/
/*
            영속성 컨텍스트에 select 된 결과를 올려놓고
            Member member1 = em.find(Member.class, 101L);
            같은 작업이 반복될시 영속성 컨텍스트를 먼저 조회함으로 select 쿼리가 한번만 작동한다
            참고로 영속 엔티티는 동일성이 보장되므로 == 연잔자로 비교할 시 true를 반환한다.
            Member member2 = em.find(Member.class, 101L);
*/

            // insert문 같은 경우 커밋이 이루어질때 insert 쿼리를 작동시킨다
/*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(151L, "B");
            
            em.persist(member1);
            em.persist(member2);

            System.out.println("==========================================");
*/
            // update같은 경우 영속성 컨텍스트에 들어있는 객체를 수정해주고 커밋만 해줘도 update가 된다.
            // 영속 컨텍스트는 엔티티가 영속화 될때 최초 스냅샷을 남겨둔다.
            // 이후 커밋이 진행되어 flush 가 발동되면 해당 스냅샷과 현재 엔티티의 상태를 비교하는 Dirty Checking을 진행한다.
            // 만약 엔티티에 변경사항이 있다면 쓰기지연 sql 저장소에 update 쿼리를 저장하고 한번에 커밋한다.
            Member1 member1 = em.find(Member1.class, 150L);
            // 놀라운 기능
            member1.setName("zzz");

            if (member1.getName().equals("zzzz")){
                em.persist(member1);
            }


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
