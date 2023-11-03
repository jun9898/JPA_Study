package hellojpa.section5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaRelationTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member5 member = new Member5();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member5 findMember5 = em.find(Member5.class, 1L);

            Team team1 = findMember5.getTeam();
            System.out.println("team1.getName()========================================= " + team1.getName());
            List<Member5> member5List = team1.getMembers();
            for (Member5 member5 : member5List) {
                System.out.println("member5 = " + member5);
            }



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
