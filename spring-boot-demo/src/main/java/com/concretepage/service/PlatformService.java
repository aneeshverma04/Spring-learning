package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.Platform;
import com.concretepage.repository.PlatformRepository;

@Component
public class PlatformService implements IPlatformService {
	
	@Autowired
	private PlatformRepository platformrepository;
	
	@Override
	public List<Platform> getAllPlatforms() {
		List<Platform> list = new ArrayList<>();
		platformrepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Platform getPlatformById(int platformId) {
		Platform obj  = platformrepository.findById(platformId).get();
		return obj;
	}

	@Override
	public boolean addPlatform(Platform platform) {
		if (platformrepository.existsById(platform.getPlatformId())) {
        	return false;
        }else {
         platformrepository.save(platform);
         return true;
        }
	}

	@Override
	public void updatePlatform(Platform platform) {
		platformrepository.save(platform);
	}

	@Override
	public void deletePlatform(int platformId) {
		platformrepository.delete(getPlatformById(platformId));

	}

}
