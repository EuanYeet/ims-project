package com.qa.ims.utils;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

public class DBUtilsTest {
	
	@Mock private DBUtils dbutils;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@Before
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	  }
	 
	  @Test
	  public void testMockDBConnection() throws Exception {
	    Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
	    Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
	    Connection value = dbutils.getConnection();
	    Assert.assertEquals(value, "jdbc:mysql://localhost:3306/ims", "root" , "root");
	    Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
	  }

}
