package tv.acframework.oss.boss.service;

import java.util.List;

import tv.acframework.oss.boss.entity.Department;
import tv.acframework.exception.ServiceException;

public interface DepartmentService {
	
	public Department get(Integer id) throws ServiceException;
	
	/**
	 * 查找所有子菜單
	 */
	public List <Department> getChildrenDepartmentList(Integer parentId);
	
	/**
	 * 根据路径查询路径菜單
	 */
	public List <Department> getDepartmentListByPath(String path);

	/**
	 * 查找所有根部门
	 */
	public List<Department> findRootDepartmentList() throws ServiceException;
	
	/**
	 * 查找所有部门
	 */
	public List<Department> findAll() throws ServiceException;
	
	
	/**
	 *從所有菜單中找子菜單
	 */
	public List<Department> findChildList(Department department, List<Department> allDepartmentList);
	
	/**
	 * 添加department
	 * @param department
	 * @throws ServiceException
	 */
	public void add(Department department) throws ServiceException;
	
	/**
	 * 更新department
	 * @param department
	 * @throws ServiceException
	 */
	public void update(Department department) throws ServiceException;
	
	/**
	 * 删除department
	 * @param department
	 * @throws ServiceException
	 */
	public void delete(Department department) throws ServiceException;

}
