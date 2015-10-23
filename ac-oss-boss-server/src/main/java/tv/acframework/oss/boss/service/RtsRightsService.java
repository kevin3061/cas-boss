package tv.acframework.oss.boss.service;

import tv.acframework.oss.boss.entity.RtsRights;
import tv.acframework.exception.ServiceException;

public interface RtsRightsService {
	
	public RtsRights get(Integer id) throws ServiceException;
	
}
