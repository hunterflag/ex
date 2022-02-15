package tw.idv.hunterchen.batch.SpringBatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import tw.idv.hunterchen.batch.SpringBatch.model.Report;

public class ReportFieldSetMapper implements FieldSetMapper {
	 
	 private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	 
	 public Report mapFieldSet(FieldSet fieldSet) throws BindException {
	  
	  Report report = new Report();
	  report.setId(fieldSet.readInt(0));
	  report.setSales(fieldSet.readBigDecimal(1));
	  report.setQty(fieldSet.readInt(2));
	  report.setStaffName(fieldSet.readString(3));
	  
	  //fieldSet.readDate(4); //預設的 format yyyy-MM-dd
	  String date = fieldSet.readString(4);
	  try {
	   report.setDate(dateFormat.parse(date));
	  } catch (ParseException e) {
	   e.printStackTrace();
	  }
	  
	  return report;
	  
	 }
	 
	}