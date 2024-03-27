package tutochat.model.service;

import java.sql.Connection;

import tutocat.model.dao.MemberDAO;
import tutochat.common.JDBCTemplate;
import tutochat.member.model.dto.Member;

public class TutochatService {

	MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param id
	 * @param pw
	 * @return member
	 * @throws Exception 
	 */
	public Member login(String id, String pw) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		Member loginMember = dao.login(conn, id, pw);
		return loginMember;
	}
	
	
	
}
