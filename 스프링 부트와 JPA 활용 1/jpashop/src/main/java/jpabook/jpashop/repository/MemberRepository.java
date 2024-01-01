package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.jpashop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	// select m from Member m where m.name = ? 이런 쿼리를 자동으로 생성해준다.
	// spring data jpa는 스프링과 JPA를 화룡ㅇ해서 애플리케이션을 만들때 정말 편리한 기능을 많이 제공한다.
	// 하지만 결국 JPA를 사용해서 이런 기능ㅇ을 제공할 뿐이니 JPA 자체의 이해도를 높혀야 한다.
	List<Member> findByName(String name);

}