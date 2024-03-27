package edu.kh.todoList.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString  
@Getter
@Setter
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드에 대한 매개변수 생성자
public class Member {

	//lombok 라이브러리 : getter/setter, 생성자, toString() 자동완성 라이브러리
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String enrollDate;
	private String memberDeleteFlag;
	
}
