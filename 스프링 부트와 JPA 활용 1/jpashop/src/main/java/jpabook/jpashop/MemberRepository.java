package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository {

	@PersistenceContext
	private EntityManager em;

	public Long save (Member member) {
		// 사이드 이펙트를 일으킬 수 있기 때문에 영속화된 객체는 리턴하지 않는다
		em.persist(member);
		return member.getId();
	}

	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}
