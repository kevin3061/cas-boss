package tv.acframework.oss.boss.service;

import java.util.List;

import tv.acframework.oss.boss.entity.RtsMenu;
import tv.acframework.exception.ServiceException;

public interface RtsMenuService {

	public List <RtsMenu> listMenus() throws ServiceException;
	
	/**
	 * 查找所有子菜單
	 */
	public List <RtsMenu> listMenus(Integer parentId);
	
	/**
	 * 根据路径查询路径菜單
	 */
	public List <RtsMenu> listMenus(String path);
	
	/**
	 * 查找单个菜单信息
	 */
	public RtsMenu get(Integer id) throws ServiceException;

	/**
	 * 查找所有根菜单
	 */
	public List<RtsMenu> findRootMenuList() throws ServiceException;
	
	/**
	 * 查找所有菜单
	 */
	public List<RtsMenu> findAll() throws ServiceException;
	
	/**
	 * 查找所有可用菜单
	 */
	public List<RtsMenu> findAllMenuRights() throws ServiceException;
	
	/**
	 *從所有菜單中找子菜單
	 */
	public List<RtsMenu> findChildList(RtsMenu menu, List<RtsMenu> allMenuList);
	
	/**
	 * 添加menu
	 * @param menu
	 * @throws ServiceException
	 */
	public void add(RtsMenu menu) throws ServiceException;
	
	/**
	 * 更新menu
	 * @param menu
	 * @throws ServiceException
	 */
	public void update(RtsMenu menu) throws ServiceException;
	
	/**
	 * 删除menu
	 * @param menu
	 * @throws ServiceException
	 */
	public void delete(RtsMenu menu) throws ServiceException;
}
