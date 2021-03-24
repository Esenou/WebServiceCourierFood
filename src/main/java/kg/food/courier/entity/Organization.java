package kg.food.courier.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.food.courier.enums.StatusList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name ="oragnization")
public class Organization extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "average_check")
    private int average_check;

    @Column(name = "working_hours", nullable = false)
    private Date working_hours;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private StatusList status = StatusList.ACTIVE;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_admin")
    private User user;
}
