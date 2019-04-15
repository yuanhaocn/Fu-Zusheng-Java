package com.qfedu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;
import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/queryReplayTieFzsServlet")
public class QueryReplayTieFzsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Ӧ����
				resp.setContentType("text/html; charset=utf-8");
				//��ȡsession���ֵ,��Ҫǿת������
				UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
				TieManagerServiceImp tmsi = new TieManagerServiceImp();
				//���÷������ɼ���
				 List<ReplayTie> replayList = tmsi.getReplayTiesByUsername(ue.getUsername());
				//תΪjson�����ַ���
				Gson gson = new Gson();
				String jsonStr = gson.toJson(replayList);
				//System.out.println(jsonStr);
				//���ð�jsonStrд��ǰ��
				resp.getWriter().write(jsonStr);
	}

}
