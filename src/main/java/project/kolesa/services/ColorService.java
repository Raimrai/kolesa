package project.kolesa.services;

import project.kolesa.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    Color getColor(Long id);
    Color adColor(Color color);
    Optional<Color> findColor(Long id);
    List<Color> getAllColor();
}
