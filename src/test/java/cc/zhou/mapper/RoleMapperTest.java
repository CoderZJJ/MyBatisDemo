package cc.zhou.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import cc.zhou.model.SysRole;

/**
* abner zjj
* 2021年4月2日 上午11:08:10
* 
* 
*/
public class RoleMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			SysRole role = roleMapper.selectById(1l);
			//user 不为空
			Assert.assertNotNull(role);
			//userName = admin
			Assert.assertEquals("管理员", role.getRoleName());
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
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			SysRole role = roleMapper.selectById2(1l);
			//user 不为空
			Assert.assertNotNull(role);
			//userName = admin
			Assert.assertEquals("admin", role.getRoleName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			List<SysRole> roleList = roleMapper.selectAll();
			//user 不为空
			Assert.assertNotNull(roleList);
			//userName = admin
			Assert.assertTrue(roleList.size() > 0);
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUserId(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			List<SysRole> roleList = roleMapper.selectRoleByUserId(1L);
			//user 不为空
			Assert.assertNotNull(roleList);
			//userName = admin
			Assert.assertTrue(roleList.size() > 0);
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUserIdChoose(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			List<SysRole> roleList = roleMapper.selectRoleByUserIdChoose(13L);
			//user 不为空
			Assert.assertNotNull(roleList);
			//userName = admin
			Assert.assertTrue(roleList.size() > 0);
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
}
