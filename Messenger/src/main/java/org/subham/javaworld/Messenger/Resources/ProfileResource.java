package org.subham.javaworld.Messenger.Resources;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.subham.javaworld.Messenger.Entity.Profile;
import org.subham.javaworld.Messenger.Service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private static final Logger LOGGER = Logger.getLogger(ProfileResource.class.getName());
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		LOGGER.log(Level.INFO, "start of method getProfiles() :");
		return profileService.getProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		LOGGER.log(Level.INFO, "start of method getProfile() : {0}", profileName);
		return profileService.getProfile(profileName);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String profileName) {
		LOGGER.log(Level.INFO, "start of method deleteProfile() : {0}", profileName);
		return profileService.removeProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName , Profile profile) {
		LOGGER.log(Level.INFO, "start of method updateProfile() : {0}", profileName);
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		LOGGER.log(Level.INFO, "start of method addProfile() : ");
		return profileService.addProfile(profile);
	}
}
