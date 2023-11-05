package hellojpa.section5;

public class JpaRelationTest {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try{
//
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, 1L);
//
//            Team team61 = findMember.getTeam();
//            System.out.println("team1.getName()========================================= " + team61.getName());
//            List<Member> memberList = team61.getMembers();
//            for (Member member5 : memberList) {
//                System.out.println("member5 = " + member5);
//            }
//
//
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
    }
}
