package mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mbs.dto.MemberDto;
import com.mbs.service.MemberService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class mbstest {

	@Autowired
	MemberService service;
	
	@Test
	public void func1() throws Exception {
		service.joinObject(new MemberDto("s116","s116","col","01045"));
	}
	
	@Test
	public void func2() throws Exception{
		service.memberUpdate(new MemberDto("s116","ta13","최","01025887"));
	}
	

}
