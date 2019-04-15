package com.syc.oa.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syc.oa.domain.TbUser;
import com.syc.oa.domain.TbUserExample;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.PoiService;
import com.syc.oa.vo.PageBean;

/**
 * 生成POI
 * @类名称:PoiServiceImpl
 * @创建人:一一哥
 * @创建时间:2018年3月6日 上午11:27:33
 */
@Service
public class PoiServiceImpl implements PoiService {

	@Autowired
	private TbUserMapper userMapper;
	
	@Override
	public String createExcel(String username)  {
		//大目标:生成excel
		//第一个小目标:查询数据库tb_user表;
		TbUserExample example=new TbUserExample();
		example.createCriteria().andUsernameLike("%"+username+"%");
		List<TbUser> users = userMapper.selectByExample(example);
		
		PageBean<TbUser> bean=new PageBean<>();
		bean.setRows(users);
		bean.setTotal(users.size());
		
		//第二个小目标:把表中的信息存储到excel中;
		//jsonObject={"total":2,"rows":[{"id":1,"loginname":"xxx"....},{....}]}
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(bean);
		//jsonArray=[{"id":1,"loginname":"xxx"....},{....}]
		JSONArray jsonArray = jsonObject.getJSONArray("rows");
		//firstObject={"id":1,"loginname":"xxx"....}
		JSONObject firstObject = jsonArray.getJSONObject(0);
		
		List<String> columns=new ArrayList<>();
		for(String key : firstObject.keySet()){
			if(firstObject.get(key)!=null){
				//将json中的key存储到集合中
				columns.add(key);
			}
		}
		
		//真正的创建Excel文件
		//创建一个"公文包"
		HSSFWorkbook book=new HSSFWorkbook();
		//创建sheet表
		HSSFSheet sheet = book.createSheet();
		//创建sheet中的行
		HSSFRow firstRow = sheet.createRow(0);
		for(int i=0;i<columns.size();i++){
			//创建单元格
			HSSFCell cell = firstRow.createCell(i);
			//给单元格赋值
			cell.setCellValue(columns.get(i));
			//cell.setCellStyle(style);
		}
		
		//从第二行开始,生成其他信息
		for(int i=1;i<=jsonArray.size();i++){
			HSSFRow row = sheet.createRow(i);
			
			JSONObject object = jsonArray.getJSONObject(i-1);
			for(int j=0;j<columns.size();j++){
				HSSFCell cell = row.createCell(j);
				Object value = object.get(columns.get(j));
				if(value instanceof Date){
					cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(value));
				}else{
					cell.setCellValue(value.toString());
				}
			}
		}
		
		//要将内存中的excle文件保存到磁盘中,并以.xls的格式保存.
		File file=new File("C:/OA/files"+File.separator+System.currentTimeMillis()+".xls");
		if(!file.exists()){
			//创建该文件
			try {
				file.createNewFile();
				FileOutputStream outputStream = FileUtils.openOutputStream(file);
				//将内存中的excle内容,输出到流中
				book.write(outputStream);
				
				book.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//返回文件名称
		return file.getName();
	}

}
