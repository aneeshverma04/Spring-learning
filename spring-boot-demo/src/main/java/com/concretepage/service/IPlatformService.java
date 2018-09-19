package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.concretepage.entity.Platform;

@Component
public interface IPlatformService {
	List<Platform> getAllPlatforms();
	Platform getPlatformById(int platformId);
	boolean addPlatform(Platform platform);
    void updatePlatform(Platform platform);
    void deletePlatform(int platform);
}
