/**
 * 序號機
 * 初次索取、無起始值：
 * 初次索取、有起始值：
 * 非初次索取、有起始值：
 */
function getSerialNo(initNo){
	//	參數初始化
	initNo = (typeof initNo == "undefined" ? 0 : initNo);
	//屬性變數：靜態、內部
	if (typeof getSerialNo.no == 'undefined'){
		getSerialNo.no=initNo;
	}

	
	
	return ++getSerialNo.no;
}
console.log(getSerialNo());
console.log(getSerialNo());
console.log(getSerialNo());
console.log(getSerialNo());