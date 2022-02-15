package tw.idv.hunterchen.batch.SpringBatch;

import org.springframework.batch.item.ItemProcessor;

import tw.idv.hunterchen.batch.SpringBatch.model.Report;

public class ReportItemProcessor implements ItemProcessor {
	public Report process(Report item) throws Exception {
		System.out.println("執行中..." + item);
		return item;
	}

	@Override
	public Object process(Object item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
