package com.diviso.stream.kafka.web.rest;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.ayoos.appointment.avro.Appointment;
import com.bytatech.ayoos.appointment.avro.ConsultationInfo;
import com.bytatech.ayoos.appointment.avro.Symptom;
import com.bytatech.ayoos.appointment.avro.Timing;
import com.diviso.stream.kafka.Customer;
import com.diviso.stream.kafka.config.MultipleProcessorsConfig;
import com.esotericsoftware.minlog.Log;
import com.example.avro.Contact;
import com.example.avro.Sensor;


/*@EnableSchemaRegistryClient*/
@RestController
@RequestMapping("/api/")
@SuppressWarnings("unused")
public class SensorResource {

	
	@Autowired
	private MultipleProcessorsConfig source;

	
	private Random random = new Random();
	
	
	@PostMapping("/customer")
	public Boolean sendCustomer() {
		
		return source.customer().send(MessageBuilder.withPayload(randomCustomer()).build());
	}
	
	private Customer randomCustomer() {
		Customer customer=Customer.newBuilder().setCustomerId(9809203816l).setCustomerName("Mayakk").build();
		
		return customer;
	}
	

	@RequestMapping(value = "/sensor", method = RequestMethod.POST)
	public Boolean sendMessage() {
		Boolean status=source.output().send(MessageBuilder.withPayload(randomSensor()).build());
		
		return status;
	}

	private Sensor randomSensor() {
		Sensor sensor = new Sensor();
		sensor.setId(/*UUID.randomUUID().toString() + "-v3"*/"myid");
		sensor.setAcceleration(/*random.nextFloat() * 10*/10f);
		sensor.setVelocity(/*random.nextFloat() * 100*/20f);
		sensor.setTemperature(/*random.nextFloat() * 50*/30f);
		sensor.setBrand("newbrand");
		sensor.setNumberint(32);
		Log.info("Sensor data to produce "+sensor);
		return sensor;
	}
	
	@PostMapping("/appointment")
	public Boolean sendAppointment() {
		
		return source.appointmentOut().send(MessageBuilder.withPayload(randomAppointment()).build());
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public Boolean sendContact() {
		return source.contact().send(MessageBuilder.withPayload(randomContact()).build());
	}
	
	private Appointment randomAppointment() {
		ZonedDateTime zonedDateTime=ZonedDateTime.now();
		System.out.println("Appointment Date Time is Producing "+zonedDateTime);
		long dateTimeAppointment=zonedDateTime.toInstant().toEpochMilli();
		System.out.println("Appointment Date Time is Producing milliseconds "+dateTimeAppointment);
		Appointment appointment=new Appointment();
		appointment.setAppointmentDateAndTime(dateTimeAppointment);
		appointment.setChronicDiseaseRef("fever");
		appointment.setAppointmentId( "APP-123577169");
		appointment.setDoctorId("doctor");
		appointment.setPatientId("patient");
		appointment.setTrackingId("AY-23223fhf232e2423");
		Timing timing=new Timing();
		timing.setDay(new Date().getTime());
		timing.setEndTime(100l);
		timing.setStartTime(500l);
		appointment.setTiming(timing);
		ConsultationInfo consultationInfo=new ConsultationInfo();
		consultationInfo.setHeight(172.1f);
		consultationInfo.setWeight(10f);
		consultationInfo.setAge(23);
		Symptom symptom1=new Symptom("cough", 3);
		Symptom symptom2=new Symptom("stomachache", 3);
		List<Symptom> list=Arrays.asList(symptom1,symptom2);
		consultationInfo.setSymptoms(list);
		appointment.setConsultationInfo(consultationInfo);
		return appointment;
		
	}
	
	private Contact randomContact() {
		Contact contact=new Contact();
		contact.setFirstName("abilash");
		contact.setLastName("sethumadhav");
		contact.setId("COxcxzcxzhh");
		return contact;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
