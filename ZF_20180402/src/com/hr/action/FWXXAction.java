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
 *@Date : 2018-4-5下午10:23:25
 *@Version : V1.0
 * @Description:
 */
public class FWXXAction extends DispatchAction {

	/**
	 * 查询首页上的房屋信息
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
		
		
		//查询房屋信息
		List<TBL_FWXX> fwxxList = FWXXDao.queryList(TBL_FWXX.class);
		//查询区县信息
	    List<TBL_QX> qxList = QXDao.queryList(TBL_QX.class);
	    
	    //查询房屋类型
	    List<TBL_FWLX> fwlxList = FWLXDao.queryList(TBL_FWLX.class);
	    
	    
		//存所有的房屋信息的集合
		fwxxForm.setFwxxlist(fwxxList);
		//存所有的区县信息的集合
		fwxxForm.setQxlist(qxList);
		//存所有的房屋类型的集合
		fwxxForm.setFwlxlist(fwlxList);
		
		return new ActionForward("/index.jsp");
	}
	
	/**
	 * 高级搜索（包括主题模糊查询）房屋发布信息
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
		//条件发布信息标题
		String title = fwxxForm.getTitle();
		System.out.println("标题："+ title);
		
		//条件区县id
		int qxid =fwxxForm.getQxid();
		System.out.println("区县id：" + qxid);
		
		int jdid = fwxxForm.getJdid();
		System.out.println("街道id:" + jdid);
		
		//租金最小值、
		double zjmin = fwxxForm.getZjmin();
		System.out.println("zjmin:" + zjmin);

		//租金最大值
		double zjmax = fwxxForm.getZjmax();
		System.out.println("zjmax:" + zjmax);
		
		//赋值到实体类中
		fwxx.setTitle(title);
		fwxx.setQxid(qxid);
		fwxx.setZj(zjmin);
		fwxx.setJdid(jdid);
		
		//根据条件查询房屋信息
		List<TBL_FWXX> fwxxList = FWXXDao.queryByCondition(fwxx,zjmax);
		
		//存所有的房屋信息的集合
		fwxxForm.setFwxxlist(fwxxList);
		
		return new ActionForward("/index.jsp");
	}
	
	
	/**
	 * ajax查询街道的信息
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
		//System.out.println("区县类型queryJd="+qxid);
		
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
