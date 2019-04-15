package com.qfedu.serviceImp;

import java.util.Date;
import java.util.List;

import com.qfedu.daoImp.TieManagerDaoImp;
import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;
import com.qfedu.service.TieManagerService;

public class TieManagerServiceImp implements TieManagerService{
	private TieManagerDaoImp tmdi = new TieManagerDaoImp();
	@Override
	public void addTieAndUpdateUser(String theme, String sendContent, String sendUser) {
		SendTie sendTie = new SendTie();
		sendTie.setTheme(theme);
		sendTie.setSendContent(sendContent);
		sendTie.setSendUser(sendUser);
		
		//����ʱ�䣬��ǰϵͳʱ��
		sendTie.setSendTime(new Date());
		sendTie.setUpdateTime(new Date());
		tmdi.insertTie(sendTie);
		
	}
	@Override
	public List<SendTie> getTiesByUsername(String username) {
		List<SendTie> tieLists = tmdi.selectTiesByUsername(username);
		return tieLists;
	}
	
	
	@Override
	public void removeTieByTieId(Integer tieId, String username) {
		tmdi.deleteTieByTieId(tieId, username);
	}
	@Override
	public void updateTieFze(Integer tieId, String theme, String sendContent) {
		SendTie sendTie = new SendTie();
		sendTie.setTieId(tieId);
		sendTie.setTheme(theme);
		sendTie.setSendContent(sendContent);
		
		//����ʱ�䣬��ǰϵͳʱ��
		//sendTie.setSendTime(new Date());
		sendTie.setUpdateTime(new Date());
		tmdi.updateTieFzs(sendTie);
	}
	/*
	 *ͨ����ǰ�û������֣���ѯ`reply_tie`�����ݣ����Ҹ���`reply_tie`��Tieid���send_tie`����������
	 */
	@Override
	public List<ReplayTie> getReplayTiesByUsername(String username) {
		List<ReplayTie> SRTBN = tmdi.selectReplayTiesByUsername(username);
		return SRTBN;
	}

}
