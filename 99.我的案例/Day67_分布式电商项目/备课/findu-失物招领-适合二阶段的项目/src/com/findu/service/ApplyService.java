package com.findu.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.findu.dao.ApplyDAO;
import com.findu.entity.Apply;
import com.findu.entity.Good;
import com.findu.exception.ApplyException;
import com.findu.exception.ChangeUserException;

public class ApplyService {
	
	private ApplyDAO dao = new ApplyDAO();

	public void applyGood(Apply apply) throws Exception {
		Apply applyOld = dao.getApplyByDetails(apply.getUserid(),
				apply.getGoodid());
		if (applyOld != null) {
			throw new Exception();
		}
		dao.save(apply);
	}

	public String applyCount(Good good) throws Exception {
		return this.dao.applyCount(good.getId());
	}

	public ArrayList<Apply> getHotApply() throws Exception {
		return this.dao.getHotApply();
	}

	public ArrayList<Apply> getApplyByApplyId(int applyuserid) throws Exception {
		return this.dao.getApplyByApplyId(applyuserid);
	}

	public ArrayList<Apply> getApplyByGoodId(int applygoodid) throws Exception {
		return this.dao.getApplyByGoodId(applygoodid);
	}

	// ���������Ʒ�ɹ����û�
	public Apply getApplySuccess(int applygoodid) throws Exception {
		return dao.getApplySuccess(applygoodid);
	}

	/**
	 * ɾ������
	 * @param applyid
	 * @throws Exception
	 */
	public void delApply(int applyid) throws ApplyException {
		try {	
			dao.delApply(applyid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplyException("ɾ��ʧ��");
		}	
	}

	// ͨ��applyid�������
	public Apply getApplyById(int applyid) throws Exception {
		return dao.getApplyById(applyid);
	}

	// ����������Ϣ
	public void updateApply(Apply apply) throws Exception {
		dao.updateApply(apply);
	}

	/**
	 * ��������
	 * @param state
	 * @param applyid
	 * @throws Exception
	 */
	public void dealApply(String state, int applyid) throws ApplyException {
		
		try {	
			dao.dealApply(state, applyid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplyException("����ʧ��");
		}		
	}
}