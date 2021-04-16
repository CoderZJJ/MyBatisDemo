package cc.zhou.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import cc.zhou.model.SysPrivilege;

/**
* abner zjj
* 2021年4月2日 下午2:30:32
* 
* 
*/
public class PrivilegeMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			SysPrivilege privilege = privilegeMapper.selectById(1l);
			//user 不为空
			Assert.assertNotNull(privilege);
			//userName = admin
			Assert.assertEquals("用户管理", privilege.getPrivilegeName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectById2(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			SysPrivilege privilege = privilegeMapper.selectById2(1l);
			//user 不为空
			Assert.assertNotNull(privilege);
			//userName = admin
			System.out.println(privilege.getPrivilegeName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectPrivilegeByRoleId(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			List<SysPrivilege> list = privilegeMapper.selectPrivilegeByRoleId(1l);
			for (SysPrivilege sysPrivilege : list) {
				System.out.println(sysPrivilege.getPrivilegeName());
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
}
