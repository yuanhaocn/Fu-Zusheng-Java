

//实现删除功能
function deleteNode(obj){
	//obj--->就是a标签,最终找到了tbody
	var pNode=obj.parentNode.parentNode.parentNode;
	//删除a标签的爷爷标签--->tr
	pNode.removeChild(obj.parentNode.parentNode);
}

//加操作
function plusFunc(obj){
	//获取前一个节点的值
	var value=obj.previousElementSibling.value;
	console.log("log日志:"+value);
	//值自增1之后重新赋值
	obj.previousElementSibling.value=++value;
	
	//找obj(+)的父元素td,利用td去找到td的前一个节点.
	//var price=obj.parentNode.previousElementSibling.innerHTML;
	//总价
	//var total=price*value;
	//找到+号按钮父节点的下一个兄弟节点,然后赋值
	//obj.parentElement.nextElementSibling.innerHTML="总价:"+total;
}

//减操作
function minusFunc(obj){
	//-按钮前一个节点的值
	var value=obj.nextElementSibling.value;
	if(value>0){
		//减一然后赋值
		obj.nextElementSibling.value=--value;
		//单价
		//var price=obj.parentNode.previousElementSibling.innerHTML;
		//总价
		//var total=price*value;
		//obj.parentElement.nextElementSibling.innerHTML="总价:"+total;
	}
}
