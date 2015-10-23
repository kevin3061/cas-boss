package tv.acframework.oss.boss.service;

import java.util.List;

import tv.acframework.oss.boss.entity.RtsFunctions;
import tv.acframework.oss.boss.entity.RtsMenu;
import tv.acframework.oss.boss.entity.RtsRole;
import tv.acframework.exception.ServiceException;
import tv.acframework.model.Search;
import tv.acframework.model.page.Pagination;

public interface RtsRoleService {

	public Pagination getList(Pagination page, Search search);
	
	/**
	 * 新添加
	 */
	public void add(RtsRole role, String[] rightsIds) throws ServiceException;
	
	/**
	 * 更新ROLE
	 */
	public void update(RtsRole role, String[] rigthsIds) throws ServiceException;
	
	/**
	 * 根据id查找role
	 *
	 * @return
	 */
	public RtsRole get(Integer id) throws ServiceException;
	
	/**
	 * 删除ROLE
	 * 
	 * @throws ServiceException
	 */
	public void delete(Integer id) throws ServiceException;
	
	/**
	 * 查找某角色拥有的菜单资源
	 * 
	 * @return
	 */
	public List<RtsMenu> findHaveMenuRights(Integer roleId) throws ServiceException;

	/**
	 * 查找某角色拥有的方法资源
	 */
	public List<RtsFunctions> findHaveFunctionRights(Integer roleId) throws ServiceException;
	
	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public List<RtsRole> findAll() throws ServiceException;
	
	public boolean isUniqueByName(String oldName, String newName);
}
