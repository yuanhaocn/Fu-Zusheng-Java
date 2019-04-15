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
		
		//设置时间，当前系统时间
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
		
		//设置时间，当前系统时间
		//sendTie.setSendTime(new Date());
		sendTie.setUpdateTime(new Date());
		tmdi.updateTieFzs(sendTie);
	}
	/*
	 *通过当前用户的名字，查询`reply_tie`的数据，并且根据`reply_tie`的Tieid获得send_tie`的帖子主题
	 */
	@Override
	public List<ReplayTie> getReplayTiesByUsername(String username) {
		List<ReplayTie> SRTBN = tmdi.selectReplayTiesByUsername(username);
		return SRTBN;
	}

}
