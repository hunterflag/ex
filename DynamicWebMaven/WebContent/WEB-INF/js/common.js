/**
 * 
 */
alert("common.js")
console.log("common.js");
console.log(func());

function func(){
	console.log("${pageContext.request.contextPath}/js/common.js");
	return "${pageContext.request.contextPath}/js/common.js";
}