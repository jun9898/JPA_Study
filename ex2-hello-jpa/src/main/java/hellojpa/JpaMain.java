package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = new Member();
            member.setUsername("member");
            member.setHomeAddress(new Address("test1","test2","test3"));

            member.getFavoriteFoodss().add("치킨");
            member.getFavoriteFoodss().add("피자");
            member.getFavoriteFoodss().add("햄버거");
            member.getFavoriteFoodss().add("먹고싶다");

            member.getAddressHistory().add(new Address("old1","test2","test3"));
            member.getAddressHistory().add(new Address("old2","test2","test3"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("==================start====================");
            Member findMember = em.find(Member.class, member.getId());

            findMember.setHomeAddress(new Address("update1","update1","update1"));
            findMember.getFavoriteFoodss().remove("치킨");
            findMember.getFavoriteFoodss().add("오므라이스");

            findMember.getAddressHistory().remove(new Address("old1","test2","test3"));


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
