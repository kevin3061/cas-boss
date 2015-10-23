package tv.acframework.oss.boss.service;

import tv.acframework.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface DepartmentSearchService {

	public List<Map<String, Object>> getMapListByAll() throws ServiceException;
	
}
