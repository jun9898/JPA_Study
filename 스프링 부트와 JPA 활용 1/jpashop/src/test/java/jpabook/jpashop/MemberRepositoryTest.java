package jpabook.jpashop;

import static org.assertj.core.api.Assertions.*;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;

	@Test
	@Rollback(false)
	public void testMember() throws Exception {
	    //given
		Member member = new Member();
		member.setUsername("memberA");

		//when
		Long saveId = repository.save(member);
		Member findMember = repository.find(saveId);

	    //then
		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		// 영속성 컨텍스트안에 member가 들어가있기 때문에 true가 출력된다
		assertThat(findMember).isEqualTo(member);

	}


}