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

@Service
public class PoiServiceImpl implements PoiService {

	@Autowired
	private TbUserMapper userMapper;

	// 查询user表,并且将对应的数据生成excel文件,返回该excel文件名称.
	@Override
	public String createExcel(String username) {
		// 根据条件查询user表
		TbUserExample example = new TbUserExample();
		example.createCriteria().andUsernameLike("%" + username + "%");
		List<TbUser> users = userMapper.selectByExample(example);

		// 将集合转换为PageBean
		PageBean<TbUser> bean = new PageBean<>();
		bean.setRows(users);
		bean.setTotal(users.size());

		// 将PageBean转换为json数据.
		JSONObject object = (JSONObject) JSONObject.toJSON(bean);
		// {total:20,rows:[{id:1,username:'xxx',loginname:'xxx',....},{},{}....]}
		JSONArray jsonArray = object.getJSONArray("rows");
		// 从JSON数组中获取第一个对象
		JSONObject obj = jsonArray.getJSONObject(0);

		// 遍历该json对象所有的key
		List<String> keys = new ArrayList<>();
		for (String key : obj.keySet()) {
			if (obj.get(key) != null) {
				keys.add(key);
			}
		}

		// 创建Excel文件.
		// HSSF时poi提供的一个关于excel的类.
		// HSSFWorkbook相当于是整个大的excel文件,也就是一个"公文包"
		HSSFWorkbook book = new HSSFWorkbook();
		// 创建excel中的sheet
		HSSFSheet sheet = book.createSheet();
		// 在sheet中创建第一行
		HSSFRow firstRow = sheet.createRow(0);
		// 在第一行中创建对应的单元格
		for (int i = 0; i < keys.size(); i++) {
			HSSFCell cell = firstRow.createCell(i);
			// 设置单元格样式
			// cell.setCellStyle(HSSFCellStyle.ALIGN_CENTER);
			// 给每一个单元格赋值
			cell.setCellValue(keys.get(i));
		}

		// 创建sheet中的第二行及以后的N行.
		for (int i = 1; i <= jsonArray.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			// 取出数组中的每一个对象
			JSONObject dataObject = jsonArray.getJSONObject(i - 1);

			// 再次写个循环,遍历出对象中的每一个数据
			for (int j = 0; j < keys.size(); j++) {
				HSSFCell cell = row.createCell(j);
				Object data = dataObject.get(keys.get(j));
				if (data instanceof Date) {
					cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(data));
				} else {
					cell.setCellValue(data.toString());
				}
			}
		}

		try {
			// 将生成的excle文件,输出保存到服务器的某个路径下,供别人下载!
			File file = new File("C:/OA/files" + File.separator + System.currentTimeMillis() + ".xls");
			if (!file.exists()) {

				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				// 将内存中创建的excle文件,通过输出流输出到某个路径下
				book.write(stream);
				
				book.close();
				stream.flush();
				stream.close();
			}
			
			//将excle文件的名称返回.
			return file.getName();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
