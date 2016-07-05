/**
 * 
 */
$(document).ready(function(){
	$.getJSON("ReadCookies", function(jsonData) {
		if(jsonData.auto==true){
			$("#username").val(jsonData.username);
			$("#password").val(jsonData.password);
			$("option[value='"+jsonData.role+"']").attr("selected","selected");
			$("#auto").attr("checked","checked");
			$('input').iCheck({
			    checkboxClass: 'icheckbox_square-blue',
			    radioClass: 'iradio_square-blue',
			    increaseArea: '20%'
			});
		}
	});
	$('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%'
	});
});

function sub(){
	$(".checked").children("#auto").attr("checked","checked");
	myForm.submit();
}