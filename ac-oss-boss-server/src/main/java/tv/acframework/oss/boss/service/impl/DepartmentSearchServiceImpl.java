package tv.acframework.oss.boss.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tv.acframework.oss.boss.dao.DepartmentDAO;
import tv.acframework.oss.boss.service.DepartmentSearchService;
import tv.acframework.exception.ServiceException;

/**
 * @author xusm
 * 
 */
@Service("departmentSearchService")
public class DepartmentSearchServiceImpl implements DepartmentSearchService {

	@Resource
	private DepartmentDAO departmentDAO;

	public List<Map<String, Object>> getMapListByAll() throws ServiceException {
		return departmentDAO.getMapListByAll();
	}

}
