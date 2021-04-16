package cc.zhou.provider;

import org.apache.ibatis.jdbc.SQL;

/**
* abner zjj
* 2021年4月2日 下午2:22:36
* 
* 
*/
public class PrivilegeProvider {
	
	public String selectById(Long id) {
		return new SQL() {
			{
				SELECT("id, privilege_name, privilege_url");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	public String selectById2(Long id) {
		return "select id, privilege_name, privilege_url from sys_privilege where id = #{id}";
	}

}
