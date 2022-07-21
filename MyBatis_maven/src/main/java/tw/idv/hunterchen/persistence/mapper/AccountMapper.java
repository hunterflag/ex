package tw.idv.hunterchen.persistence.mapper;

import java.util.List;

import tw.idv.hunterchen.persistence.model.AccountModel;

public interface AccountMapper {
	public Integer insert(String name, String password);
	public Integer insertWithDefaultPassword(String name);	// 預設密碼與帳號相同 (大小寫不同)
	
	public Boolean deleteByName(String name);
	public Boolean deleteById(String name);
	
	public Boolean updatePassword(String name, String newPassword);
	public Boolean updatePassword(String name, String oldPassword, String newPassword);
	
	public List<AccountModel> selectAll();
	public AccountModel selectOneById(Integer id);
	public AccountModel selectOneByName(String name);
}
