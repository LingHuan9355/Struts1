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
		 * ���ݿ����Ӳ���
		 */
		//System.out.println(BaseDao.getConn());
		
		/**
		 * ���ݿ�sql������
		 */
		//System.out.println(FWXXDao.queryByTitle(TBL_FWXX.class,"������"));
	}

}
