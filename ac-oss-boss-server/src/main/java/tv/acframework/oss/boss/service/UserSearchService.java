package tv.acframework.oss.boss.service;

import tv.acframework.config.diamond.spring.ExtendedPropertyPlaceholderConfigurer;
import tv.acframework.exception.ServiceException;

import java.util.List;
import java.util.Map;


public interface UserSearchService {

	public List<Map<String, Object>> getMapListByState(Integer state, String keyword) throws ServiceException;
	
	public List<Map<String, Object>> getMapListByDepartment(Integer departmentId, String keyword) throws ServiceException;
	
	public List<Map<String, Object>> getMapListByRole(Integer roleId, String keyword) throws ServiceException;
	
}
