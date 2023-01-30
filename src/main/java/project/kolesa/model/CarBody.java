package project.kolesa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_body")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarBody extends BaseEntity{
    @Column(name = "car_body")
    private String carBody;
}
