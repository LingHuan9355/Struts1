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
 *@Date : 2018-3-31下午10:23:01
 *@Version : V1.0
 * @Description: 
 * 
 * 写一个对用户的的增删改查 
 * 注意:其中包含图片的上传和下载
 * Action必须继承DispatchAction
 */
public class UserAction extends DispatchAction {

	/**
	 * 用于文件上传，获取表单信息，调用DAO保存数据
	 * 添加
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
		// 获取文件的名称
		String fileName = formFile.getFileName();
		//System.out.println(fileName);
		
		// 获取文件的二进制数据
		byte [] image = formFile.getFileData();
		//System.out.println(image.length);
		
		// 实现文件上传有两种方式
		// 一、将文件保存到tomcat对应的路径下;
		/*String path = request.getRealPath("image");
		//文件输入流
		InputStream is = formFile.getInputStream();
		//文件输出流
		OutputStream os = new FileOutputStream(path + "/" + fileName); 
		int len = is.read();
		while(len != -1){
		     os.write(len);
		     len = is.read();
		}
        //释放资源
		os.close();
		is.close();*/

		
		// 二、将文件保存到数据库中
		// 实体类属性赋值
		users.setFilename(fileName);
		users.setImg(image);
		int row = BaseDao.save(users);
		if(row >0){
			System.out.println("保存成功！");
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
	@SuppressWarnings("unchecked")
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<MyUser>  list = BaseDao.queryList(MyUser.class);
		
		request.setAttribute("list",list);
		
		return new ActionForward("/list.jsp");
	}

    /**
     * showImg 显示图片
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
    	//System.out.println("编号：" + uid);
    	
    	// 根据ID，获取其对象,需要二进制数据
    	MyUser user = (MyUser) BaseDao.load(MyUser.class, uid);
    	//System.out.println(user.getName());
    	
    	byte [] image = user.getImg();
    	OutputStream os = response.getOutputStream();
    	os.write(image);
    	os.close();
    	
        return null;
    }

    /**
     * download 下载图片
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
    	
    	// 根据ID，获取其对象,需要二进制数据
    	MyUser user = (MyUser) BaseDao.load(MyUser.class, uid);
    	String filename = user.getFilename();
    	System.out.println(filename);
    	byte [] image = user.getImg();
    	//设置响应头
		response.setHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("gbk"),"ISO-8859-1"));
    	OutputStream os = response.getOutputStream();
    	os.write(image);
    	os.close();
		
        return null;
    }


    /**
     * 查询用户详情
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
     * 修改用户信息
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
    	//获取文件名
    	String fileName = formFile.getFileName();
    	//System.out.println(fileName);
    	user.setFilename(fileName);
    	
    	// 获取文件的二进制数据
    	byte [] image = formFile.getFileData();
    	user.setImg(image);
    	
    	int row = BaseDao.update(user);
    	if(row > 0){
    		System.out.println("修改成功！");
    	}
    	
    	return new ActionForward("/userAction.do?method=query");
    }


     /**
      * 删除用户
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
    	System.out.println("删除" + uid);
    	
    	MyUser user = uaForm.getUser();
    	user.setId(uid);
    	
        int row = BaseDao.delete(user);
    	if(row > 0){
    		System.out.println("删除用户成功！");
    	}
    	return new ActionForward("/userAction.do?method=query");
    }
}
