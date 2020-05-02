package com.enigmacamp.JasaQ.firebase;

import com.enigmacamp.JasaQ.entity.PushNotificationRequest;
import com.google.firebase.messaging.*;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FCMService {
	
	private Logger logger = LoggerFactory.getLogger(FCMService.class);
	
	public void sendMessage(Map<String, String> data, PushNotificationRequest request)
	throws InterruptedException, ExecutionException {
		Message message = getPreconfigureMessageWithData(data, request);
		String response = sendAndGetResponse(message);
		logger.info("Send message with data, Topic : " + request.getTopic()+ ", " + response);
	}
	
	public void sendMessageWithoutData(PushNotificationRequest request) 
	throws InterruptedException, ExecutionException {
		Message message = getPreconfigureMessageWithoutData(request);
		String response = sendAndGetResponse(message);
		logger.info("Send message without data , Topic : " + request.getTopic()+ ", " + response);
	}
	
	public void sendMessageToToken(PushNotificationRequest request) 
	throws InterruptedException, ExecutionException {
		Message message = getPreconfigureMessageToToken(request);
		String response = sendAndGetResponse(message);
		logger.info("Send message To Token, Token :" + request.getToken()+ ", " + response);
	}
	
	public String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
		return FirebaseMessaging.getInstance().sendAsync(message).get();
	}
	
	private AndroidConfig getAndroidConfig(String topic) {
		return AndroidConfig.builder()
				.setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
				.setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound(NotificationParameter.SOUND.getValue())
                        .setColor(NotificationParameter.COLOR.getValue()).setTag(topic).build()).build();
   }
	
	private ApnsConfig getApnsConfig(String topic) {
		return ApnsConfig.builder()
				.setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
	}
	
	private Message getPreconfigureMessageToToken(PushNotificationRequest request) {
		return getPreconfigureMessageBuilder(request).setToken(request.getToken()).build();
	}
	
	private Message getPreconfigureMessageWithoutData(PushNotificationRequest request) {
		return getPreconfigureMessageBuilder(request).setTopic(request.getTopic()).build();
	}
	
	private Message getPreconfigureMessageWithData(Map<String ,String> data, PushNotificationRequest request) {
		return getPreconfigureMessageBuilder(request).putAllData(data).setTopic(request.getTopic()).build();
	}
	
	private Message.Builder getPreconfigureMessageBuilder(PushNotificationRequest request) {
		AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
		ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
		return Message.builder().setApnsConfig(apnsConfig).setAndroidConfig(androidConfig)
				.setNotification(new Notification(request.getTitle(), request.getMessage()));
	}
}
