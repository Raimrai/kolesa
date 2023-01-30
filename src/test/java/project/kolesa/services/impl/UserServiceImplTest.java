package project.kolesa.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import project.kolesa.model.Ad;
import project.kolesa.model.User;
import project.kolesa.repository.AdRepository;
import project.kolesa.repository.UserRepository;
import project.kolesa.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Test
    void testMakeFavorite() {
        Long userId = 1L;
        Long adId = 5L;
        Ad ad = new Ad();
        ad.setId(adId);
        Set<Ad> ads  = new HashSet<>();
        ads.add(ad);
        User user = new User();
        user.setId(userId);
        user.setFavorites(ads);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(user, "password", List.of());
        SecurityContextHolder.getContext().setAuthentication(auth);

        userService.makeFavorite(ad);
        verify(userRepository, times(0)).save(user);
    }

    @Test
    void testUnableToMakeFavorite() {
        Long userId = 1L;
        Long adId = 5L;
        Ad ad = new Ad();
        Ad ad2 = new Ad();
        ad.setId(adId);
        Set<Ad> ads  = new HashSet<>();
        ads.add(ad);
        User user = new User();
        user.setId(userId);
        user.setFavorites(ads);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(user, "password", List.of());
        SecurityContextHolder.getContext().setAuthentication(auth);

        userService.makeFavorite(ad2);
        verify(userRepository, times(1)).save(user);
    }
}