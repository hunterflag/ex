package tw.idv.hunterchen.lab.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Iterator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0; i<5; i++) {
			String value = ""; 
			for(int j=0; j<=i; j++) {
				value += i;
			}
			list.add(value);
		}
		
		for(int i=0; i<list.size(); i++) {
			DevTool.showMessages(list.get(i));
		}
		
		for(String element: list) {
			DevTool.showMessages(element);
		}
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			DevTool.showMessages(element);
		}
		
		// Lambda
		iterator.forEachRemaining(element -> DevTool.showMessages(element));
		iterator.forEachRemaining(element -> {DevTool.showMessages(element);});
		
		//???
		iterator.forEachRemaining(new Consumer<String>() {
			@Override
			public void accept(String element) {
				DevTool.showMessages(element);
			}
			
		});
		
	}

}
