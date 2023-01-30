package project.kolesa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "color")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Color extends BaseEntity{
    @Column(name = "color")
    private String color;
}
