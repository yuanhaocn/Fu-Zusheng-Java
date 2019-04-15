
//BMI计算公式=体重/身高(单位是米)的平方
function getBMIValue(height,weight){
	return weight/((height/100)*(height/100));
}

//计算理想体重---->(身高-100)*0.9
function getIdealWeight(height){
	return (height-100)*0.9;
}

//负责展示前端数据
function showResult(sexValue,bmiValue,img,bmiResult,bmi_idealWeight){
	if("male"==sexValue){//男性
		if(bmiValue<18.5){
			alert("亲,你太瘦了,一阵风就可以把你刮走...");
			img.src="img/male_01.jpg";
			bmiResult.innerHTML=bmiValue+" 偏瘦";
			bmiResult.style.background="rgb(135,205,180)";
			bmi_idealWeight.style.background="rgb(135,205,180)";
		}else if(bmiValue>=18.5&&bmiValue<24){
			alert("亲,你是正常的,请继续保持...");
			img.src="img/male_02.jpg";
			bmiResult.innerHTML=bmiValue+" 正常";
			bmiResult.style.background="rgb(70,200,90)";
			bmi_idealWeight.style.background="rgb(70,200,90)";
		}else if(bmiValue>=24&&bmiValue<28){
			alert("亲,你有点胖了,少吃肉吧!");
			img.src="img/male_03.jpg";
			bmiResult.innerHTML=bmiValue+" 偏胖";
			bmiResult.style.background="yellow";
			bmi_idealWeight.style.background="yellow";
		}else{
			alert("亲,你已经胖出了高度,放弃吧!");
			img.src="img/male_04.jpg";
			bmiResult.innerHTML=bmiValue+" 肥胖";
			bmiResult.style.background="red";
			bmi_idealWeight.style.background="red";
		}
	}else{//女性
		if(bmiValue<16.5){
			alert("亲,你太瘦了,一阵风就可以把你刮走...");
			img.src="img/female_01.jpg";
			bmiResult.innerHTML=bmiValue+" 偏瘦";
			bmiResult.style.background="rgb(135,205,180)";
			bmi_idealWeight.style.background="rgb(135,205,180)";
		}else if(bmiValue>=16.5&&bmiValue<22){
			alert("亲,你是正常的,请继续保持...");
			img.src="img/female_02.jpg";
			bmiResult.innerHTML=bmiValue+" 正常";
			bmiResult.style.background="rgb(70,200,90)";
			bmi_idealWeight.style.background="rgb(70,200,90)";
		}else if(bmiValue>=22&&bmiValue<26){
			alert("亲,你有点胖了,少吃肉吧!");
			img.src="img/female_03.jpg";
			bmiResult.innerHTML=bmiValue+" 偏胖";
			bmiResult.style.background="yellow";
			bmi_idealWeight.style.background="yellow";
		}else{
			alert("亲,你已经胖出了高度,放弃吧!");
			img.src="img/female_04.jpg";
			bmiResult.innerHTML=bmiValue+" 肥胖";
			bmiResult.style.background="red";
			bmi_idealWeight.style.background="red";
		}
	}
}

//计算BMI
function calculator(){
	//得到身高和体重
	var height=eval($("#height").val());
	var weight=eval($("#weight").val());
	
	//性别
	var sexValue;
	var sex=document.getElementsByName("sex");
	for(var i=0;i<sex.length;i++){
		if(sex[i].checked){
			//得到了选中的RadioButton的值
			sexValue=sex[i].id;
		}
	}
	
	//验证数据
	if(height==null||weight==null||sexValue==null){
		return alert("请输入完整信息!");
	}
	
	//计算BMI值
	var value=getBMIValue(height,weight);
	//对bmi的计算结果做个修正
	var bmiValue=Math.round(value*100)/100;
	
	//获取理想体重
	var idealWeight=getIdealWeight(height);
	idealWeight=Math.round(idealWeight*100)/100;
	
	//找到所需的控件
	var img_result=document.getElementById("img_result");
	var bmi_result=document.getElementById("bmi_result");
	var bmi_idealWeight=document.getElementById("bmi_idealWeight");
	
	//给控件赋值
	bmi_idealWeight.innerHTML=idealWeight+"千克";
	
	//显示前端数据
	showResult(sexValue,bmiValue,img_result,bmi_result,bmi_idealWeight);

	//向后端发起添加数据的请求
	ajaxRequest("POST","addBMI.action","json",{"height":height,"weight":weight,"bmi":bmiValue,"bmisign":new Date().getTime()},addBMI);
}

//添加成功后的回调函数
function addBMI(data){
	if(jQuery.isEmptyObject(data)){
		alert("数据为空!");
	}else{
		//清空表中原有的内容
		$("#table_history").empty();
		
		//前端向后端发起查询请求!
		ajaxRequest("POST","queryBMI.action",null,null,queryBMI);
	}
}



