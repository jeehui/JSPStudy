package test1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.StaffDTO;
import repository.StaffDAO;

public class StaffTest {
	
	void 등록테스트() {
		
		StaffDTO staff = StaffDTO.builder()
				.sno("99999")
				.name("김기획")
				.dept("기획부")
				.salary((long) 5000)
				.build();
	
	int res = 0;
	try {
		res = StaffDAO.getInstance().insertStaff(staff);
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	assertEquals(1, res, "사원 등록 실패");
	
	}
	
	@Test
	void 조회테스트() {
		StaffDTO staff = StaffDAO.getInstance().selectStaffByNo("99999");
		assertNotNull(staff);
	}
	
	
}
