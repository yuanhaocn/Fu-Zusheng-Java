
var pro1={
	id:1,
	proName:"原子弹",
	price:10.0
}
var pro2={
	id:2,
	proName:"茶叶蛋",
	price:20.0
}
var pro3={
	id:3,
	proName:"氢弹",
	price:15.0
}
var pro4={
	id:4,
	proName:"方便面",
	price:2
}
var pro5={
	id:5,
	proName:"香烟",
	price:5.0
}
var pro6={
	id:6,
	proName:"八宝粥",
	price:4.0
}

//商品列表
var products=[pro1,pro2,pro3,pro4,pro5,pro6];

//用来遍历products数组
var index=0;

//数据内容--->td--->tr--->tbody--->table
//添加商品的函数
function addProducts(){
	
	//判断数组越界
	if(index>=products.length){
		alert("已无可添加的商品!");
		return;
	}
	
	var proTable=document.querySelector("table");
	
	//js生成节点,<tbody></tbody>
	var tbodyNode=document.createElement("tbody");
	//生成tr,<tr></tr>
	var trNode=document.createElement("tr");
	
	//循环生成td
	for(var i=0;i<7;i++){
		//生成td节点,<td></td>
		var tdNode=document.createElement("td");
		
		//将数据内容添加到td中
		switch(i){
			case 0://checkbox
				var cbx=document.createElement("input");
				cbx.setAttribute("type","checkbox");
				tdNode.appendChild(cbx);
			break;
			case 1:
				//创建文本节点
				//var txtNode=document.createTextNode(products[index].id);
				//tdNode.appendChild(txtNode);
				
				//第二种方式:
				tdNode.innerHTML=products[index].id;
			break;
			case 2://name,商品名称
				tdNode.innerHTML=products[index].proName;
			break;
			case 3://price单价
				tdNode.innerHTML=products[index].price;
			break;
			case 4://商品数量
				//创建+号节点
				var plusNode=document.createElement("button");
				//处理点击事件
				plusNode.setAttribute("onclick","plusFunc(this)");
				plusNode.innerHTML="+";
				
				//input输入框,数量
				var numNode=document.createElement("input");
				numNode.setAttribute("type","text");
				numNode.setAttribute("value","1");
				
				//创建-号节点
				var minusNode=document.createElement("button");
				//处理点击事件,-操作
				minusNode.setAttribute("onclick","minusFunc(this)");
				minusNode.innerHTML="-";
				
				//将生成的3个节点放到td中
				tdNode.appendChild(plusNode);
				tdNode.appendChild(numNode);
				tdNode.appendChild(minusNode);
			break;
			case 5://商品总价
				tdNode.innerHTML="总价:"+products[index].price;
			break;
			case 6://删除操作
				var aNode=document.createElement("a");
				aNode.setAttribute("href","#");
				//处理点击事件
				aNode.setAttribute("onclick","deleteNode(this)");
				aNode.innerHTML="删除";
				tdNode.appendChild(aNode);
			break;
		}
		
		//将td追加到tr中
		trNode.appendChild(tdNode);
	}
	
	//将tr追加到tbody中
	tbodyNode.appendChild(trNode);
	//往一个元素中追加子元素
	proTable.appendChild(tbodyNode);
	
	//改变products数组的下标索引值
	index++;
}

//实现删除功能
function deleteNode(obj){
	//obj--->就是a标签,最终找到了tbody
	var pNode=obj.parentNode.parentNode.parentNode;
	//删除a标签的爷爷标签--->tr
	pNode.removeChild(obj.parentNode.parentNode);
}

//加操作
function plusFunc(obj){
	var value=obj.nextElementSibling.value;
	console.log("log日志:"+value);
	//值自增1之后重新赋值
	obj.nextElementSibling.value=++value;
	
	//找obj(+)的父元素td,利用td去找到td的前一个节点.
	var price=obj.parentNode.previousElementSibling.innerHTML;
	//总价
	var total=price*value;
	//找到+号按钮父节点的下一个兄弟节点,然后赋值
	obj.parentElement.nextElementSibling.innerHTML="总价:"+total;
}

//减操作
function minusFunc(obj){
	//-按钮前一个节点的值
	var value=obj.previousElementSibling.value;
	if(value>0){
		//减一然后赋值
		obj.previousElementSibling.value=--value;
		//单价
		var price=obj.parentNode.previousElementSibling.innerHTML;
		//总价
		var total=price*value;
		obj.parentElement.nextElementSibling.innerHTML="总价:"+total;
	}
}
