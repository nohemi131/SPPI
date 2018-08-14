package com.gs.sppi.ws.core.entities.services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestTO {

	private String userName;
	private String macAddress;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	@Override
	public String toString() {
		return "RequestTO [userName=" + userName + ", macAddress=" + macAddress + "]";
	}
	
}
