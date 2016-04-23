package to.my.code.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import to.my.code.board.status.BoardStatus;
import to.my.code.board.vo.BoardVo;
import to.my.code.common.dao.GenericDao;

public class BoardServiceImpl implements BoardService<BoardVo>{
	@Autowired
	GenericDao<BoardVo> boardDao;
	
	@Override
	public BoardStatus write(BoardVo boardVo) {
		boardDao.insertOne(boardVo);
		
		return BoardStatus.INSERT_SUCCESS;
	}
	
	@Override
	public BoardVo read(Long no) {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(no);
		
		return boardDao.selectOne(boardVo);
	}
	
	@Override
	public List<BoardVo> listAll() {
		return boardDao.selectListAll();
	}

	public GenericDao<BoardVo> getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(GenericDao<BoardVo> boardDao) {
		this.boardDao = boardDao;
	}
}
