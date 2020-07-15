package com.wipro.student.main;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.student.bean.*;
import com.wipro.student.dao.*;
public class StudentApp {
	public String insert(int r,String n,String s,String d,double f) throws SQLException
	{
		StudentBean sb=new StudentBean();
		sb.setRoll(r);
		sb.setName(n);
		sb.setStd(s);
		sb.setDob(d);
		sb.setFees(f);
		StudentDAO sd=new StudentDAO();
		String status=sd.insert(sb);
		if(status.equals("success"))
			return "inserted successfully";
		else
			return "insertion failed";
	}
	public String update(int r,String s,double f) throws SQLException
	{
		StudentBean sb=new StudentBean();
		sb.setRoll(r);
		sb.setStd(s);
		sb.setFees(f);
		StudentDAO sd=new StudentDAO();
		String status=sd.update(sb);
		if(status.equals("success"))
			return "Updated successfully";
		else
			return "Update failed";
	}
	public String delete(int r) throws SQLException
	{
		StudentBean sb=new StudentBean();
		sb.setRoll(r);
		//sb.setName(n);
		StudentDAO sd=new StudentDAO();
		String status=sd.delete(sb);
		if(status.equals("success"))
			return "Deleted successfully";
		else
			return "Delete failed";
	}
	public ArrayList<StudentBean> viewstu(int r) throws SQLException{
		StudentBean sb=new StudentBean();
		sb.setRoll(r);
		ArrayList<StudentBean> ar=new ArrayList<StudentBean>();
		StudentDAO sd=new StudentDAO();
		ar=sd.viewstu(sb);
		return ar;
	}
	public ArrayList<StudentBean> viewall() throws SQLException
	{
		StudentBean sb=new StudentBean();
		ArrayList<StudentBean> ar=new ArrayList<StudentBean>();
		StudentDAO sd=new StudentDAO();
		ar=sd.viewall(sb);
		return ar;
	}
}
