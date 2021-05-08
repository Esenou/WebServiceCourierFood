package kg.food.courier.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.food.courier.enums.StatusList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
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

    @Column(name = "from_time")
    private Time from_time;

    @Column(name = "before_time")
    private Time before_time;

    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;



}
