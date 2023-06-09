package org.lab.socialmaven.user;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.message.Message;
import org.lab.socialmaven.utils.RelationshipEnum;


public class User {
	private static final Logger logger = LogManager.getLogger(User.class);
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String email;
	private LocalDate dateOfBirth;
	private String location;
	private Address address;
	private PhoneNumber phoneNumber;
	private RelationshipEnum relationshipStatus;
	private String gender;
	private List<User> friends;
	private String workPlaceName;
	private String schoolName;
	private String universityName;
	// Add Individual and Group
	private String profilePicUrl;
	private boolean isOnline;
	private Integer ageFunc;

	public User(Integer id) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.friends = new ArrayList<>();
		this.phoneNumber = phoneNumber;

	}

	public User(String Username) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.friends = new ArrayList<>();
		this.phoneNumber = phoneNumber;
	}

	public User(String userName, String email) {
		this.userName = userName;
		this.email = email;
		this.friends = new ArrayList<>();
		// add Individual and group
		this.phoneNumber = phoneNumber;

	}

	public User(Integer id, String userName, String email) {
		this.userName = userName;
		this.email = email;
		this.friends = new ArrayList<>();
		// add Individual and group
		this.phoneNumber = phoneNumber;

	}

	public User(Integer id, LocalDate dateOfBirth, String email) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.email = email;

	}

	public User(Integer id, String userName, String profilePicUrl, boolean isOnline) {
		this.id = id;
		this.userName = userName;
		this.profilePicUrl = profilePicUrl;
		this.isOnline = isOnline;
	}

	public User(String userName,String firstName, Integer ageFunc, String email,String gender) {
		this.userName = userName;
		this.firstName = firstName;
		this.ageFunc = ageFunc;
		this.email = email;
		this.gender = gender;
	}

	User(String email, String firstName, String lastName, String dateOfBirth, String gender) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = LocalDate.parse(dateOfBirth);
		this.gender = gender;
	}

	public User(String userName, LocalDate dateOfBirth) {
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName() {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName() {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		LocalDate today = LocalDate.now();
		return Period.between(dateOfBirth, today).getYears();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation() {
		this.location = location;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public RelationshipEnum getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(RelationshipEnum relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender() {
		this.gender = gender;
	}

	public List<User> getFriends() {
		return friends;
	}

	public List<User> setFriends() {
		return friends;
	}

	public String getWorkPlaceName() {
		return workPlaceName;
	}

	public void setWorkPlaceName() {
		this.workPlaceName = workPlaceName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName() {
		this.schoolName = schoolName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName() {
		this.universityName = universityName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName() {
		this.userName = userName;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Integer getAgeFunc() {
		return ageFunc;
	}
	public void setAgeFunc(Integer ageFunc) {
		this.ageFunc = ageFunc;
	}
	public void register() {
		// registering a user on
		logger.debug("User " + this.userName + " registered successfully!");
	}

	public void editProfile(String firstName, String middleName, String lastName, String email, LocalDate dateOfBirth,
			String gender) {
		// editing user's profile
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		logger.debug("User " + this.userName + "'s profile has been updated.");
	}

	public void deleteProfile() {
		// deleting user's profile
		logger.debug("User " + this.userName + "'s profile has been deleted.");
	}

	/// add and remove friends
	public void addFriend(User friend) {
		friends.add(friend);
		friend.getFriends().add(this);
		logger.debug("User " + userName + "Friend = " + friend);
	}

	public void removeFriend(User friend) {
		friends.remove(friend);
		friend.getFriends().remove(this);
	}

	// send message to friend
	public void sendMessage(User friend, String message) {
		logger.debug("send message");

	}

	public void receiveMessage(Message message) {
		logger.debug("Received message:");
	}
	// don't forget create method chat between user and friend

	public String toString() {
		return "User{" + "id=" + id + ", username='" + userName + '\'' + '}';
	}
	public void displayUserProfile() {
		logger.info("userName: " + userName + " " + "First Name: " + firstName + " " + "gender: " + gender + "Email :" + email + "age " + ageFunc);

	}

}
