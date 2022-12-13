package com.support.emergencyroutingservice.conroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.support.emergencyroutingservice.model.RequestSubscribers;
import com.support.emergencyroutingservice.model.ResponseSubscribers;
import com.support.emergencyroutingservice.model.SubscribersInfo;
import com.support.emergencyroutingservice.model.SubscribersInfoResponse;

@RestController
@RequestMapping("/services/emergencyrouting/22.03/")
public class SubscribersController {
	
	@PostMapping("/dynamic/getSubscribers")
	public ResponseSubscribers getSubscribers(@RequestBody RequestSubscribers request) {
		
		System.out.println("Request body" +request.toString());
		
		
		List<String> subscriberIds = request.getSubscribersInfo().getSubscriberIds();
		
		ResponseSubscribers responseSubscribers = new ResponseSubscribers();
		SubscribersInfoResponse subscribersInfoResponse = new SubscribersInfoResponse();
		
		List<SubscribersInfo> listOfSubscribersInfo = new ArrayList<>();
		 
		
		for(String subscriberId: subscriberIds) {
			SubscribersInfo subscribersInfo = new SubscribersInfo();
			if(findSubscriber(subscriberId)) {
			
				 subscribersInfo.setSubscriberId(subscriberId);
				 subscribersInfo.setMessage("Successfully Retrieved");
				 subscribersInfo.setStatusCode(200);
			}else {
				 subscribersInfo.setSubscriberId(subscriberId);
				 subscribersInfo.setMessage("Specified Subscriber not found");
				 subscribersInfo.setStatusCode(404);
			}
			
			listOfSubscribersInfo.add(subscribersInfo);
		}
		
		subscribersInfoResponse.setSubscribersInfo(listOfSubscribersInfo);
		responseSubscribers.setSubscribersInfoResponse(subscribersInfoResponse);
		
		return responseSubscribers;
	}
	
	
	private boolean findSubscriber(String subscriberId){
		
		List<String> list = Arrays.asList(new String[]{"234234234", "234234235"});
		
		return list.contains(subscriberId);
		
	}

}
