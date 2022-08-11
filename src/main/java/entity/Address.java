package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private Integer ZIP;
    private String street;
    private String houseNumber;
    private String apartment;

    private Double coordinateGPSLongtitude;
    private Double coordinateGPSLatitude;


}
