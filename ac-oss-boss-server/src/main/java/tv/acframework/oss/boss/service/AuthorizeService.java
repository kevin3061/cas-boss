package tv.acframework.oss.boss.service;

import java.util.Set;

import tv.acframework.oss.boss.entity.RtsRights;

public interface AuthorizeService {
	
	public Set<RtsRights> getAuthResource(String username);
	
	public Set<RtsRights> getAuthResource(Integer id);

}
