package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;

public interface TieManagerDao {
	//发帖操作
	public void insertTie(SendTie sendTie);
	//根据username进行查询帖的操作
	public List<SendTie> selectTiesByUsername(String username);
	//根据tieId删除帖子
	public void deleteTieByTieId(Integer tieId,String username);
	//更新帖子
	public void updateTieFzs(SendTie sendTie);
//	更具username进行查询replayTie操作
	public List<ReplayTie> selectReplayTiesByUsername(String username);
}
