package com.pratice.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String address;
    private String city;

}
