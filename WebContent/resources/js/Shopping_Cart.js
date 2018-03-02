

function change(itemId){
/*	alert("value is" + $("select[name = 'amount']").val());
	alert("item is" + itemId);*/
	var url = "/OnlineShopping/changeItem id = "+itemId+" amount = "+$("select[name = 'amount']").val();
	console.log(url);
	$.post(url);
};

function deleteItem(itemId){
	var url = "/OnlineShopping/deleteItem id = "+itemId;
	console.log(url);
	$.post(url);
};
