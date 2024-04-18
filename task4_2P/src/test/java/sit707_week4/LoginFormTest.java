package sit707_week4;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "S223693522";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Deelaka Rathnayake";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * More test functions 
	 */
	
	@Test
    public void testEmptyUsername() {
        LoginStatus status = LoginForm.login("", "xyz");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyPassword() {
        LoginStatus status = LoginForm.login("deelaka", "");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Empty Password", status.getErrorMsg());
    }
    
    @Test
    public void testWrongUsername() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testWrongPassword() {
        LoginStatus status = LoginForm.login("deelaka", "xyz");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testCorrectUsername() {
        LoginStatus status = LoginForm.login("deelaka", "wrong_pass");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testCorrectPassword() {
        LoginStatus status = LoginForm.login("deelaka", "deelaka_pass");
        assertEquals(false, status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testCorrectCredentials() {
        LoginStatus status = LoginForm.login("deelaka", "deelaka_pass");
        assertEquals(true, status.isLoginSuccess());
        assertEquals("123456", status.getErrorMsg());
    }
}
