package kg.food.courier.entity;

import kg.food.courier.enums.Role;
import kg.food.courier.enums.StatusList;
import lombok.*;

import kg.food.courier.enums.StatusList;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_identification")
    private  Identification identification;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private StatusList status = StatusList.ACTIVE;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "role")
    private Role role;

}
