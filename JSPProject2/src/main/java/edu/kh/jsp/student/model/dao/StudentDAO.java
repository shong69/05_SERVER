package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dto.Student;

public class StudentDAO {

	//JDBC 객체 저장용 참조변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public StudentDAO() {
		try {
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 학생 전체 조회 DAO
	 * @param conn
	 * @return stdList
	 */
	public List<Student> selectAll(Connection conn) throws Exception{
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();  
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student st = new Student(studentNo, studentName, studentAddress, departmentName);
				stdList.add(st);
			}
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		return stdList;
	}
	
	

	/** 건축학과 학생 리스트 조회 DAO
	 * @param conn
	 * @return stList
	 */
	public List<Student> selectArch(Connection conn) throws Exception{
		
		List<Student> stList=new ArrayList<>();
		try {
			String sql = prop.getProperty("selectArch");
			
			String major = "건축공학과";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, major);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String studentNo=rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAdd=rs.getString("STUDENT_ADDRESS");
				
				Student st = new Student(studentNo, studentName, studentAdd, major);
				
				stList.add(st);
			}

		}finally {
			close(rs);
			close(pstmt);
			
		}

		return stList;
	}

	/** 입력한 학과의 학생 리스트 조회 dao
	 * @param conn
	 * @param deptName
	 * @return stdList
	 */
	public List<Student> selectOne(Connection conn, String deptName) throws Exception{
		List<Student> stdList = new ArrayList<>();
		try {
			
			String sql = prop.getProperty("selectOne");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptName);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String studentNo=rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAdd=rs.getString("STUDENT_ADDRESS");
				
				Student st = new Student(studentNo, studentName, studentAdd, deptName);
				
				stdList.add(st);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);		
		}

		return stdList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
