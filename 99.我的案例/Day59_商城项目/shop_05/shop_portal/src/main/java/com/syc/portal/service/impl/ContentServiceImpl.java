package com.syc.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.syc.common.utils.HttpClientUtil;
import com.syc.common.utils.ShopResult;
import com.syc.pojo.TbContent;
import com.syc.portal.service.ContentService;

/**
 * 内容管理的服务接口
 * @类名称:ContentServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月21日 下午10:16:12
 */
@Service
public class ContentServiceImpl implements ContentService{

	//rest服务的基础url
	@Value("${SERVICE_BASE_URL}")
	private String SERVICE_BASE_URL;
	//轮播广告图的url
	@Value("${INDEX_AD1_URL}")
	private String INDEX_AD1_URL;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbContent> getContentList(long categoryId) {
		
		//调用服务层的服务
		String responseMsg = HttpClientUtil.doGet(SERVICE_BASE_URL+INDEX_AD1_URL+categoryId);
		
		//将rest服务层的响应详细转换为Java对象
		ShopResult result = ShopResult.formatToList(responseMsg, TbContent.class);
		
		if(result.getStatus()==200){
			return (List<TbContent>) result.getData();
		}
		
		return null;
	}

}
