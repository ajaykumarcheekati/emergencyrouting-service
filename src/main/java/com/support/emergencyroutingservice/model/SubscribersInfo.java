package com.support.emergencyroutingservice.model;

import lombok.Data;

@Data
public class SubscribersInfo {
	
	private String subscriberId;
	private String message;
	private int statusCode;

}
