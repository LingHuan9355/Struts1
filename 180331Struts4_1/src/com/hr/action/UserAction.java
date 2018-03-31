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
 *@Date : 2018-3-31����10:23:01
 *@Version : V1.0
 * @Description: 
 * 
 * дһ�����û��ĵ���ɾ�Ĳ� 
 * ע��:���а���ͼƬ���ϴ�������
 * Action����̳�DispatchAction
 */
public class UserAction extends DispatchAction {

	/**
	 * �����ļ��ϴ�����ȡ����Ϣ������DAO��������
	 * ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaForm = (UserActionForm) form;
		MyUser users = uaForm.getUser();
		//System.out.println(users.getName());
		//System.out.println(users.getAge());
		
		FormFile formFile = uaForm.getImgfile();
		// ��ȡ�ļ�������
		String fileName = formFile.getFileName();
		//System.out.println(fileName);
		
		// ��ȡ�ļ��Ķ���������
		byte [] image = formFile.getFileData();
		//System.out.println(image.length);
		
		// ʵ���ļ��ϴ������ַ�ʽ
		// һ�����ļ����浽tomcat��Ӧ��·����;
		/*String path = request.getRealPath("image");
		//�ļ�������
		InputStream is = formFile.getInputStream();
		//�ļ������
		OutputStream os = new FileOutputStream(path + "/" + fileName); 
		int len = is.read();
		while(len != -1){
		     os.write(len);
		     len = is.read();
		}
        //�ͷ���Դ
		os.close();
		is.close();*/

		
		// �������ļ����浽���ݿ���
		// ʵ�������Ը�ֵ
		users.setFilename(fileName);
		users.setImg(image);
		int row = BaseDao.save(users);
		if(row >0){
			System.out.println("����ɹ���");
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
	@SuppressWarnings("unchecked")
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<MyUser>  list = BaseDao.queryList(MyUser.class);
		
		request.setAttribute("list",list);
		
		return new ActionForward("/list.jsp");
	}

    /**
     * showImg ��ʾͼƬ
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showImg(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
    	UserActionForm uaForm = (UserActionForm) form;
    	int uid = uaForm.getId(); 
    	//System.out.println("��ţ�" + uid);
    	
    	// ����ID����ȡ�����,��Ҫ����������
    	MyUser user = (MyUser) BaseDao.load(MyUser.class, uid);
    	//System.out.println(user.getName());
    	
    	byte [] image = user.getImg();
    	OutputStream os = response.getOutputStream();
    	os.write(image);
    	os.close();
    	
        return null;
    }

    /**
     * download ����ͼƬ
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward download(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
    	UserActionForm uaForm = (UserActionForm) form;
    	int uid = uaForm.getId();
    	//System.out.println(":" +uid);
    	
    	// ����ID����ȡ�����,��Ҫ����������
    	MyUser user = (MyUser) BaseDao.load(MyUser.class, uid);
    	String filename = user.getFilename();
    	System.out.println(filename);
    	byte [] image = user.getImg();
    	//������Ӧͷ
		response.setHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("gbk"),"ISO-8859-1"));
    	OutputStream os = response.getOutputStream();
    	os.write(image);
    	os.close();
		
        return null;
    }


    /**
     * ��ѯ�û�����
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showOne(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
         UserActionForm uaForm = (UserActionForm) form; 
    	 int uid = uaForm.getId();
    	
    	 MyUser user = (MyUser) BaseDao.load(MyUser.class, uid);
    	 
    	 request.setAttribute("user", user);
    	 
    	return new ActionForward("/UpdUser.jsp");
    }
    
    /**
     * �޸��û���Ϣ
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward UpdateUser(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
    	UserActionForm uaForm = (UserActionForm) form;
    	int uid = uaForm.getId();
    	//System.out.println("update=" + uid);
    	
    	MyUser user = uaForm.getUser();
    	user.setId(uid);
    	user.setName(uaForm.getUser().getName());
    	user.setAge(uaForm.getUser().getAge());
    	
    	FormFile formFile = uaForm.getImgfile();
    	//��ȡ�ļ���
    	String fileName = formFile.getFileName();
    	//System.out.println(fileName);
    	user.setFilename(fileName);
    	
    	// ��ȡ�ļ��Ķ���������
    	byte [] image = formFile.getFileData();
    	user.setImg(image);
    	
    	int row = BaseDao.update(user);
    	if(row > 0){
    		System.out.println("�޸ĳɹ���");
    	}
    	
    	return new ActionForward("/userAction.do?method=query");
    }


     /**
      * ɾ���û�
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return
      * @throws Exception
      */
    public ActionForward DeleteUser(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
    	UserActionForm uaForm = (UserActionForm) form;
    	int uid = uaForm.getId();
    	System.out.println("ɾ��" + uid);
    	
    	MyUser user = uaForm.getUser();
    	user.setId(uid);
    	
        int row = BaseDao.delete(user);
    	if(row > 0){
    		System.out.println("ɾ���û��ɹ���");
    	}
    	return new ActionForward("/userAction.do?method=query");
    }
}
