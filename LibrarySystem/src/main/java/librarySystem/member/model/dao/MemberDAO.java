package librarySystem.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static librarySystem.common.JDBCTemplate.*;
import librarySystem.model.dto.Member;

public class MemberDAO {

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private Properties prop;
	public MemberDAO() {
		try {
			String filePath = MemberDAO.class.getResource("librarySystem/sql/member-sql.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return loginMember
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception{
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberName(rs.getString(2));
				loginMember.setMemberId(inputId);
				loginMember.setLateFee(rs.getInt(4));
				loginMember.setIsLibrarian(rs.getString(5));
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}
}
