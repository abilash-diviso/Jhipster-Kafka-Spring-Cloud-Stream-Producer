package com.diviso.stream.kafka.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface MultipleProcessorsConfig {

	String SENSOR="sensor";
	String APPOINTMENT="appointment";
	String CONTACT="contact";
	String CUSTOMER="customer";
	
	@Output(SENSOR)
	MessageChannel output();
	
	@Output(APPOINTMENT)
	MessageChannel appointmentOut();
	
	@Output(CONTACT)
	MessageChannel contact();
	
	@Output(CUSTOMER)
	MessageChannel customer();
}
