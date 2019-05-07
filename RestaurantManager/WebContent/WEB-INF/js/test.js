// 如果数据是来自HTML表单的名/值对，使用 application/x-www.form-urlencode 格式
function encodeFormData(data) {
    if(!data) return "";  //一直返回字符串
    var pairs = [];       // 保存名值对
    for(var name in data){
        if(! data.hasOwnProperty(name)) continue;   // 跳过继承属性
        if(typeof data[name] == "function") continue;   //跳过方法
        var value = data[name].toString();    // 把值转为字符串
        name = encodeURIComponent(name.replace("%20","+"));  // 编码名字和值
        value = encodeURIComponent(value.replace("%20","+"));
        pairs.push(name+"="+value);
    }
}

// 使用表单数据发送一个HTTP POST 请求
function  postData( url,data,callback) {
    var request = new XMLHttpRequest();
    request.open("POST",url);
    request.onreadystatechange = function () {
        if(request.readyState == 4 && callback){
            callback(request);
        }
    };
    request.setRequestHeader("Content-Type","application/x-www-from-urlencoded");
    request.send(encodeFormData(data));
}

// 使用表单编码数据发起 GET请求
function  getData(url,data,callback) {
    var request = new XMLHttpRequest();
    requset.open("GET",url+"?"+encodeFormData(data));
    request.onreadystatechange = function () {
        if(request.readyState==4 && callback){
            callback(request);
        }
    };
    request.send(null);
}

// 解析HTTP响应
function get(url,callback) {
    var request = new XMLHttpRequest();
    requset.open("GET",url);
    request.onreadystatechange = function () {
        if(request.readyState==4 && request.status==200){
            var type = request.getResponseHeader("Content-Type");
            if(type.indexOf("xml") != -1 && request.responseXML) callback(request.responseXML);
            else if(type === "application/json") callback(JSON.parse(request.responseText));
            else callback(request.responseText);
        }
    };
    request.send(null);
}

// 使用JSON编码主体来发起HTTP POST请求
function postJSON(url,data,callback) {
    var request = new XMLHttpRequest();
    request.open("POST" ,url);
    request.onreadystatechange =function () {
        if(request.readyState ==4 && callback){
            callback(request);
        }
    };
    request.setRequestHeader("Contetn-Type","application.json");
    request.end(JSON.stringify(data));
}

