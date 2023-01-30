package project.kolesa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gearbox")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gearbox extends BaseEntity{
    @Column(name = "gearbox")
    private String gearbox;
}
