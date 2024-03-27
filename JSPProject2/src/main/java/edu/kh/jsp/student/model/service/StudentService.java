package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dao.StudentDAO;
import  edu.kh.jsp.student.model.dto.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();

	
	/** 학생 전체 조회 서비스
	 * @return stdList
	 */
	public List<Student> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectAll(conn);
		
		//select 구문이니까 트랜젝션 처리 X
		close(conn);
		
		return stdList;
	}


	/** 건축공학과 학생 전체 조회 서비스
	 * @return stList
	 */
	public List<Student> selectArch() throws Exception{
		Connection conn = getConnection();
		
		List<Student> stList = dao.selectArch(conn);
		
		close(conn);
		return stList;
	}


	/** 입력한 과의 학생 조회 서비스
	 * @param deptName
	 * @return
	 */
	public List<Student> selectOne(String deptName) throws Exception{
		Connection conn = getConnection();
		List<Student> stdList = dao.selectOne(conn, deptName);
		
		close(conn);
		return stdList;
	}
	
	
	
	
	
	
	
}
