package tw.idv.hunterchen.persistence.mapper;

import java.util.List;

import tw.idv.hunterchen.persistence.model.UserModel;

public interface UserMapper {
	public Integer insert(String name);
	public List<UserModel> selectAll();
	public UserModel selectOneById(Integer id);
}
