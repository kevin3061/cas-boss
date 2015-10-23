package tv.acframework.oss.boss.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tv.acframework.oss.boss.dao.RtsRoleRightsDAO;
import tv.acframework.oss.boss.entity.RtsRoleRights;
import tv.acframework.oss.boss.service.RtsRoleRightsService;

/**
 * @author xusm
 * 
 */
@Service("rtsRoleRightsService")
public class RtsRoleRightsServiceImpl implements RtsRoleRightsService {

	@Resource
	private RtsRoleRightsDAO rtsRoleRightsDAO;

	public void save(RtsRoleRights rtsRoleRights) {
		rtsRoleRightsDAO.save(rtsRoleRights);
	}
	
	public void delete(RtsRoleRights rtsRoleRights) {
		rtsRoleRightsDAO.delete(rtsRoleRights);
	}
	
	public RtsRoleRights get(Integer id) {
		return rtsRoleRightsDAO.get(id);
	}
	
	public boolean isExit(Integer roleId, Integer rightsId) {
		return rtsRoleRightsDAO.isExit(roleId, rightsId);
	}
	
	public List<RtsRoleRights> getListByRoleId(Integer roleId) {
		return rtsRoleRightsDAO.getListByRoleId(roleId);
	}
	
}
