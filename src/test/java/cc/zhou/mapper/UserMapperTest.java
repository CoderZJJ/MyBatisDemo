package cc.zhou.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import cc.zhou.model.SysPrivilege;
import cc.zhou.model.SysRole;
import cc.zhou.model.SysUser;
import cc.zhou.type.Enabled;

/**
* abner zjj
* 2021年3月31日 下午5:18:48
* 
* 
*/
public class UserMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			SysUser user = userMapper.selectById(1l);
			//user 不为空
			Assert.assertNotNull(user);
			//userName = admin
			Assert.assertEquals("admin", user.getUserName());
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
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用 selectById 方法，查询 id = 1 的用户
			List<SysUser> userList = userMapper.selectAll();
			//user 不为空
			Assert.assertNotNull(userList);
			//userName = admin
			Assert.assertTrue(userList.size() > 0);
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
		for (SysRole sysRole : roleList) {
			System.out.println(sysRole.getUser().getUserName()+"  "+sysRole.getRoleName());
		}
		Assert.assertNotNull(roleList);
		Assert.assertTrue(roleList.size() > 0);
		sqlSession.close();
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("123456");
		user.setUserEmail("test@mybatis.tk");
		user.setUserInfo("test info");
		//正常情况下应该读入一张图片存到 byte 数组中
		user.setHeadImg(new byte[]{1,2,3});
		user.setCreateTime(new Date());
		int result = userMapper.insert(user);
		//只插入 1 条数据
		Assert.assertEquals(1, result);
		//id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
		Assert.assertNull(user.getId());
		//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
		//由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
		//因此不手动执行 commit 也不会提交到数据库
		//sqlSession.rollback();
		sqlSession.commit();
		//不要忘记关闭 sqlSession
		sqlSession.close();		
	}
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("123456");
		user.setUserEmail("test@mybatis.tk");
		user.setUserInfo("test info");
		//正常情况下应该读入一张图片存到 byte 数组中
		user.setHeadImg(new byte[]{1,2,3});
		user.setCreateTime(new Date());
		int result = userMapper.insert2(user);
		//只插入 1 条数据
		Assert.assertEquals(1, result);
		//id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
		Assert.assertNotNull(user.getId());
		//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
		//由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
		//因此不手动执行 commit 也不会提交到数据库
		//sqlSession.rollback();
		sqlSession.commit();
		System.out.println(user.getId());
		//不要忘记关闭 sqlSession
		sqlSession.close();		
	}
	
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("123456");
		user.setUserEmail("test@mybatis.tk");
		user.setUserInfo("test info");
		//正常情况下应该读入一张图片存到 byte 数组中
		user.setHeadImg(new byte[]{1,2,3});
		user.setCreateTime(new Date());
		int result = userMapper.insert3(user);
		//只插入 1 条数据
		Assert.assertEquals(1, result);
		//id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
		Assert.assertNotNull(user.getId());
		//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
		//由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
		//因此不手动执行 commit 也不会提交到数据库
		//sqlSession.rollback();
		sqlSession.commit();
		System.out.println(user.getId());
		//不要忘记关闭 sqlSession
		sqlSession.close();		
	}
	
	@Test
	public void updateById() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = new SysUser();
		user.setId(6L);
		user.setUserName("test6");
		user.setUserPassword("123456!Ab");
		user.setUserEmail("test6@mybatis.tk");
		user.setUserInfo("test6 info");
		//正常情况下应该读入一张图片存到 byte 数组中
		user.setHeadImg(new byte[]{1,2,3});
		user.setCreateTime(new Date());
		int result = userMapper.updateById(user);
		//只插入 1 条数据
		Assert.assertEquals(1, result);
		//id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
		user = userMapper.selectById(6L);
		//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
		//由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
		//因此不手动执行 commit 也不会提交到数据库
		//sqlSession.rollback();
		sqlSession.commit();
		System.out.println(user.getId());
		//不要忘记关闭 sqlSession
		sqlSession.close();		
	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int result = userMapper.deleteById(5L);
		//只插入 1 条数据
		Assert.assertEquals(1, result);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用 selectRolesByUserIdAndRoleEnabled 方法查询用户的角色
			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			//结果不为空
			Assert.assertNotNull(roleList);
			//角色数量大于 0 个
			Assert.assertTrue(roleList.size() > 0);
			for (SysRole sysRole : roleList) {
				System.out.println(sysRole.getRoleName());
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserAndRole(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用 selectRolesByUserIdAndRoleEnabled 方法查询用户的角色
			SysUser user = new SysUser();
			user.setId(1L);
			SysRole role = new SysRole();
			role.setEnabled(Enabled.disabled);
			List<SysRole> roleList = userMapper.selectRolesByUserAndRole(user, role);
			for (SysRole sysRole : roleList) {
				System.out.println(sysRole.getUser().getUserName()+"  "+sysRole.getRoleName());
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test");
			user.setUserEmail("admin@mybatis.tk");
			List<SysUser> list = userMapper.selectByUser(user);
			for (SysUser sysUser : list) {
				System.out.println(sysUser.getUserName());
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByIdSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(6L);
			user.setUserName("test7777");
			user.setUserEmail("admin@mybatis.tk");
			int result = userMapper.updateByIdSelective(user);
			System.out.println(result);
			sqlSession.commit();
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2Selective(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个 user 对象
			SysUser user = new SysUser();
			user.setUserName("test-selective");
			user.setUserPassword("123456");
			user.setUserInfo("test info");
			user.setCreateTime(new Date());
			//插入数据库
			userMapper.insert2(user);
			//获取插入的这条数据
			user = userMapper.selectById(user.getId());
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
			
		} finally {
			sqlSession.commit();
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdOrUserName() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(1L);
			List<SysUser> list = userMapper.selectByIdOrUserName(user);
			for (SysUser sysUser : list) {
				System.out.println(sysUser.getUserName());
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdList(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Long> idList = new ArrayList<Long>();
			idList.add(1L);
			idList.add(1001L);
			//业务逻辑中必须校验 idList.size() > 0
			List<SysUser> userList = userMapper.selectByIdList(idList);
			Assert.assertEquals(2, userList.size());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertList(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个 user 对象
			List<SysUser> userList = new ArrayList<SysUser>();
			for(int i = 0; i < 2; i++){
				SysUser user = new SysUser();
				user.setUserName("test" + i);
				user.setUserPassword("123456");
				user.setUserEmail("test@mybatis.tk");
				userList.add(user);
			}
			//将新建的对象批量插入数据库中，特别注意，这里的返回值 result 是执行的 SQL 影响的行数
			int result = userMapper.insertList(userList);
			Assert.assertEquals(2, result);
			for(SysUser user : userList){
				System.out.println(user.getId());
			}
		} finally {
			//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
			sqlSession.commit();
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByMap(){
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//从数据库查询 1 个 user 对象
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 10L);
			map.put("user_email", "test@mybatis.tk");
			map.put("user_password", "12345678");
			//更新数据
			userMapper.updateByMap(map);
			//根据当前 id 查询修改后的数据
			SysUser user = userMapper.selectById(1L);
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		} finally {
			//为了不影响数据库中的数据导致其他测试失败，这里选择回滚
			sqlSession.commit();
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//特别注意，在我们测试数据中，id = 1L 的用户有两个角色
			//由于后面覆盖前面的，因此只能得到最后一个角色
			//我们这里使用只有一个角色的用户（id = 1001L）
			//可以用 selectUserAndRoleById2 替换进行测试
			SysUser user = userMapper.selectUserAndRoleById(1001L);
			//user 不为空
			Assert.assertNotNull(user);
			//user.role 也不为空
			Assert.assertNotNull(user.getRole());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleById2(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//特别注意，在我们测试数据中，id = 1L 的用户有两个角色
			//由于后面覆盖前面的，因此只能得到最后一个角色
			//我们这里使用只有一个角色的用户（id = 1001L）
			//可以用 selectUserAndRoleById2 替换进行测试
			SysUser user = userMapper.selectUserAndRoleById2(1001L);
			//user 不为空
			Assert.assertNotNull(user);
			//user.role 也不为空
			Assert.assertNotNull(user.getRole());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleByIdSelect(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//特别注意，在我们测试数据中，id = 1L 的用户有两个角色
			//由于后面覆盖前面的，因此只能得到最后一个角色
			//我们这里使用只有一个角色的用户（id = 1001L）
			SysUser user = userMapper.selectUserAndRoleByIdSelect(1001L);
			//user 不为空
			Assert.assertNotNull(user);
			//user.role 也不为空
			System.out.println("调用 user.equals(null)");
			user.equals(null);
			System.out.println("调用 user.getRole()");
			Assert.assertNotNull(user.getRole());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAllUserAndRoles(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAllUserAndRoles();
			System.out.println("用户数：" + userList.size());
			for(SysUser user : userList){
				System.out.println("用户名：" + user.getUserName());
				for(SysRole role: user.getRoleList()){
					System.out.println("角色名：" + role.getRoleName());
					for(SysPrivilege privilege : role.getPrivilegeList()){
						System.out.println("权限名：" + privilege.getPrivilegeName());
					}
				}
			}
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(1L);
			userMapper.selectUserById(user);
			System.out.println(user.getUserName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserPage(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userName", "ad");
			params.put("offset", 0);
			params.put("limit", 10);
			List<SysUser> userList = userMapper.selectUserPage(params);
			Long total = (Long)params.get("total");
			System.out.println(total);
			System.out.println(userList.get(0).getUserName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertUserAndRoles(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片存到 byte 数组中
			user.setHeadImg(new byte[]{1,2,3});
			int result = userMapper.insertUserAndRoles(user,"1,2");
			System.out.println(result);
			sqlSession.commit();			
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteUserById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 UserMapper 接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			int result = userMapper.deleteUserById(14L);
			System.out.println(result);
			sqlSession.commit();			
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
}
