package kg.food.courier.entity;

import kg.food.courier.enums.StatusList;
import kg.food.courier.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "identification")
public class Identification extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private StatusList status = StatusList.ACTIVE;






}
