package com.pluralsight.udtf;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.IntObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

@Description(name = "DateSet"
  ,value = "_FUNC_(start, end, format) - "
  ,extended = "Generates a table result set with (end - start) and a single date string column according to input format.")
public class DateSet extends GenericUDTF {
	 private PrimitiveObjectInspector stringOIParam1 = null;
	 private IntObjectInspector intOIParam2 = null;
	 private PrimitiveObjectInspector stringOIParam3 = null;
	 Object[] forwardObj = null;

	@Override
	public StructObjectInspector initialize(ObjectInspector[] argsOIs) throws UDFArgumentException {
 		if (argsOIs.length != 3) {
      		throw new UDFArgumentException("GenDates() takes three arguments. Use DESCRIBE FUNCTION [EXTENDED] for usage");
    	}

		if (argsOIs[0].getCategory() != ObjectInspector.Category.PRIMITIVE
	        && ((PrimitiveObjectInspector) argsOIs[0]).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING) {
	      throw new UDFArgumentException("First parameter expecting a STRING");
	    }
	 
	    if (argsOIs[1].getCategory() != ObjectInspector.Category.PRIMITIVE
	        && ((PrimitiveObjectInspector) argsOIs[1]).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.INT) {
	      throw new UDFArgumentException("Second parameter expecting an INT");
	    }

	    if (argsOIs[2].getCategory() != ObjectInspector.Category.PRIMITIVE
	        && ((PrimitiveObjectInspector) argsOIs[2]).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING) {
	      throw new UDFArgumentException("Third parameter expecting a STRING");
	    }

		stringOIParam1 = (PrimitiveObjectInspector) argsOIs[0];
		intOIParam2 = (IntObjectInspector) argsOIs[1];
		stringOIParam3 = (PrimitiveObjectInspector) argsOIs[2];

		this.forwardObj = new Object[1];

	    ArrayList<String> fieldNames = new ArrayList<String>();
	    fieldNames.add("dstring");
	    ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
	    fieldOIs.add( PrimitiveObjectInspectorFactory.getPrimitiveJavaObjectInspector(PrimitiveObjectInspector.PrimitiveCategory.STRING) );

	    return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
	}

	 @Override
	  public void process(Object[] record) throws HiveException {

	    String start = (String) stringOIParam1.getPrimitiveJavaObject(record[0]); //"2008-01-01"

	    int daysIncrement = intOIParam2.get(record[1]);

	    String format = (String) stringOIParam1.getPrimitiveJavaObject(record[2]); //"yyyy-MM-dd"
	 
	    if (start == null || format == null) {
	      return;
	    }

	    try
	    {

	      SimpleDateFormat sdf = new SimpleDateFormat(format);
	      Calendar c = Calendar.getInstance();
	      c.setTime(sdf.parse(start));

	      for (int i = 0; i < daysIncrement; i++)
	      {
	      	// forward output for first record then increment
	        forward(new Object[] {new Text( sdf.format(c.getTime()).toString() )});
	        c.add(Calendar.DATE, 1);  // number of days to add
	      }
	    }
	    catch (java.text.ParseException e) {return;}
	  }

	@Override
	public void close() throws HiveException {

	}

}