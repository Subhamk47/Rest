package org.subham.javaworld.Messenger.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.subham.javaworld.Messenger.DTO.DataBase;
import org.subham.javaworld.Messenger.Entity.Profile;

public class ProfileService {
	
	private static final Logger LOGGER = Logger.getLogger(ProfileService.class.getName());
	
	private Map<String, Profile> profiles =  DataBase.getProfile();  
	
	@SuppressWarnings("deprecation")
	public ProfileService() {
		LOGGER.log(Level.INFO , "Profile Service Constructor Executed");
		profiles.put("subhamk47", new Profile(1,"subhamk47" , "subham" ,"kumar", new Date(2022, 12, 27)));
		profiles.put("VJ", new Profile(2,"VJ" , "Vijay" ,"Kejriwal", new Date(2022, 12, 27)));
	}
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String name) {
		return profiles.get(name);
	}
}

