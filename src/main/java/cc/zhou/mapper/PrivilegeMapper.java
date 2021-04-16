package cc.zhou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import cc.zhou.model.SysPrivilege;
import cc.zhou.provider.PrivilegeProvider;

/**
* abner zjj
* 2021年4月2日 上午11:33:47
* 
* 
*/
public interface PrivilegeMapper {
	
	@SelectProvider(type = PrivilegeProvider.class,method = "selectById")
	SysPrivilege selectById(Long id);
	
	@SelectProvider(type = PrivilegeProvider.class,method = "selectById2")
	SysPrivilege selectById2(Long id);
	
	/**
	 * 角色id查询权限
	 * @param roleId
	 * @return
	 */
	List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
