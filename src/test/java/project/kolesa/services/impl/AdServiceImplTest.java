package project.kolesa.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.kolesa.dto.AdDto;
import project.kolesa.model.Ad;
import project.kolesa.model.User;
import project.kolesa.repository.AdRepository;
import project.kolesa.services.AdService;
import project.kolesa.services.UserService;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdServiceImplTest {

    @Mock
    AdRepository adRepository;
    @Mock
    UserService userService;
    @InjectMocks
    AdService adService = new AdServiceImpl();

    @Captor
    ArgumentCaptor<Ad> adArgumentCaptor;

    @Test
    void testUpdateAd() {
        Long adId = 1L;
        Ad ad = new Ad();
        ad.setId(adId);
        AdDto adDto = new AdDto();
        adDto.setMileage(100);
        User user = new User();
        user.setId(1L);

        when(adRepository.findById(adId)).thenReturn(of(ad));
        when(userService.getCurrentUser()).thenReturn(user);

        adService.updateAd(adDto, adId);
        verify(adRepository).save(adArgumentCaptor.capture());

        verify(adRepository, times(1)).save(ad);
        Ad capturedArgument = adArgumentCaptor.getValue();
        assertEquals(capturedArgument.getMileage(), adDto.getMileage());
        assertEquals(capturedArgument.getAuthor().getId(), user.getId());
    }
}