package tutocat.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Properties;


import static tutochat.common.JDBCTemplate.*;
import tutochat.member.model.dto.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;	
	
	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath = 
					MemberDAO.class.getResource("tutochat/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param id
	 * @param pw
	 * @return member
	 */
	public Member login(Connection conn, String id, String pw) throws Exception{
		Member loginMember = null;
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberName(rs.getString(2));
				loginMember.setMemberId(id);
				loginMember.setIsTeacher_YN(rs.getString(6));
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return loginMember;
	}

}
