package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id @GeneratedValue
	private Long id;
	@NotEmpty
	private String name;
	@Embedded
	private Address address;
	// 화면을 표시하기 위한 스펙은 엔티티에서 설정할 게 아니라 DTO로 따로 빼서 사용해야 한다
	// @JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<Order> orderList = new ArrayList<>();
}
