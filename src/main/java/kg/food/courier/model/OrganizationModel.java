package kg.food.courier.model;


import kg.food.courier.entity.Category;
import kg.food.courier.entity.Client;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationModel  {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String name;
    private String description;
    private String image;
    private int average_check;
    private Time from_time;
    private Time before_time;
    private boolean status;
    private Category category;

}
