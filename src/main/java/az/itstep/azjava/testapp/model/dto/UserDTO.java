package az.itstep.azjava.testapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    private Integer id;

    private String username;

    private String firstname;

    private String lastname;

    private String phoneNumber;
}
