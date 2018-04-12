package com.hr.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * 
 *<p>Title:BaseDao </p>
 *Description: 
 *
 *1.дһ��ͨ�õ�insert���ķ���public int save(Object o)
 *2.дһ��ͨ�õĲ�ѯ�������ݵķ���  public List find(Class c)
 *3.дһ��ͨ�õĲ�ѯĳ����ĵ������ݵķ���  public Object load(Class c,int id)
 *�����ʱ��ʵ�����������
 *дһ��ͨ�õ��޸ĵķ��� ��ɾ���ķ���
 *public int update(Object o)
 *public int delete(Class c,int id)
 *
 *@author LH
 *@date 2018-1-28����06:26:17
 *@version V1.0
 */
public class BaseDao {

	public static Properties ps = new Properties();
	
	static {
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("com/hr/conf/jdbc.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ�������ݿ����
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(ps.getProperty("driver"));
            conn = DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("uname"),ps.getProperty("upwd"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//�ر������ͷ���Դ
	public static void closeAll(ResultSet rs, Statement st,Connection conn){
			try {
			   if(rs != null){
				 rs.close();
			   }
			   if(st != null){
				   st.close();
			   }
			   if(conn != null){
				   conn.close();
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	/*public static void main(String[] args) {
		System.out.println(getConn());
	}*/
	
	//ͨ�õ�insert���ķ���
	@SuppressWarnings("unchecked")
	public static int save(Object obj){
		int num = 0;
		Class c =obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into ");
		sb.append(c.getSimpleName());
		sb.append(" ( ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(fs[i].getName());
			if(i < fs.length-1){
				sb.append(" , ");
			}
		}
		sb.append(" ) ");
		sb.append(" values ( ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(" ? ");
			if(i < fs.length-1){
				sb.append(" , ");
			}
		}
		sb.append(" ) ");
		//System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = BaseDao.getConn();
		try {
			pst = conn.prepareStatement(sb.toString());
            for (int i = 1; i < fs.length; i++) {
				if(fs[i].get(obj) instanceof java.util.Date){
					java.util.Date date = (Date) fs[i].get(obj);
					Date sdate = new Date(date.getTime());
					pst.setObject(i, sdate);
				}else{
					pst.setObject(i,fs[i].get(obj));
				}
			}
            num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}

		return num;
	}
	
	//ͨ�õĲ�ѯ�������ݵķ��� 
/*	@SuppressWarnings("unchecked")
	public static List queryList(Class c){
		List list = new ArrayList();
	    
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs, true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from ");
		sb.append(c.getSimpleName());
		System.out.println(sb);
		
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
			closeAll(rs, pst, conn);
		}
		
		return list;
	}*/
	
	//ͨ�õĲ�ѯĳ����ĵ������ݵķ���
	@SuppressWarnings("unchecked")
	public static Object load(Class c,int id) {
		Object obj = null;
	   
	   Field [] fs = c.getDeclaredFields();
	   Field.setAccessible(fs, true);
	   
	   StringBuffer sb = new StringBuffer();
	   sb.append(" select * from ");
	   sb.append(c.getSimpleName());
	   sb.append(" where ");
	   sb.append(fs[0].getName());
	   sb.append(" = ");
	   sb.append(id);
	   //System.out.println(sb);
	   
	   Connection conn = null;
	   PreparedStatement pst = null;
	   ResultSet rs = null;
	   try {
		  obj = c.newInstance(); 
		   conn = BaseDao.getConn();
     	   pst = conn.prepareStatement(sb.toString());
     	   rs = pst.executeQuery();
           while(rs.next()){
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
            }
     	   
	   } catch (Exception e) {
		e.printStackTrace();
	   }finally{
		  closeAll(rs, pst, conn);
	  }
	   
	   return obj;
	}
	
	//ͨ�õ��޸ĵķ���
	@SuppressWarnings("unchecked")
	public static int update(Object obj){
		int num  = 0;
		
		Class c = obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" update ");
		sb.append(c.getSimpleName());
		sb.append(" set ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(fs[i].getName());
			sb.append(" = ? ");
			if(i < fs.length -1 ){
				sb.append(" ,");
			}
		}
		sb.append(" where ");
		sb.append(fs[0].getName());
		sb.append(" = ?");
		//System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst =null;
		
		try {
			conn = BaseDao.getConn();
			pst = conn.prepareStatement(sb.toString());
			for (int i = 1; i < fs.length; i++) {
				if(fs[i].get(obj) instanceof java.util.Date){
                   java.util.Date date = (Date) fs[i].get(obj);
                   Date sdate = new Date(date.getTime());
				   pst.setObject(i, sdate);
				}else {
					pst.setObject(i,fs[i].get(obj));
				}
				
			}
			pst.setObject(fs.length,fs[0].get(obj));
			num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}
		
		
		return num;
	}

	//ɾ���ķ���һ
	@SuppressWarnings("unchecked")
	public static int delete(Class c,int id){
		int num = 0;
        
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from ");
		sb.append(c.getSimpleName());
		sb.append(" where ");
		sb.append(fs[0].getName());
		sb.append(" = ? ");
		//System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = BaseDao.getConn();
			pst = conn.prepareStatement(sb.toString());
			pst.setObject(1, id);
			
			num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}
		
		return num;
	} 

    //ɾ��������
	public static int delete(Object obj){
		int num = 0;
		Class c = obj.getClass();
		
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs, true);
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
          StringBuffer sql = new StringBuffer();
          sql.append(" delete from ");
          sql.append(c.getSimpleName());
          sql.append(" where ");
          sql.append(fs[0].getName());
          sql.append(" = ");
          sql.append(fs[0].get(obj));
         
         // System.out.println(sql);
          
          conn = BaseDao.getConn();
          pst = conn.prepareStatement(sql.toString());
          num = pst.executeUpdate();
			
		} catch (Exception e) {
		   e.printStackTrace();
		}finally{
			BaseDao.closeAll(null, pst, conn);
		}
		
		return num;
	}
}
