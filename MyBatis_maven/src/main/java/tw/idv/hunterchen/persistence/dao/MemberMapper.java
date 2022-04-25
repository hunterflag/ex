package tw.idv.hunterchen.persistence.dao;

import tw.idv.hunterchen.persistence.model.Member;

public interface MemberMapper {
	public Member selectById(Integer serialNo);
}
