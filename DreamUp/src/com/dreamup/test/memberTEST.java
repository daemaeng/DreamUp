package com.dreamup.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamup.member.dao.MemberDAO;
import com.dreamup.member.dto.MemberDTO;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class memberTEST {

	public static void main(String[] args) {

		// MemberDAO dao = new MemberDAO();
		// member.setM_id("11");
		// member.setM_password("11");

		// System.out.println(dao.login(member));
		// System.out.println(dao.selectMember(40));
		// System.out.println(dao.selectMember(18).toString());

		// member.setM_id("test1");
		// member.setM_password("1234");
		// member.setM_email("kancho33@naver.com");
		// member.setM_name("�ֿ뼮");

		// member.setM_id("test2");
		// member.setM_password("1234");
		// member.setM_email("hololoo@naver.com");
		// member.setM_name("��ȣâ");
		//
		// member.setM_id("test3");
		// member.setM_password("1234");
		// member.setM_email("4eyes@naver.com");
		// member.setM_name("������");
		//
		// member.setM_id("test4");
		// member.setM_password("1234");
		// member.setM_email("frendly@naver.com");
		// member.setM_name("���ٿ�");
		// MemberDTO member = new MemberDTO();
		// member.setM_id("test5");
		// member.setM_password("1234");
		// member.setM_email("what?@naver.com");
		// member.setM_name("������");

		// member.setM_date(null);

		// boolean t= dao.insert(member);
		//
		// if (t) {
		// System.out.println("after insert to member : "+member.toString());
		// } else {
		// System.out.println("Action �Է� ����");
		// // }
		// System.out.println(dao.selectMember(46).toString());

		// MemberDAO member = new MemberDAO();
		// member.listMember();
		// MemberDAO��� Ŭ������ member��� �������� ������ ��ü ����
		// member��� �������� ������ MemberDAO��� Ŭ���� ���� �ִ� listMember()�޼ҵ带 ȣ��

		// MemberDAO dao = new MemberDAO();
		// 1.��ü����

		// dao.listMember();
		// 2.������ ��ü�� �޼ҵ� ȣ��

		// 2-1.ȣ��� �޼ҵ��� ������ Ȯ��

		// 2-1-1.�Ķ����x/ ������o
		// 2-1-2.ȣ���ϴ� �޼ҵ��� �������� Ȯ��
		// 2-1-3.ȣ���ϴ� �޼ҵ��� ���ϰ��� �ٱ��ϸ� ����
		// List<MemberDTO> list = new ArrayList<>();
		// 2-1-4.������ �ٱ��Ͽ� �޼ҵ��� ���ϰ��� �Ҵ�
		// 3.�޼ҵ��� ���ϰ��� ���
		
		MemberDAO dao = new MemberDAO();
		//Ŭ�����ٿ� ��ü ����
		
		List<MemberDTO> memberList;
		//listMember������ �ٱ��� �����
		
		memberList = dao.listMember();
		//�޼ҵ� ȣ���� ����� ������ �ٱ��Ͽ� �ֱ�
		
		for (int i = 0; i < memberList.size(); i++) {
			
			MemberDTO member;
			member = memberList.get(i);
			
			System.out.println(member);
		}
	}
}
