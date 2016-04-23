package to.my.code.board.dao;

import java.util.List;

import to.my.code.common.dao.AbstractMyBatisDao;
import to.my.code.board.vo.BoardVo;

public class BoardDao extends AbstractMyBatisDao<BoardVo>{
	@Override
	public BoardVo insertOne(final BoardVo boardVo) {
		sqlsessionTemplate.insert("board.insertBoard", boardVo);
		
		return boardVo;
	}

	@Override
	public BoardVo selectOne(final BoardVo boardVo) {
		return sqlsessionTemplate.selectOne("board.selectBoard", boardVo.getNo());
	}

	@Override
	public List<BoardVo> selectListAll() {
		return sqlsessionTemplate.selectList("board.selectBoardListAll");
	}

	@Override
	public BoardVo updateOne(final BoardVo boardVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo deleteOne(final BoardVo boardVo) {
		// TODO Auto-generated method stub
		return null;
	}
}
