this.commonJS = new CommonClass(); 

function CommonClass(){
	this.callAjax = function(url, type, data, successAction, failureAction) {
		$.ajax({
			url : url,
			type : type,
			data : data,
			accept: 'application/json',
			contentType:'application/json',
			dataType : 'json',
			beforeSend: function(xmlHttpRequest) {
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			success : function(response, status, xhr) {
				if (successAction != null) {
					successAction(response, status, xhr);
				}
			},
			error : function(xhr, status, errorThrown) {
				if (failureAction != null) {
					failureAction(xhr, status, errorThrown);
				} else {
					if(xhr.status == 200){
						return false;
					}
				}
			}
		});
	};
}