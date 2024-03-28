package librarySystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

	private int memberNo;
	private String memberName;
	private String MemberId;
	private String MemberPw;
	private int lateFee;
	private String isLibrarian;
	
}
