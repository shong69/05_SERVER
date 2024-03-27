package tutochat.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int memberNo; //회원 번호
	private String memberName; //회원 이름
	private String memberId; //회원 아이디
	private String memberPw; //회원 비밀번호
	private String memberMemo; //학생 특이사항 
	private String memberDeleteFlag; //회원 탈퇴 여부
	private String isTeacher_YN; //선생님 여부
}
