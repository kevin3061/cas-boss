package tv.acframework.oss.boss.service;

import java.util.List;
import java.util.Map;

import tv.acframework.exception.ServiceException;

public interface DepartmentSearchService {

	public List<Map<String, Object>> getMapListByAll() throws ServiceException;
	
}
