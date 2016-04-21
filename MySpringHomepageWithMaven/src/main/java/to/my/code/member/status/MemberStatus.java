package to.my.code.member.status;

public enum MemberStatus {
	INSERT_SUCCESS("회원가입에 성공했습니다."),
	INSERT_FAIL("회원가입에 실패했습니다."),
	LOGIN_SUCCESS("로그인에 성공했습니다."),
	LOGIN_FAIL("로그인에 실패했습니다.")
	;
	
	private final String message;
	
	private MemberStatus(String message) {
		this.message = message;
	}
}
