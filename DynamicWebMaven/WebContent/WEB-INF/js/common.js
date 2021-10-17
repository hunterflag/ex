/**
 * 
var serialNo = (function () {
					var i = 0;
					return function () {i++;};
				})();
 */

function showMessageWithSerialNo(message){
	// showMessageWithSerialNo.serialNo 屬性的初始化
	if(typeof showMessageWithSerialNo.serialNo == 'undefined'){
		showMessageWithSerialNo.serialNo=0; 
	}
	console.log(++showMessageWithSerialNo.serialNo + " : " + message);
}

function init(){ 
	message = "網頁載入時執行init() in common.js";
	showMessageWithSerialNo(message);
//	alert("網頁載入時執行init() in common.js");
}
console.log("------- common.js ------------");
showMessageWithSerialNo("common.js");

console.log(testFunc());
function testFunc(){
	showMessageWithSerialNo("testFunc");
	console.log("${pageContext.request.contextPath}/js/common.js");
	return "${pageContext.request.contextPath}/js/common.js";
}