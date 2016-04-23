package to.my.code.board.status;

public enum BoardStatus {
	INSERT_SUCCESS("글쓰기에 성공했습니다."),
	INSERT_FAIL("글쓰기에 실패했습니다.")
	;
	
	private final String message;
	
	private BoardStatus(String message) {
		this.message = message;
	}
}
