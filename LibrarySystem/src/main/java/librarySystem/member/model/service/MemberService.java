package librarySystem.member.model.service;

import java.sql.Connection;

import static librarySystem.common.JDBCTemplate.*;
import librarySystem.member.model.dao.MemberDAO;
import librarySystem.model.dto.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return loginMember
	 */
	public Member login(String inputId, String inputPw) throws Exception {
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return loginMember;
	}
	
}
