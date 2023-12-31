package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
