package com.hr.test;

import junit.framework.TestSuite;

import org.junit.Test;

import com.hr.dao.BaseDao;
import com.hr.dao.FWXXDao;
import com.hr.entity.TBL_FWXX;


public class AllTests {

	@Test
	public  void testMian() {
	 
		/**
		 * 数据库连接测试
		 */
		//System.out.println(BaseDao.getConn());
		
		/**
		 * 数据库sql语句测试
		 */
		//System.out.println(FWXXDao.queryByTitle(TBL_FWXX.class,"海淀区"));
	}

}
