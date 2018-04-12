package com.hr.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hr.dao.FWLXDao;
import com.hr.dao.FWXXDao;
import com.hr.dao.JDDao;
import com.hr.dao.QXDao;
import com.hr.entity.TBL_FWLX;
import com.hr.entity.TBL_JD;
import com.hr.entity.TBL_QX;
import com.hr.entity.TBL_FWXX;
import com.hr.form.FWXXActionForm;

/**
 * 
 *@Name : FWXXAction
 *@Author : LH
 *@Date : 2018-4-5����10:23:25
 *@Version : V1.0
 * @Description:
 */
public class FWXXAction extends DispatchAction {

	/**
	 * ��ѯ��ҳ�ϵķ�����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FWXXActionForm fwxxForm = (FWXXActionForm) form;
		
		
		//��ѯ������Ϣ
		List<TBL_FWXX> fwxxList = FWXXDao.queryList(TBL_FWXX.class);
		//��ѯ������Ϣ
	    List<TBL_QX> qxList = QXDao.queryList(TBL_QX.class);
	    
	    //��ѯ��������
	    List<TBL_FWLX> fwlxList = FWLXDao.queryList(TBL_FWLX.class);
	    
	    
		//�����еķ�����Ϣ�ļ���
		fwxxForm.setFwxxlist(fwxxList);
		//�����е�������Ϣ�ļ���
		fwxxForm.setQxlist(qxList);
		//�����еķ������͵ļ���
		fwxxForm.setFwlxlist(fwlxList);
		
		return new ActionForward("/index.jsp");
	}
	
	/**
	 * �߼���������������ģ����ѯ�����ݷ�����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FWXXActionForm fwxxForm = (FWXXActionForm) form;
		
		TBL_FWXX fwxx = new TBL_FWXX();
		//����������Ϣ����
		String title = fwxxForm.getTitle();
		System.out.println("���⣺"+ title);
		
		//��������id
		int qxid =fwxxForm.getQxid();
		System.out.println("����id��" + qxid);
		
		int jdid = fwxxForm.getJdid();
		System.out.println("�ֵ�id:" + jdid);
		
		//�����Сֵ��
		double zjmin = fwxxForm.getZjmin();
		System.out.println("zjmin:" + zjmin);

		//������ֵ
		double zjmax = fwxxForm.getZjmax();
		System.out.println("zjmax:" + zjmax);
		
		//��ֵ��ʵ������
		fwxx.setTitle(title);
		fwxx.setQxid(qxid);
		fwxx.setZj(zjmin);
		fwxx.setJdid(jdid);
		
		//����������ѯ������Ϣ
		List<TBL_FWXX> fwxxList = FWXXDao.queryByCondition(fwxx,zjmax);
		
		//�����еķ�����Ϣ�ļ���
		fwxxForm.setFwxxlist(fwxxList);
		
		return new ActionForward("/index.jsp");
	}
	
	
	/**
	 * ajax��ѯ�ֵ�����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryJd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FWXXActionForm fwxxForm = (FWXXActionForm) form;
		int qxid = fwxxForm.getQxid();
		//System.out.println("��������queryJd="+qxid);
		
		List<TBL_JD> jdList = JDDao.queryByQxid(qxid);
		//System.out.println("size:"+jdList.size());
		
		StringBuffer str = new StringBuffer();
		str.append("<jds>");
		for(TBL_JD jd:jdList){
			str.append("<jd>");
			str.append("<jdid>"+jd.getJdid()+"</jdid>");
			str.append("<jdname>"+jd.getJd()+"</jdname>");
			str.append("</jd>");
		}
		str.append("</jds>");
		
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(str);
		//System.out.println("str:"+str);
		return null;
	}
}
