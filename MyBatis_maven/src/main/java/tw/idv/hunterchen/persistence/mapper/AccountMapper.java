package tw.idv.hunterchen.persistence.mapper;

import java.util.List;

import tw.idv.hunterchen.persistence.model.AccountModel;

public interface AccountMapper {
//	public void insert(String name, String pasword);
	public void insert(AccountModel accountModel);
	public List<AccountModel> selectAll();
	public AccountModel selectOneById(Integer id);
	public AccountModel selectOneByName(String name);
}
