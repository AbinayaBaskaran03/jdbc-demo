package com.ebrain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionUtil {
	
  public static Connection getconnection() throws ClassNotFoundException, SQLException {
	  
     Class.forName("com.mysql.jdbc.Driver");	
Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/dbms_april_2023","dbms_april_2023","Ebrain@20");
return connection;
	}
  
public static void saveAbi(Integer id,String user_name,String first_name,String last_name,String mobile_no) throws ClassNotFoundException, SQLException {
	
	Connection connection = getconnection();
	
	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_abi(id,user_name,first_name,last_name,mobile_no)VALUES (?,?,?,?,?)")	;

	preparedStatement.setInt(1,id);
	preparedStatement.setString(2,user_name);
	preparedStatement.setString(3,first_name);
	preparedStatement.setString(4,last_name);
	preparedStatement.setString(5 ,mobile_no);
	preparedStatement.executeUpdate();//}insert and update 
}
//public  ( void)  getAllvalue() throws ClassNotFoundException, SQLException {

public static List<AbiData>  getAllvalue(String name) throws ClassNotFoundException, SQLException {
	Connection connection = getconnection();
	
	String query = "SELECT id,user_name,first_name,last_name,mobile_no FROM tb_abi ";
	
	if(query !=name) {
		query = query + "WHERE first_name LIKE '%"+name+"%'";
	}
//PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,user_name,first_name,last_name,mobile_no FROM tb_abi");
	
	PreparedStatement preparedStatement = connection.prepareStatement(query);//to print particular values using LIKE

	
    ResultSet resultSet = preparedStatement.executeQuery();
    
    List<AbiData> Data = new ArrayList<AbiData>();
    
while(resultSet.next()) {
	Integer id = resultSet.getInt(1);
	String username = resultSet.getString(2);
	String firstname = resultSet.getString(3);
	String lastname = resultSet.getString(4);
	String mobileno = resultSet.getString(5);
	
	AbiData abidataObj = new AbiData(id,username,firstname,lastname,mobileno);
	
	Data.add(abidataObj);
	
	   //System.out.println(id+": "+username+": "+firstname+": "+lastname+": "+mobileno);

  }
  return Data;
  }
     public static void main(String[] args)throws ClassNotFoundException, SQLException  {
	     // saveAbi(1013,"indra","ragavi","ramaiyan","2154546854");
    	 
    	  List<AbiData> Data = getAllvalue("in");
    	  
    	  for(AbiData abidataObj : Data) {
    		  
    		  System.out.println(abidataObj.toString());
    	  }
	 System.out.println("Executed successfully....."); 
	}

}
