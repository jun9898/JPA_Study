package hellojpa.section4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MemberTest {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;

    // enumType
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date lastModifiedDate;
    @Lob
    private String description;
}
