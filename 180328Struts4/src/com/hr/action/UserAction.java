package com.hr.action;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.hr.dao.BaseDao;
import com.hr.entity.MyUser;
import com.hr.form.UserActionForm;

/**
 * 
 *@Name : UserAction
 *@Author : LH
 *@Date : 2018-3-30下午11:48:04
 *@Version : V1.0
 * @Description:
 */
public class UserAction extends DispatchAction {

	/**
	 * 用于文件上传，获取表单信息，调用DAO保存数据
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form;
        MyUser myUser = userForm.getMyUser();		
		//System.out.println(myUser.getName());
		//System.out.println(myUser.getAge());
		
		FormFile formFile = userForm.getMyfile();
		// 获取文件的名称
		String fileName =  formFile.getFileName();
	    //System.out.println(fileName);

		// 获取文件的二进制数据
		byte[] image = formFile.getFileData();
		//System.out.println(image.length);

		
		/**
		 *  实现文件上传有两种方式
		 * 一、将文件保存到tomcat对应的路径下;
		 *//*
		String path = request.getRealPath("image");
		//文件输入流
	    InputStream is = formFile.getInputStream(); 
	    //文件输出流
	    OutputStream os = new FileOutputStream(path + "/" + fileName);
	    int len = is.read();
	    while(len != -1){
	    	os.write(len);
	    	len = is.read();
	    }
	    
	    os.close();
	    is.close();*/
	    
	    
	    /**
	     * 二、将文件保存到数据库中
	     */
		// 实体类属性赋值
		myUser.setFilename(fileName);
		myUser.setImg(image);
		int row = BaseDao.save(myUser);
	    if(row > 0){
	    	System.out.println("添加用户成功！");
	    }
	    
	   return new ActionForward("/userAction.do?method=query");
	}
	
	/**
	 * 查询
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<MyUser> list = BaseDao.queryList(MyUser.class);
		request.setAttribute("list",list);
		
		return new ActionForward("/list.jsp");
	}
	
	/**
	 * showImg 显示图片
	 */
	public ActionForward showImg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form ;
		int id = userForm.getId();
		//System.out.println(id);
		/*int uid = Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);*/
		
		// 根据ID，获取其对象,需要二进制数据
		MyUser user = (MyUser) BaseDao.load(MyUser.class, id);
		//System.out.println(user);
		
		byte [] image = user.getImg();
		OutputStream os = response.getOutputStream();
		os.write(image);
		os.close();
		
		return null;
	}
	
	/**
	 * download 文件下载
	 */
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm userForm = (UserActionForm) form ;
		int id = userForm.getId();
		//System.out.println(id);
		/*int uid = Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);*/
		
		// 根据ID，获取其对象,需要二进制数据
		MyUser user = (MyUser) BaseDao.load(MyUser.class, id);
		String filename = user.getFilename();
		byte [] image = user.getImg();
		
		//设置响应头
		response.setHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("gbk"),"ISO-8859-1"));
		OutputStream os = response.getOutputStream();
		os.write(image);
		os.close();
		
		return null;
	}
}
