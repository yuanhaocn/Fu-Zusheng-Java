package com.qfedu.serviceImp;

import java.util.List;

import com.qfedu.daoImp.TieManagerDaoImp;
import com.qfedu.domain.SendTie;

public class TieManagerServiceImp implements com.qfedu.service.TieManagerService {
	TieManagerDaoImp tmdi=new TieManagerDaoImp();
	@Override
	public List<SendTie> choseAllTie() {
		List<SendTie> list = tmdi.selectAllTie();
		return list;
	}

}
