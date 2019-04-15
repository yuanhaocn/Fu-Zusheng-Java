package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;

public interface TieManagerDao {
	//��������
	public void insertTie(SendTie sendTie);
	//����username���в�ѯ���Ĳ���
	public List<SendTie> selectTiesByUsername(String username);
	//����tieIdɾ������
	public void deleteTieByTieId(Integer tieId,String username);
	//��������
	public void updateTieFzs(SendTie sendTie);
//	����username���в�ѯreplayTie����
	public List<ReplayTie> selectReplayTiesByUsername(String username);
}
