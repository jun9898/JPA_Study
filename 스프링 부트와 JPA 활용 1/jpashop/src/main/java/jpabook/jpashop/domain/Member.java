package jpabook.jpashop.domain;

import jakarta.persistence.*;
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
	private String name;
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "member")
	private List<Order> orderList = new ArrayList<>();
}
