package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbDept;
import com.syc.oa.vo.PageBean;

/**
 * 类名:DeptService
 * 类描述:部门业务接口类
 */
public interface DeptService {

    /**
     * 查询部门
     */
    public PageBean<TbDept> findDept(String dname);

    /**
     * findOneDept  查找一个部门对象通过id
     */
    public TbDept findDeptById(Integer id);

    /**
     * 新增部门
     */
    public boolean addDept(TbDept dept);
    
    /**
     * 修改部门
     */
    public boolean editDept(TbDept dept);

    /**
     * 删除一个部门
     */
    public void removeOneDept(Integer id);

    /**
     * 批量部门
     */
    public void removeMore(Integer[] ids);
    
    /**
     * 查找所有部门
     */
    public List<TbDept> findAll();

}
