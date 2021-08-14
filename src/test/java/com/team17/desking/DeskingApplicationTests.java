package com.team17.desking;

import com.team17.desking.controllers.DeskingControl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DeskingApplicationTests {
	@Autowired
	private DeskingControl deskingControl;

	@Test
	public void contextLoads() throws Exception {
		assertThat(deskingControl).isNotNull();
	}


}
