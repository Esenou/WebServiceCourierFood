package kg.food.courier.model;

import kg.food.courier.enums.ClientSex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientShortModel {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

}
