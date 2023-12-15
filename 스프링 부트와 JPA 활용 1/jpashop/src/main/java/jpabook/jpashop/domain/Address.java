package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // jpa에서 프록시를 생성할때 기본 생성자가 있어야 한다
    // 이를 해결하기 위해 기본 생성자를 protected 로 설정
    protected Address() {
    }
}
