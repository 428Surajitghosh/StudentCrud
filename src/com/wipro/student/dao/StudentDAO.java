package com.wipro.student.dao;
import com.wipro.student.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.student.bean.*;
public class StudentDAO {
	public String insert(StudentBean sb) throws SQLException
	{
		int roll=sb.getRoll();
		String name=sb.getName();
		String std=sb.getStd();
		String dob=sb.getDob();
		double fees=sb.getFees();
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement pst=conn.prepareStatement("INSERT INTO STUDENTREC(ROLLNO,STUDENTNAME,STANDARD,DATE_OF_BIRTH,FEES) VALUES(?,?,?,?,?)");
		pst.setInt(1,roll);
		pst.setString(2,name);
		pst.setString(3,std);
		pst.setString(4,dob);
		pst.setDouble(5,fees);
		int i=pst.executeUpdate();
		conn.close();
		if(i>0)
			return "success";
		else
			return "failed";
	}
	public String update(StudentBean sb) throws SQLException
	{
		int roll=sb.getRoll();
		String std=sb.getStd();
		double fees=sb.getFees();
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement pst=conn.prepareStatement("UPDATE STUDENTREC SET STANDARD=?,FEES=? WHERE ROLLNO=?");
		pst.setString(1,std);
		pst.setDouble(2,fees);
		pst.setInt(3,roll);
		int i=pst.executeUpdate();
		conn.close();
		if(i>0)
			return "success";
		else
			return "failed";
	}
	public String delete(StudentBean sb) throws SQLException
	{
		int roll=sb.getRoll();
		//System.out.println(""+roll);
		//String name=sb.getName();
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement pst=conn.prepareStatement("DELETE FROM STUDENTREC WHERE ROLLNO=?");
		pst.setInt(1,roll);
		//pst.setString(1,name);
		int i=pst.executeUpdate();
		conn.close();
		if(i>0)
			return "success";
		else
			return "failed";
	}
	public ArrayList<StudentBean> viewstu(StudentBean sb) throws SQLException
	{
		ArrayList<StudentBean> ar=new ArrayList<StudentBean>(); 
		int roll=sb.getRoll();
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement pst=conn.prepareStatement("SELECT * FROM STUDENTREC WHERE ROLLNO=?");
		pst.setInt(1,roll);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			StudentBean sb2=new StudentBean();
			int r=rs.getInt(1);
			String n=rs.getString(2);
			String s=rs.getString(3);
			String d=rs.getDate(4).toString();
			double f=rs.getDouble(5);
			sb2.setRoll(r);
			sb2.setName(n);
			sb2.setStd(s);
			sb2.setDob(d);
			sb2.setFees(f);
			ar.add(sb2);
		}
		conn.close();
		return ar;
	}
	public ArrayList<StudentBean> viewall(StudentBean sb) throws SQLException
	{
		ArrayList<StudentBean> ar=new ArrayList<StudentBean>();
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement pst=conn.prepareStatement("SELECT * FROM STUDENTREC");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			StudentBean sb2=new StudentBean();
			int r=rs.getInt(1);
			String n=rs.getString(2);
			String s=rs.getString(3);
			String d=rs.getDate(4).toString();
			double f=rs.getDouble(5);
			sb2.setRoll(r);
			sb2.setName(n);
			sb2.setStd(s);
			sb2.setDob(d);
			sb2.setFees(f);
			ar.add(sb2);
		}
		conn.close();
		return ar;
	}
}
