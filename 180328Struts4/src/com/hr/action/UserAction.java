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
 *@Date : 2018-3-30����11:48:04
 *@Version : V1.0
 * @Description:
 */
public class UserAction extends DispatchAction {

	/**
	 * �����ļ��ϴ�����ȡ����Ϣ������DAO��������
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
		// ��ȡ�ļ�������
		String fileName =  formFile.getFileName();
	    //System.out.println(fileName);

		// ��ȡ�ļ��Ķ���������
		byte[] image = formFile.getFileData();
		//System.out.println(image.length);

		
		/**
		 *  ʵ���ļ��ϴ������ַ�ʽ
		 * һ�����ļ����浽tomcat��Ӧ��·����;
		 *//*
		String path = request.getRealPath("image");
		//�ļ�������
	    InputStream is = formFile.getInputStream(); 
	    //�ļ������
	    OutputStream os = new FileOutputStream(path + "/" + fileName);
	    int len = is.read();
	    while(len != -1){
	    	os.write(len);
	    	len = is.read();
	    }
	    
	    os.close();
	    is.close();*/
	    
	    
	    /**
	     * �������ļ����浽���ݿ���
	     */
		// ʵ�������Ը�ֵ
		myUser.setFilename(fileName);
		myUser.setImg(image);
		int row = BaseDao.save(myUser);
	    if(row > 0){
	    	System.out.println("����û��ɹ���");
	    }
	    
	   return new ActionForward("/userAction.do?method=query");
	}
	
	/**
	 * ��ѯ
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
	 * showImg ��ʾͼƬ
	 */
	public ActionForward showImg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form ;
		int id = userForm.getId();
		//System.out.println(id);
		/*int uid = Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);*/
		
		// ����ID����ȡ�����,��Ҫ����������
		MyUser user = (MyUser) BaseDao.load(MyUser.class, id);
		//System.out.println(user);
		
		byte [] image = user.getImg();
		OutputStream os = response.getOutputStream();
		os.write(image);
		os.close();
		
		return null;
	}
	
	/**
	 * download �ļ�����
	 */
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm userForm = (UserActionForm) form ;
		int id = userForm.getId();
		//System.out.println(id);
		/*int uid = Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);*/
		
		// ����ID����ȡ�����,��Ҫ����������
		MyUser user = (MyUser) BaseDao.load(MyUser.class, id);
		String filename = user.getFilename();
		byte [] image = user.getImg();
		
		//������Ӧͷ
		response.setHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("gbk"),"ISO-8859-1"));
		OutputStream os = response.getOutputStream();
		os.write(image);
		os.close();
		
		return null;
	}
}
