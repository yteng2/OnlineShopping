

function change(itemId){
/*	alert("value is" + $("select[name = 'amount']").val());
	alert("item is" + itemId);*/
	var url = "/OnlineShopping/changeItem id = "+itemId+" amount = "+$('#amount_'+itemId).val();
	console.log(url);
	var curprice = $('#curprice_'+itemId).text();
	var price = $('#price_'+itemId).val();
//	console.log(curprice);
//	console.log(price);
//	console.log($('#amount_'+itemId).val());
	
	$('#curprice_'+itemId).html(price*$('#amount_'+itemId).val());
	var total = $('#total').text();
	total = total - curprice + price*$('#amount_'+itemId).val();
	$('#total').html(total.toFixed(2));
	$.post(url);
	
};

function deleteItem(itemId){
	var url = "/OnlineShopping/deleteItem id = "+itemId;
	console.log(url);
	var curprice = $('#curprice_'+itemId).text();
	var total = $('#total').text();
	console.log(curprice);
	console.log(total);
	total = total-curprice;
	$.post(url);

	$('#total').html(total.toFixed(2));
	$('#'+itemId).remove();
	
};
