package tv.acframework.oss.boss.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tv.acframework.oss.boss.dao.RtsRoleDAO;
import tv.acframework.oss.boss.service.RoleSearchService;
import tv.acframework.exception.ServiceException;

/**
 * @author xusm
 * 
 */
@Service("roleSearchService")
public class RoleSearchServiceImpl implements RoleSearchService {

	@Resource
	private RtsRoleDAO rtsRoleDAO;

	public List<Map<String, Object>> getMapListByState(Integer status) throws ServiceException {
		return rtsRoleDAO.getMapListByState(status);
	}

}
