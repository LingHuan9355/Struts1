package com.hr.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.entity.TBL_JD;

/**
 * 街道信息相关数据操作
 *@Name : JDDao
 *@Author : LH
 *@Date : 2018-4-7下午10:03:52
 *@Version : V1.0
 * @Description:
 */
public class JDDao {

	//通用的查询某个类的单个数据的方法
	/**
	 * 根据区县id查询
	 */
	@SuppressWarnings("unchecked")
	public static List queryByQxid(int qxid) {
	   List list = new ArrayList();
	   
	   StringBuffer sb = new StringBuffer();
	   sb.append(" select * from TBL_JD where qxid = " + qxid);
	   //System.out.println(sb);
	   
	   Connection conn = null;
	   PreparedStatement pst = null;
	   ResultSet rs = null;
	   try {
		   conn = BaseDao.getConn();
     	   pst = conn.prepareStatement(sb.toString());
     	   rs = pst.executeQuery();
           while(rs.next()){
        	   TBL_JD jd = new TBL_JD();
        	   jd.setJdid(rs.getInt("jdid"));
        	   jd.setJd(rs.getString("jd"));
        	   jd.setQxid(rs.getInt("qxid"));
        	   
        	   list.add(jd);
            }
     	   
	   } catch (Exception e) {
		e.printStackTrace();
	   }finally{
		  BaseDao.closeAll(rs, pst, conn);
	  }
	   
	   return list;
	}
	
}
