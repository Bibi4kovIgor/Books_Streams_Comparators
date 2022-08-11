package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Publisher {
    String id;
    String name;
    Address address;
    String phone;


}
