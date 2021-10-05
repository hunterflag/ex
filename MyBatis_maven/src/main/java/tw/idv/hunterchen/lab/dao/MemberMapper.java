package tw.idv.hunterchen.lab.dao;

import tw.idv.hunterchen.lab.model.Member;

public interface MemberMapper {
	public Member selectById(Integer serialNo);
}
