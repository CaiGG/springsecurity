package com.springsecurity;

import com.springsecurity.bean.User;
import com.springsecurity.dao.UserDao;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void selectUser(){
		User user = userDao.findByUserName("kkc");
		System.out.println(user.toString());
	}

	public void insertUser(){
		/*String s = Md5PasswordEncoder*/
	}


}
