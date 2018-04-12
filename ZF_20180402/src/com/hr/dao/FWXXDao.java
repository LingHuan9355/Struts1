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

import com.hr.entity.TBL_FWXX;

/**
 * 房屋信息相关数据操作
 *@Name : FWXXDao
 *@Author : LH
 *@Date : 2018-4-7上午11:44:27
 *@Version : V1.0
 * @Description:
 */
public class FWXXDao {

	
	/**
	 * 通用的查询所有数据的方法 
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
		sb.append(" order by date desc");
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
	
	/**
	 * 根据条件高级搜索
	 * @param c
	 * @param title
	 * @return 
	 *    select * from tbl_fwxx where 1=1 and title like '%海淀区%'
	 *    and qxid = 1
	 *    and jdid = 2and zj >= 0
	 *    and zj <= 6000
	 *    and shi = 3
	 *    and ting =1
	 *    and lxid =4
	 *    and date <= '2017-04-01' 
	 *    order by date  desc;
	 */
	@SuppressWarnings("unchecked")
	public static List queryByCondition(TBL_FWXX fwxx,double zj) {
	   List list = new ArrayList();
		
	   
	   StringBuffer sb = new StringBuffer();
	   sb.append(" select * from TBL_FWXX where 1=1 ");
	   if(fwxx.getTitle() !=null && fwxx.getTitle() !=""){
		   sb.append(" and title like '%" + fwxx.getTitle() + "%'");
	   }
	   
	   if(fwxx.getQxid()!=0){
		   sb.append(" and qxid = " + fwxx.getQxid());
	   }
	   
	   if(fwxx.getJdid()!=0){
		   sb.append(" and jdid = " + fwxx.getJdid());
	   }
	   
	   if(fwxx.getZj()!=0){
		   sb.append(" and zj >="+fwxx.getZj());	
	   }
	   
	   if(zj !=0 && zj >= fwxx.getZj()){
		   sb.append(" and zj <= "+zj);
	   }
	   
	   if(fwxx.getShi()!=0){
		   sb.append(" and shi= "+ fwxx.getShi() );
	   }
	   
	   if(fwxx.getTing()!=0){
		   sb.append(" and ting= " +fwxx.getTing() );
	   }
	   
	   if(fwxx.getLxid()!=0){
		   sb.append(" and lxid= "+ fwxx.getLxid());  
				
	   }
	   
	   if(fwxx.getDate()!= null){
			sb.append(" and date <= ' " + fwxx.getDate() +"'");
	   }
	   
	   sb.append(" order by date desc");
	   System.out.println(sb);
	   
	   Connection conn = null;
	   PreparedStatement pst = null;
	   ResultSet rs = null;
	   try {
		   conn = BaseDao.getConn();
     	   pst = conn.prepareStatement(sb.toString());
     	   rs = pst.executeQuery();
           while(rs.next()){
        	   TBL_FWXX fw = new TBL_FWXX();
                 fw.setFwid(rs.getInt("fwid"));
                 fw.setUid(rs.getInt("uid"));
                 fw.setTitle(rs.getString("title"));
                 fw.setZj(rs.getDouble("zj"));
                 fw.setDate(rs.getDate("date"));
                
                 list.add(fw);
            }
     	   
	   } catch (Exception e) {
		e.printStackTrace();
	   }finally{
		  BaseDao.closeAll(rs, pst, conn);
	  }
	   
	   return list;
	}
	
	
}
