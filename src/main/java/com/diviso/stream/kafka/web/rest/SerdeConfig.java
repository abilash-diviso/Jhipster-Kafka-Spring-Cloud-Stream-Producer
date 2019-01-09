package com.diviso.stream.kafka.web.rest;

import java.util.Collections;
import java.util.Map;

import org.apache.avro.specific.SpecificRecordBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.avro.Sensor;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerializer;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;

public class SerdeConfig<T extends SpecificRecordBase> extends SpecificAvroSerializer<T> {
private static Logger log=LoggerFactory.getLogger("Logger SerdeConfig");
	@Override
	public void configure(Map<String, ?> serializerConfig, boolean isSerializerForRecordKeys) {
		log.info("Enter into SerdeConfig "+serializerConfig);
		final Map<String, String> serdeConfig = Collections
				.singletonMap(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
		super.configure(serdeConfig, isSerializerForRecordKeys);
	}

}
