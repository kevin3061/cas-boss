package tv.acframework.oss.boss.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tv.acframework.oss.boss.dao.RtsRightsDAO;
import tv.acframework.oss.boss.entity.RtsRights;
import tv.acframework.oss.boss.service.RtsRightsService;
import tv.acframework.exception.ServiceException;

@Service("rtsRightsService")
public class RtsRightsServiceImpl implements RtsRightsService {

	@Resource
	private RtsRightsDAO rtsRightsDAO;

	public RtsRights get(Integer id) throws ServiceException {
		return rtsRightsDAO.get(id);
	}

}
