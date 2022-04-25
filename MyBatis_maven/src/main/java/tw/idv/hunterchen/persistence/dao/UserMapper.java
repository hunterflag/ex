package tw.idv.hunterchen.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tw.idv.hunterchen.persistence.model.User;

public interface UserMapper {
	@Select(value="select * freo user")
	public static List<User> getAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User selectOneById(Integer id);
	
	@Select("SELECT * FROM user WHERE name = #{name} LIMIT 0, 1")
	public User selectOneByName(String name);
	
	@Insert("INSERT INTO user (name) values (#{name})")
	public Integer insert(String name);
	
	@Update("UPDATE user SET name=#{name} WHERE id=#{id}")
	public Integer update(@Param("name") String name, @Param("id") Integer id);
}
