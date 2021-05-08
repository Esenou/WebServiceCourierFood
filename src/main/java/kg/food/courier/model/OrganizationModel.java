package kg.food.courier.model;


import kg.food.courier.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationModel {
    private String name;
    private String description;
    private String image;
    private int averageCheck;
    private Date workingHours;
    private String status;
    private User user;

}
