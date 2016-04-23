package to.my.code.member.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import to.my.code.common.dao.GenericDao;
import to.my.code.member.dao.MemberDao;
import to.my.code.member.status.MemberStatus;
import to.my.code.member.vo.MemberVo;

public class MemberServiceImpl implements MemberService<MemberVo>{
	@Autowired
	GenericDao<MemberVo> memberDao;
	
	@Override
	public MemberStatus join(final MemberVo memberVo) {
		memberDao.insertOne(memberVo);
		
		return MemberStatus.INSERT_SUCCESS;
	}

	@Override
	public MemberStatus login(final MemberVo memberVo) {
		MemberVo memberVo2 = memberDao.selectOne(memberVo);
		
		if(null == memberVo2) {
			return MemberStatus.LOGIN_FAIL;
		}
		
		if(!memberVo.getEmail().equals(memberVo2.getEmail())) {
			return MemberStatus.LOGIN_FAIL;
		}
		
		if(!memberVo.getPassword().equals(memberVo2.getPassword())) {
			return MemberStatus.LOGIN_FAIL;
		}
		((MemberDao) memberDao).updateLoginTime(memberVo2);
		
		memberVo.setNo(memberVo2.getNo());
		memberVo.setBirth(memberVo2.getBirth());
		memberVo.setGender(memberVo2.getGender());
		memberVo.setName(memberVo2.getName());
		memberVo.setPhoneNumber(memberVo2.getPhoneNumber());
		memberVo.setRegDate(memberVo2.getRegDate());
		memberVo.setLoginDate(new Date());
		
		return MemberStatus.LOGIN_SUCCESS;
	}

	@Override
	public List<MemberVo> listAll() {
		List<MemberVo> members = memberDao.selectListAll();
		
		if(null == members) {
			return new ArrayList<MemberVo>();
		}
		
		return members;
	}
	
	public GenericDao<MemberVo> getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(GenericDao<MemberVo> memberDao) {
		this.memberDao = memberDao;
	}
}
