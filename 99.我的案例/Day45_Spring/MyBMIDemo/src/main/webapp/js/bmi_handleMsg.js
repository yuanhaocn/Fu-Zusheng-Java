/**
 * 主要是用来处理bmi中的信息: 1.计算bmi指数并且在右上角的结果显示区域中显示bmi结果; 2.把计算好的bmi指数结果存储到数据库中.
 */

//计算BMI的值---bmi=体重/身高的平方(身高的单位是米)
function getBMIValue(weight,height){
	return weight/((height/100)*(height/100));
}

//计算理想体重
function getIdealWeight(height){
	return (height-100)*0.9;
}

//展示结果的函数
function showResult(sex,bmiValue,img,bmiResult,idealWeight){
	if("male"==sex){// 男性
		if(bmiValue<18.5){
			alert("亲,你太瘦了,一阵风就能把你刮跑...");
			img.src="img/male_01.jpg";
			bmiResult.innerHTML=bmiValue+" 偏瘦";
			bmiResult.style.background="rgb(135,206,230)";
			idealWeight.style.background="rgb(135,206,230)";
		}else if(bmiValue>=18.5&&bmiValue<24.0){
			alert("亲,你的体重正常,继续保持吧...");
			img.src="img/male_02.jpg";
			bmiResult.innerHTML=bmiValue+" 正常";
			bmiResult.style.background="rgb(180,230,180)";
			idealWeight.style.background="rgb(180,230,180)";
		}else if(bmiValue>=24.0&&bmiValue<28.0){
			alert("亲,你有点偏胖了,少吃点肉吧..");
			img.src="img/male_03.jpg";
			bmiResult.innerHTML=bmiValue+" 偏胖";
			bmiResult.style.background="yellow";
			idealWeight.style.background="yellow";
		}else{
			alert("亲,放弃吧,12级龙卷风都刮不走你..");
			img.src="img/male_04.jpg";
			bmiResult.innerHTML=bmiValue+" 胖到绝望";
			bmiResult.style.background="red";
			idealWeight.style.background="red";
		}
	}else{
		if(bmiValue<16.5){
			alert("亲,你太瘦了,一阵风就能把你刮跑...");
			img.src="img/female_01.jpg";
			bmiResult.innerHTML=bmiValue+" 偏瘦";
			bmiResult.style.background="rgb(135,206,230)";
			idealWeight.style.background="rgb(135,206,230)";
		}else if(bmiValue>=16.5&&bmiValue<22.0){
			alert("亲,你的体重正常,继续保持吧...");
			img.src="img/female_02.jpg";
			bmiResult.innerHTML=bmiValue+" 正常";
			bmiResult.style.background="rgb(180,230,180)";
			idealWeight.style.background="rgb(180,230,180)";
		}else if(bmiValue>=22.0&&bmiValue<26.0){
			alert("亲,你有点偏胖了,少吃点肉吧..");
			img.src="img/female_03.jpg";
			bmiResult.innerHTML=bmiValue+" 偏胖";
			bmiResult.style.background="yellow";
			idealWeight.style.background="yellow";
		}else{
			alert("亲,放弃吧,12级龙卷风都刮不走你..");
			img.src="img/female_04.jpg";
			bmiResult.innerHTML=bmiValue+" 胖到绝望";
			bmiResult.style.background="red";
			idealWeight.style.background="red";
		}
	}
}

//计算BMI
function calculator(){
	var height=eval($("#height").val());
	var weight=eval($("#weight").val());
	//获取name=sex的组件
	var sex=document.getElementsByName("sex");
	var sexValue;
	for(var i=0;i<sex.length;i++){
		if(sex[i].checked){
			sexValue=sex[i].id;
		}
	}
	
	//验证输入框的值非空
	if(height==null||weight==null||sexValue==null){
		alert("请输入完整的信息!");
	}
	
	//获取BMI值
	var value=getBMIValue(weight,height);
	//对计算出来的BMI值进行修正
	var bmiValue=Math.round(value*100)/100;
	
	//找到右侧的3个组件
	var img_result=document.getElementById("img_result");
	var bmi_result=document.getElementById("bmi_result");
	var bmi_idealWeight=document.getElementById("bmi_idealWeight");
	
	//得到理想体重
	var idealWeight=getIdealWeight(height);
	idealWeight=Math.round(idealWeight*100)/100;
	bmi_idealWeight.innerHTML=idealWeight+"千克";
	
	//显示结果的函数
	showResult(sexValue,bmiValue,img_result,bmi_result,bmi_idealWeight);
	
	//前端给后端传值
	//注意:此处不需要给recordTime赋值
	ajaxRequest("POST","addBMI.action","json",{"height":height,"weight":weight,"bmi":bmiValue,"bmiSign":new Date().getTime()},addBMI);
}

//数据添加成功后的回调函数
function addBMI(data){
	if(jQuery.isEmptyObject(data)){
		alert("数据为空!");
	}else{
		//清空表中原有内容
		$("#table_history").empty();
		//因为添加成功了,表中多了新的数据,需要重新加载查询.
		ajaxRequest("POST","queryBMI.action",null,null,queryBMI);
	}
}

