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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syc.oa.domain.TbUser;
import com.syc.oa.domain.TbUserExample;
import com.syc.oa.domain.TbUserExample.Criteria;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.PoiService;
import com.syc.oa.vo.PageBean;

/**
 * 报表管理的Service实现类
 */
@Service("poiService")
@Transactional(isolation = Isolation.DEFAULT, readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PoiServiceImpl implements PoiService {

	@Autowired
	private TbUserMapper userMapper;

	@SuppressWarnings("resource")
	@Override
	public String generateExcel(String username) {

		// 根据用户名进行模糊查询,得到tb_user表的集合
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%" + username + "%");
		List<TbUser> users = userMapper.selectByExample(example);
		for (TbUser user : users) {
			user.setDocuments(null);
			user.setSigns(null);
		}

		// 进行分页
		PageBean<TbUser> bean = new PageBean<>();
		bean.setRows(users);
		bean.setTotal(users.size());

		// 将PageBean转为JSONObject对象
		JSONObject json = (JSONObject) JSONObject.toJSON(bean);
		// json格式:{"total":1,"rows":[{"loginame":"syc","password":"111111","createdate":1509206400000,"id":3,"status":1,"username":"syc"}]}
		// System.out.println("jsonObj="+jsonObject.toJSONString());
		// 取出json对象中的rows数组.
		JSONArray jsonArray = json.getJSONArray("rows");
		// 取rows数组中的第一个对象.
		JSONObject object = jsonArray.getJSONObject(0);

		// 定义一个List集合,存放JavaBean的属性名称
		List<String> keys = new ArrayList<>();
		for (String key : object.keySet()) {
			// 如果键的值不为null,则视为有效
			if (object.get(key) != null) {
				keys.add(key);
			}
		}

		// 创建一个Excel文件
		HSSFWorkbook workBook = new HSSFWorkbook();
		// 创建一个Excel里的Sheet
		HSSFSheet sheet = workBook.createSheet();
		// 创建sheet里的第一行
		HSSFRow firstRow = sheet.createRow(0);
		// 创建出第一行里的每一个cell单元格
		for (int i = 0; i < keys.size(); i++) {
			HSSFCell cell = firstRow.createCell(i);
			// 给单元格赋值
			cell.setCellValue(keys.get(i));
		}

		// sheet表的数据行
		// JSONArray中保存了所有的数据
		for (int i = 1; i <= jsonArray.size(); i++) {
			// 从第二行开始创建数据行
			HSSFRow nextRow = sheet.createRow(i);
			// 获取所有的数据对象
			JSONObject dataObject = jsonArray.getJSONObject(i - 1);
			// 每一行的列数,与keys的数量相同
			for (int j = 0; j < keys.size(); j++) {
				HSSFCell dataCell = nextRow.createCell(j);
				//根据key取出对应的值
				Object obj = dataObject.get(keys.get(j));
				// 给单元格设置文本内容
				if (obj instanceof Date) {
					dataCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj));
				} else {
					dataCell.setCellValue(obj.toString());
				}
			}
		}

		FileOutputStream stream = null;
		try {
			// 文件不存在时则创建出该文件
			// 创建文件
			File file = new File("c:/OA/files" + File.separator + System.currentTimeMillis() + ".xls");
			if (!file.exists()) {
				// 创建文件
				file.createNewFile();
				stream = FileUtils.openOutputStream(file);
				// 将文件流输出成文件
				workBook.write(stream);
				stream.flush();
				stream.close();
				return file.getName();
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

}
