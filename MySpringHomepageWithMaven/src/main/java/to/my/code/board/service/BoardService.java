package to.my.code.board.service;

import java.util.List;

import to.my.code.board.status.BoardStatus;
import to.my.code.board.vo.BoardVo;

public interface BoardService<T extends BoardVo> {
	public abstract BoardStatus write(final T t);
	public abstract BoardVo read(final Long no);
	public abstract List<T> listAll();
}
