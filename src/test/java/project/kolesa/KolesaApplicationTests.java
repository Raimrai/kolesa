package project.kolesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.kolesa.dto.UserDto;
import project.kolesa.mapper.UserMapper;
import project.kolesa.model.User;

@SpringBootTest
class KolesaApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}
	@Test
	void testUserMapper(){
		UserDto userDto = new UserDto();
		userDto.setId(11L);
		userDto.setEmail("loko@mail.ru");
		userDto.setPassword("qwerty");
		userDto.setFullName("Loko");
		userDto.setPhoneNumber("87767854545");

		User user = userMapper.toEntity(userDto);

		Assertions.assertEquals(11L,user.getId());
		Assertions.assertEquals("loko@mail.ru",user.getEmail());
		Assertions.assertEquals("qwerty",user.getPassword());
		Assertions.assertEquals("Loko",user.getFullName());
		Assertions.assertEquals("87767854545",user.getPhoneNumber());
	}


}
