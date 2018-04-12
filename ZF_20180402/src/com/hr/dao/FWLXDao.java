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

/**
 * 房屋类型信息相关数据操作
 *@Name : FWLXDao
 *@Author : LH
 *@Date : 2018-4-7下午05:37:39
 *@Version : V1.0
 * @Description:
 */
public class FWLXDao {

	/**
	 * 查出房屋类型所有信息
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List queryList(Class c){
		List list = new ArrayList();
	    
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs, true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from ");
		sb.append(c.getSimpleName());
		//System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			pst = conn.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while(rs.next()){
				Object obj = c.newInstance();
				for (int i = 0; i < fs.length; i++) {
					if(rs.getObject(fs[i].getName()) instanceof BigDecimal){
						BigDecimal big = (BigDecimal) rs.getObject(fs[i].getName());
						int value = big.intValue();
						fs[i].set(obj, value);
					}else if(rs.getObject(fs[i].getName()) instanceof Timestamp){
						Timestamp time = (Timestamp) rs.getObject(fs[i].getName());
						Date date = new Date(time.getTime());
						fs[i].set(obj, date);
					}else{
						//stu.setId(rs.getInt("id"));
						//stu.setName(rs.getString("name"));
						fs[i].set(obj, rs.getObject(fs[i].getName()));
					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, pst, conn);
		}
		
		return list;
	}
}
