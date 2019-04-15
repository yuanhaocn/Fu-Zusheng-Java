package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;

public interface TieManagerService {
	public void addTieAndUpdateUser(String theme ,String sendContent,String sendUser);
	
	public List<SendTie> getTiesByUsername(String username);
	
	public void removeTieByTieId(Integer tieId,String username);
//	封信帖子
	public void updateTieFze(Integer tieId,String theme,String sendContent);
//查看回复的帖子
	public List<ReplayTie> getReplayTiesByUsername(String username);
	

}
