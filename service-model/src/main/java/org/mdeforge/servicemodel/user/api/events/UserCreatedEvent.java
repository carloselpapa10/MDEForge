package org.mdeforge.servicemodel.user.api.events;

import org.mdeforge.servicemodel.user.api.info.UserInfo;


public class UserCreatedEvent implements UserDomainEvent{

	private UserInfo userInfo;

	public UserCreatedEvent() {}
	
	public UserCreatedEvent(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
