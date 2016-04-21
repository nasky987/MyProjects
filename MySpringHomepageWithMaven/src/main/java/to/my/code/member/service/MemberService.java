package to.my.code.member.service;

import to.my.code.member.status.MemberStatus;
import to.my.code.member.vo.MemberVo;

public interface MemberService<T extends MemberVo> {
	public abstract MemberStatus join(final T t);
	public abstract MemberStatus login(final T t);
}
