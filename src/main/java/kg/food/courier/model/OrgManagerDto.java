package kg.food.courier.model;

import kg.food.courier.enums.StatusList;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrgManagerDto {
    private Long id;
    private String username;
    private String password;
    private String status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
