package cc.zhou.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cc.zhou.model.SysRole;
import cc.zhou.model.SysUser;

/**
* abner zjj
* 2021年3月31日 上午9:42:18
* 
* 
*/
public interface UserMapper {
	
	/**
	 * 通过 id 查询用户
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);
	
	/**
	 * 重新所有用户
	 * @return
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户 id 获取角色信息
	 * 
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long id);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int insert(SysUser user);
	
	/**
	 * 新增用户 - 使用 useGeneratedKeys 方式
	 * @param user
	 * @return
	 */
	int insert2(SysUser user);
	
	/**
	 * 新增用户 - 使用 selectKey 方式
	 * @param user
	 * @return
	 */
	int insert3(SysUser user);
	
	/**
	 * 根据主键更新
	 * @param user
	 * @return
	 */
	int updateById(SysUser user);
	
	/**
	 * 通过主键删除
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * 根据用户 id 和 角色的 enabled 状态获取用户的角色
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(Long userId, Integer enabled);
	//指定变量名
	//List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);
	
	/**
	 * 根据用户 id 和 角色的 enabled 状态获取用户的角色
	 * @param user
	 * @param role
	 * @return
	 */
	List<SysRole> selectRolesByUserAndRole(SysUser user,SysRole role);
	//List<SysRole> selectRolesByUserAndRole(@Param("user")SysUser user,@Param("role")SysRole role);

	/**
	 * 根据动态条件查询用户信息
	 * @param user
	 * @return
	 */
	List<SysUser> selectByUser(SysUser user);
	
	/**
	 * 根据主键更新
	 * @param user
	 * @return
	 */
	int updateByIdSelective(SysUser user);
	
	/**
	 * 根据用户 id 或用户名查询
	 * @param user
	 * @return
	 */
	List<SysUser> selectByIdOrUserName(SysUser user);
	
	/**
	 * 根据用户 id 集合查询
	 * @param ids
	 * @return
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	
	/**
	 * 批量插入用户信息
	 * @param userList
	 * @return
	 */
	int insertList(List<SysUser> userList);
	
	/**
	 * 通过 Map 更新列
	 * @param map
	 * @return
	 */
	int updateByMap(Map<String, Object> map);
	
	/**
	 * 根据用户 id 获取用户信息和用户的角色信息
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleById(Long id);
	
	/**
	 * 根据用户 id 获取用户信息和用户的角色信息
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleById2(Long id);
	
	/**
	 * 根据用户 id 获取用户信息和用户的角色信息，嵌套查询方式
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleByIdSelect(Long id);
	
	/**
	 * selectAllUserAndRoles
	 * @return
	 */
	List<SysUser> selectAllUserAndRoles();
	
	/**
	 * 使用存储过程查询用户信息
	 * @param user
	 */
	void selectUserById(SysUser user);
	
	/**
	 * 使用存储过程分页查询
	 * @param params
	 * @return
	 */
	List<SysUser> selectUserPage(Map<String, Object> params);
	
	/**
	 * 保存用户信息和角色关联信息
	 * @param user
	 * @param roleIds
	 * @return
	 */
	int insertUserAndRoles(@Param("user")SysUser user,@Param("roleIds")String roleIds);
	
	/**
	 * 根据用户 id 删除用户和用户的角色信息
	 * @param id
	 * @return
	 */
	int deleteUserById(Long id);
}
