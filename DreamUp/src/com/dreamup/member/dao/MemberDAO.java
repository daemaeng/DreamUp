package com.dreamup.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.dreamup.ibatis.SqlMapConfig;
import com.dreamup.member.dto.MemberDTO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAO {
	SqlMapClient sqlMap;

	public MemberDAO() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
	}

	// ȸ������
	public boolean insert(MemberDTO member) {
		boolean result = false;
		try {
			System.out.println("before insert to member : " + member.toString());
			sqlMap.insert("member.insert", member);

			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��й�ȣ ��ȣȭ
	public boolean encryptionPwd(String m_password) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.encryptionPwd", m_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// ȸ��Ż��
	public boolean delete(String m_id) {
		int result;
		try {
			result = sqlMap.delete("member.delete", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// ���̵� ã�� : m_name�� m_email �ΰ��� �Ӽ��� ���� memberDTO�� ����
	public String findId(MemberDTO member) {

		String m_id = null;
		try {
			m_id = (String) sqlMap.queryForObject("member.findId", member);
			return m_id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// ��й�ȣ �缳��
	public boolean resetPwd(int m_no) {
		int result;
		try {
			result = sqlMap.update("member.resetPwd", m_no);
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// �ߺ��˻�
	public boolean IdDuplicationCheck(String m_id) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.IdDuplicationCheck", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// �α���
	public boolean login(MemberDTO member) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.login", member);
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// �ѹ��̶� �Ŀ��� ���� �ִ� ����ڰ� ����ּҸ� ����� �ּ����� �� ���
	public boolean supportingCount(String m_id) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.supportingCount", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// ����� �Ŀ����� �Է½� ���������� �����ΰ��
	public MemberDTO selectOwn(String m_id) {
		MemberDTO member;
		try {
			member = (MemberDTO) sqlMap.queryForObject("member.selectOwn", m_id);
			return member;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ���������� ���� ���� ����
	public boolean updateInfo(MemberDTO member) {
		int result;
		try {
			result = sqlMap.update("member.updateInfo", member);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// �ѹ��� �Ŀ��� ���� ���� ����ڰ� ����� �Ŀ����� �Է½� ����ּҸ� ����� �ּ����� �Ұ��
	public boolean updateSupport(String m_id) {
		int result;
		try {
			result = sqlMap.update("member.updateSupport", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// project���̺�/support���̺��� ���ϴ� ��� �÷��� ���� �������� ����
	// ����� ���� �ο���
	public MemberDTO selectMember(int i) {
		MemberDTO member;

		try {
			member = (MemberDTO) sqlMap.queryForObject("member.selectMember", i);
			return member;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ��ü ���� ���� ��ȸ
	public List<MemberDTO> listMember() {
		List<MemberDTO> memberList;
		try {
			memberList = sqlMap.queryForList("member.listMember");
			return memberList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}