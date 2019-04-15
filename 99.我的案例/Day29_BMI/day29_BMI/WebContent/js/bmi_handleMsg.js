/**
 * 主要是用来处理bmi中的信息: 1.计算bmi指数并且在右上角的结果显示区域中显示bmi结果; 2.把计算好的bmi指数结果存储到数据库中.
 */

// 计算BMI指数
var getBMI=function(weight,height){
	// weight/height*height,height单位必须是米.
	return weight/((height/100)*(height/100));
}

// 理想体重
var getIdealWeight=function(height){
	return (height-100)*0.9;
}

//处理返回来的数据
var addBMI=function(data){
	if(jQuery.isEmptyObject(data)){
		alert("数据为空!");
	}else{
		//清空掉原有的表格
		$("#table_history").empty();
		
		var url=localhost+"bmi?method=queryBMI";
		//queryBMI:是查询成功后的回调方法.
		ajaxRequest("GET",url,"json",null,queryBMI);
	}
}

// 显示结果的方法
var showResult=function(sex,bmiValue,img,bmiResult,idealWeight){
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

function calculator(){
	// eval(1+2)--->计算string的函数.
	
	// var height=eval($("#height").val());
	// var weight=eval($("#weight").val());
	
	var height=eval(document.getElementById("height").value);
	var weight=eval(document.getElementById("weight").value);
	var sex=document.getElementsByName("sex");
	var sexValue;
	for(var i=0;i<sex.length;i++){
		if(sex[i].checked){
			sexValue=sex[i].id;
		}
	}
	
	// 验证数据完整性
	if(height==null||weight==null||sexValue==null){
		return alert("请输入完整的信息!");
	}
	
	// 计算BMI
	var value=getBMI(weight,height);
	var bmiValue=Math.round(value*100)/100;
	
	var img_result=document.getElementById("img_result");
	var bmi_result=document.getElementById("bmi_result");
	var bmi_idealWeight=document.getElementById("bmi_idealWeight");
	
	// 显示理想体重
	var heightValue=getIdealWeight(height);
	var idealWeight=Math.round(heightValue*100)/100;
	bmi_idealWeight.innerHTML=idealWeight+" 千克";
	
	// 显示结果
	showResult(sexValue,bmiValue,img_result,bmi_result,bmi_idealWeight);
	
	var url=localhost+"bmi?method=addBMI";
	
	// 利用ajax给Servlet传递数据
	ajaxRequest("POST",url,"json",{"recordTime":"2017-08-04","height":height,"weight":weight,"bmi":bmiValue,"bmiSign":new Date().getTime()},addBMI);
	
}