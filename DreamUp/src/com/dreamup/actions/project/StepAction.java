package com.dreamup.actions.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class StepAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        
		String name =request.getParameter("name");
		//DB�Է�
		System.out.println("1�ܰ赥���� DB�Է��߾��!!");
		
		return mapping.findForward("scs");
	}
}