/*package com.diviso.stream.kafka;

import java.io.IOException;
import java.io.Serializable;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.SerializableByConvention;
import com.hazelcast.nio.serialization.StreamSerializer;


public class CustomerCacheSerializer implements StreamSerializer<Customer> {

	@Override
	public int getTypeId() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(ObjectDataOutput out, Customer object) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(object.getCustomerName());
	}

	@Override
	public Customer read(ObjectDataInput in) throws IOException {
		// TODO Auto-generated method stub
		String surname = in.readUTF();
		Customer customer=new Customer();
		customer.setCustomerName(surname);
	    return customer;
		
	}

}
*/