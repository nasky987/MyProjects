package to.my.code.member.dao;

import java.util.List;

import to.my.code.member.vo.MemberVo;

public class MemberDao extends AbstractMyBatisMemberDao<MemberVo>{
	@Override
	public MemberVo insertOne(final MemberVo memberVo) {
		sqlsessionTemplate.insert("insertMember", memberVo);
		
		return memberVo;
	}

	@Override
	public MemberVo selectOne(final MemberVo memberVo) {
		return sqlsessionTemplate.selectOne("selectMember", memberVo);
	}

	@Override
	public List<MemberVo> selectListAll() {
		return sqlsessionTemplate.selectList("selectMemberListAll");
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
