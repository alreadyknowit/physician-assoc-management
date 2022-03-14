package JUnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import program.DbConnection;

public class DatabaseTest {
	DbConnection db = new DbConnection();
	Connection conn=null;
	PreparedStatement ps;
	@Test
	public void testConnection() {
	
		conn=DbConnection.connect();
		assertEquals("org.sqlite.SQLiteConnection@402f32ff", conn.toString());
	}

}
