package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Date;


import java.util.Properties;

import javax.mail.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org",
	"abcdefghijgklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	
	private static final String TEST_EMAIL = "ab@bc.com";
	
	private static final String TEST_NAME = "John";
	
	private static final String TEST_HEADER_VALUE = "Success";

	private static final String EMPTY_STRING = "";


	
	
		
	/* Concrete Email Class for testing */
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTeest() throws Exception {
		
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		
	}
	
	/*
	 * Test addBcc(String email) function
	 */
	@Test
	public void testAddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
		
		}
	
	/*
	 * Test addCc(String email) function
	 */
	@Test
	public void testAddCc() throws Exception {
		
		email.addCc(TEST_EMAIL);
		
		assertEquals(1, email.getCcAddresses().size());
		
		}
	
	/*
	 * Test addHeader(String email, String value) function
	 */
	@Test
	public void testAddHeader() throws Exception {
		
		email.addHeader(TEST_NAME, TEST_HEADER_VALUE);
		email.addHeader(EMPTY_STRING, EMPTY_STRING);
		
		}
	
	/*
	 * Test addReplyTo(String email, String value) function
	 */
	@Test
	public void testAddReplyTo() throws Exception {
		
		email.addReplyTo(TEST_EMAIL, TEST_NAME);		
		}
	
	/*
	 * Test buildMimeMessage() function
	 */
	@Test
	public void testBuildMimeMessage() throws Exception {
		
		email.buildMimeMessage();		
		}
	
	/*
	 * Test getHostName() function
	 */
	@Test
    public void testGetHostName() {
		email.getHostName();
        // test case when hostName is set
        email.setHostName("123@456.com");
        assertEquals("123@456.com", email.getHostName());
        
        // test case when both session and hostName are null or empty
        email.setMailSession(null);
        email.setHostName("");
        assertNull(email.getHostName());
    }
	
	
	/*
	 * Test getMailSession() function
	 */
	@Test
    public void testGetMailSession() throws EmailException {
		email.getMailSession();
     
    }
	
	
	/*
	 * Test getSentDate() function
	 */
	@Test
    public void testGetSentDate() {
        // test case when sentDate is null
        assertNotNull(email.getSentDate());
        
        // test case when sentDate is set
        Date sentDate = new Date();
        email.setSentDate(sentDate);
        assertEquals(sentDate, email.getSentDate());
        
        // test case when sentDate is modified after setting
        sentDate.setTime(sentDate.getTime() - 1000);
        assertNotEquals(sentDate, email.getSentDate());
    }
	
	
	/*
	 * Test getSocketConnectionTimeout() function
	 */
	@Test
    public void testGetSocketConnectionTimeout() {
		email.getSocketConnectionTimeout();
    }
	
	
	
	/*
	 * Test setFrom(String email) function
	 */
	@Test
    public void testSetFrom() throws EmailException {
		email.setFrom(TEST_EMAIL);
    }

}
