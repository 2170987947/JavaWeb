// 页面加载完成以后执行 function 代码
$(function () {
    // juery, 使用 $("@id") 通过元素 id 获取某个页面元素
    $("#login_form").submit(function () {
        // ajax 自己发请求
        $.ajax({
            url: "../login", // 球球的服务路径
            type: "post", // 请求的方法
            // contentType: "",  // 请求的数据格式/类型: 请求头 Content-Type, 默认表单格式, json 需要制定为 json
            data: $("#login_form").serialize(), // 请求数据, 使用序列化表单的数据: username=... password= ...
            dataType: "json", // 响应的数据类型/格式: 使用 json 需要指定
            success: function (r) { //响应体 json 字符串, 会解析成方法参数
                if (r.success) {
                    // 前端页面 URL 直接跳转到某个路径
                    window.location.href = "../jsp/articleList.jsp";
                } else {
                    alert("错误码: " + r.code + "\n错误消息" + r.message)
                }
            }
        })

        // 同意不执行默认的表单提交
        return false;
    })
})