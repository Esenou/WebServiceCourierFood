package kg.food.courier.model;


import kg.food.courier.enums.Role;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationManagerDto {
    private Long id;
    private Long organizationId;
    private String username;
    private String password;
    private Role role;
}