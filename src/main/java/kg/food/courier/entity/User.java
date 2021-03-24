package kg.food.courier.entity;


import kg.food.courier.enums.Role;
import kg.food.courier.enums.StatusList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic", nullable = true)
    private String patronymic;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private StatusList status = StatusList.ACTIVE;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "role")
    private Role role;

}
