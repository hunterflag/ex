package tw.idv.hunterchen.utility.phone;

import lombok.Data;

@Data
public class NSPhone {
	String districtCode;	//國碼 		(0, 4)
	String araeCode;		//區碼 		(0, 4)	(0([2-8]|9[\d]{1,2}))*
	String phoneNo;			//電話號碼	(		[\d]{6,8}
	String ExtendedNo;		//分機		(0+)	[\d]*
	
	
}
