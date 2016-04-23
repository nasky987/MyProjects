package to.my.code.member.dao;

import java.util.List;

import to.my.code.common.dao.AbstractMyBatisDao;
import to.my.code.member.vo.MemberVo;

public class MemberDao extends AbstractMyBatisDao<MemberVo>{
	@Override
	public MemberVo insertOne(final MemberVo memberVo) {
		sqlsessionTemplate.insert("member.insertMember", memberVo);
		
		return memberVo;
	}

	@Override
	public MemberVo selectOne(final MemberVo memberVo) {
		return sqlsessionTemplate.selectOne("member.selectMember", memberVo);
	}

	@Override
	public List<MemberVo> selectListAll() {
		return sqlsessionTemplate.selectList("member.selectMemberListAll");
	}

	public void updateLoginTime(final MemberVo memberVo) {
		sqlsessionTemplate.update("member.updateMemberLoginTime", memberVo);
	}
	
	@Override
	public MemberVo updateOne(final MemberVo memberVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo deleteOne(final MemberVo memberVo) {
		// TODO Auto-generated method stub
		return null;
	}
}
