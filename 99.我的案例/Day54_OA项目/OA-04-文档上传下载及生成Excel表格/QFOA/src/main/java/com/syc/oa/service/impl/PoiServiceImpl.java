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
import com.syc.oa.domain.TbUserExample.Criteria;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.PoiService;
import com.syc.oa.vo.PageBean;

@Service("poiService")
public class PoiServiceImpl implements PoiService {

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 该方法的返回值,就是返回excel文件的文件名
	 */
	@Override
	public String createExcel(String username) {

		// 根据username查询tb_user表
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%" + username + "%");
		List<TbUser> users = userMapper.selectByExample(example);

		// 分页设置
		PageBean<TbUser> bean = new PageBean<>();
		bean.setRows(users);
		bean.setTotal(users.size());

		// 将PageBean变为JSON数据
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(bean);
		// {"total":1,"rows":[{"loginame":"vvv","password":"111111","id":9,"createDate":1509638400000,"status":0,"username":"vvv"}]}
		// 得到JSONObject中的JSON数组
		JSONArray jsonArray = jsonObject.getJSONArray("rows");
		// 得到第一个对象
		JSONObject object = jsonArray.getJSONObject(0);
		// System.out.println("jsonObject="+jsonObject.toJSONString());

		// 用来存放JSON对象中的key
		List<String> keys = new ArrayList<>();
		for (String key : object.keySet()) {
			if (object.get(key) != null) {
				keys.add(key);
			}
		}

		// 开始创建Excel文件
		// HSSFWorkbook就是excel文件
		@SuppressWarnings("resource")
		HSSFWorkbook workBook = new HSSFWorkbook();
		// 创建Excel里的sheet,具体的文件
		HSSFSheet sheet = workBook.createSheet();
		// 创建第一行
		HSSFRow firstRow = sheet.createRow(0);
		for (int i = 0; i < keys.size(); i++) {
			// 在行中创建单元格
			HSSFCell cell = firstRow.createCell(i);
			// 第一行单元格的值填充完毕
			cell.setCellValue(keys.get(i));
		}

		// 创建第二行及其他行
		for (int i = 1; i <= jsonArray.size(); i++) {
			HSSFRow nextRow = sheet.createRow(i);
			JSONObject dataObject = jsonArray.getJSONObject(i - 1);

			// 给每一个单元格填充数据
			for (int j = 0; j < keys.size(); j++) {
				HSSFCell cell = nextRow.createCell(j);
				String key = keys.get(j);
				Object obj = dataObject.get(key);
				if (obj instanceof Date) {
					// 时间类型特殊处理
					cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj));
				} else {
					cell.setCellValue(obj.toString());
				}
			}
		}

		FileOutputStream stream = null;
		try {
			File file = new File("C:/OA/files" + File.separator + System.currentTimeMillis() + ".xls");
			if (!file.exists()) {
				// 创建文件
				file.createNewFile();
				// 将文件与输出流对接起来
				stream = FileUtils.openOutputStream(file);
				// 真正的将Excel文件,以输出流的形式,输出到某个文件夹下.
				workBook.write(stream);
				stream.flush();
				stream.close();
			}

			return file.getName();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
