package cc.zhou.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cc.zhou.model.Country;


/**
* abner zjj
* 2021年3月30日 下午3:19:34
* 
* 
*/
public class CountryMapperTest extends BaseMapperTest{

	@Test
	public void testSelectAll(){
		SqlSession sqlSession = getSqlSession();
		try {
			List<Country> countryList = sqlSession.selectList("cc.zhou.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		} finally {
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryList){
		for(Country country : countryList){
			System.out.printf("%-4d%4s%4s\n",country.getId(), country.getCountryname(), country.getCountrycode());
		}
	}
}
