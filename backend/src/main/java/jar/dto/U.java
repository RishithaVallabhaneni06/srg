package jar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class U {

    @Size(min = 2, max = 100)
    public String name;

    @Email
    public String email;

    @Size(min = 6, max = 100)
    public String password;
}
