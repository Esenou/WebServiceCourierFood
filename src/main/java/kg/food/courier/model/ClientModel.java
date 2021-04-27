package kg.food.courier.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel extends ClientShortModel{
    private String phone;
    private String email;
    private String status;
    private String role;
}
