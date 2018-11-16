package com.yatra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.commons.collections4.ListUtils;

import com.example.CustomerV1;

public class GenericRecord {

	public static void main(String[] args) {
		try {
			/*CustomerV1.Builder customerBuilder=CustomerV1.newBuilder();
			customerBuilder.setAge(1);
			customerBuilder.setFirstName("John");
			customerBuilder.setLastName("Doe");
			customerBuilder.setHeight(23f);
			CustomerV1 customer=customerBuilder.build();
			SpecificDatumWriter<CustomerV1> dataumWriter=new SpecificDatumWriter<CustomerV1>();
			DataFileWriter<CustomerV1> dataFileWriter=new DataFileWriter<CustomerV1>(dataumWriter);
			dataFileWriter.create(CustomerV1.getClassSchema(),new File("customer-new.avro") );
			dataFileWriter.append(customer);
			dataFileWriter.close();*/
			
		/*	SpecificDatumReader<CustomerV1> dataumReader=new SpecificDatumReader<CustomerV1>();
			DataFileReader<CustomerV1> dataFileReader=new DataFileReader<CustomerV1>(new File("customer-new.avro"), dataumReader);
			while(dataFileReader.hasNext()){
				CustomerV1 customer=dataFileReader.next();
				System.out.println(customer);
			}*/
			List<Integer> intList =new ArrayList();
			intList.add(2);
			intList.add(3);
			intList.add(4);
			intList.add(5);
		    List<List<Integer>> subSets = ListUtils.partition(intList, 3);
			
			for(List<Integer> subList:subSets){
				System.out.println(subList);
			}
				
			

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

}
