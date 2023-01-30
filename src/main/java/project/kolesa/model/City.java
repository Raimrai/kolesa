package project.kolesa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends BaseEntity{
    @Column(name = "city")
    private String city;
}
