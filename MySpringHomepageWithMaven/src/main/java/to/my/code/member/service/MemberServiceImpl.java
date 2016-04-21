package to.my.code.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import to.my.code.member.dao.MemberDao;
import to.my.code.member.status.MemberStatus;
import to.my.code.member.vo.MemberVo;

public class MemberServiceImpl implements MemberService<MemberVo>{
	@Autowired
	MemberDao memberDao;
	
	@Override
	public MemberStatus join(MemberVo memberVo) {
		memberDao.insertOne(memberVo);
		
		return MemberStatus.INSERT_SUCCESS;
	}

	@Override
	public MemberStatus login(MemberVo memberVo) {
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
		
		memberVo.setBirth(memberVo2.getBirth());
		memberVo.setGender(memberVo2.getGender());
		memberVo.setName(memberVo2.getName());
		memberVo.setPhoneNumber(memberVo2.getPhoneNumber());
		memberVo.setRegDate(memberVo2.getRegDate());
		
		return MemberStatus.LOGIN_SUCCESS;
	}

}
