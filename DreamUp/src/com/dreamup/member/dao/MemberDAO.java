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

	// ȸ������ : �ٿ� ok
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

	// ȸ��Ż�� : �ٿ�ok
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

	// ���̵� ã��  ok
	public String findId(MemberDTO member) {

		String m_id = null;
		try {
			m_id = (String) sqlMap.queryForObject("member.findId", member);
			if(m_id != null){
				return m_id;
			}else{
				System.out.println("�̸�, ���� �Է°��� Ȯ���ϼ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// ��й�ȣ �缳�� : �ٿ�ok
	public boolean resetPwd(MemberDTO member) {
		int result;
		try {
			result = sqlMap.update("member.resetPwd", member);
			if (result == 1) {
				return true;
			}else{
				System.out.println("�̸�, ����, ���̵� �Է°��� Ȯ���ϼ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// �ߺ��˻� ok
	public boolean IdDuplicationCheck(String m_id) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.IdDuplicationCheck", m_id);
			if(result == 0){
				System.out.println("��밡���� ���̵� �Դϴ�.");
			return true;
			}else {
				System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.\n���̵� �ٽ� �Է����ּ���.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// �α��� ok
	public boolean login(MemberDTO member) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.login", member);
			if (result == 1) {
				System.out.println("�α��� ����");
				return true;
			}else{
				//���̵� ����ġ or ��� ����ġ�� ��ȿ���˻��ΰ�?
				System.out.println("���̵�� ��й�ȣ�� �ٽ� �Է����ּ���");
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
			if(result==0){
				
			return true;
			}
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

	// ���������� ���� ���� ���� ok
	public boolean updateInfo(MemberDTO member) {
		int result;
		try {
			result = sqlMap.update("member.updateInfo", member);
		if (result == 1) {
			return true;
		  }else{
			  System.out.println("���̵� ��ġ���� �ʽ��ϴ�.");
		  }
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
	
	// project���̺�/support���̺� ���ϴ� ��� �÷��� ���� �������� ����
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

	// ��ü ���� ���� ��ȸ ok
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
