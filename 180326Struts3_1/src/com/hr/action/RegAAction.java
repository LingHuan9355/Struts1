package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Users;
import com.hr.form.AllForm;
/**
 * 
 *@Name : RegAAction
 *@Author : LH
 *@Date : 2018-3-27����12:22:56
 *@Version : V1.0
 * @Description:
 * 3.��regA.jsp����д�û��������룬һ��������,������page ,ֵ��a,Ȼ����AllForm(�̳�BaseForm),
  ��validate(),��request���õ�page������ֵ�������a,�Ͷ��û��������������֤,��֤�������µ���
  regA.jsp����ʾ������Ϣ������סԭ����ֵ��

  ��֤����֮��regA.jsp�ύ��RegA(Action),��RegA�в����κ����飬ֻ�Ƿ���һ��ActionForward("regB.jsp",true)
  �ض���regB.jsp��,��д����ͳ�������,һ��������,������page ,ֵ��b,Ȼ������ԭ��AllForm
  ���ձ���ֵ����validate()�����У�,��request���õ�page������ֵ�������b,�Ͷ�����ͳ������ڽ�����֤,
  ��֤�������µ���regB.jsp����ʾ������Ϣ������סԭ����ֵ��


  ��֤��ϣ�regB.jsp�ύ��RegB(Action)���õ�AllForm�е�ֵ����ӡ���

  ע��:RegA��RegB�������ļ��У�name��������AllForm,input�����ֱ���"/regA.jsp"��"/regB.jsp" .
 */
public class RegAAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AllForm aForm = (AllForm) form;
		Users users = aForm.getUsers();
		System.out.println(users.getUname());
		
		return new ActionForward("/regB.jsp");
	}
}
