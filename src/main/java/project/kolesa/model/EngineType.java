package project.kolesa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "engine_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EngineType extends BaseEntity{
    @Column(name = "engine_type")
    private String engineType;
}
