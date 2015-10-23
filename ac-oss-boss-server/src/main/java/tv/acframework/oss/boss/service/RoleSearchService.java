package tv.acframework.oss.boss.service;

import tv.acframework.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface RoleSearchService {

	public List<Map<String, Object>> getMapListByState(Integer status) throws ServiceException;
	
}
