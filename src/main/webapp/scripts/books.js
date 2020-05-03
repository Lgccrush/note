/**book.js封装笔记本相关处理**/
//根据用户id显示笔记本列表
function loadUserBooks() {
//	获取userID
    var userId = getCookie("userId");
    var username = getCookie("username");
//	alert(userId);
//	alert(username);
    if (userId == null) {//没有id转到登录
        window.location.href = "log_in.do";
    } else {//有id发送ajax请求
        $.ajax({
            url: path + "/book/loadBooks.do",
            data: {"userId": userId},
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.status == 0) {//查询成功
//					获取笔记本结果集合
                    var books = result.data;
                    for (var i = 0; i < books.length; i++) {
                        var bookName = books[i].cn_notebook_name;
                        var bookId = books[i].cn_notebook_id;
//						获取笔记本id和名字
//						创建一个笔记本的li元素
                        createBookLi(bookId, bookName);
                    }
                }
            },
            error: function () {
                alert("生成列表失败");
            }
        });
    }
};

//创建一个笔记本li元素
function createBookLi(bookId, bookName) {
//	var sli = "";
//	sli +='<li class="online">';
//	sli +='<a>';
//	sli +='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
//	sli +='</i>';
//	sli +=bookName
//	sli +='</a>';
//	sli +='</li>';
    var sli = '<li class="online">'
        + '<a>'
        + '<i class="fa fa-book" title="online" rel="tooltip-bottom">'
        + '</i>'
        + bookName
        + '</a>'
        + '</li>';
//	将sli字符串转换成jQuery的对象的li元素
    var $li = $(sli);
//	将bookID值与jQuery对象绑定
    $li.data("bookId", bookId);
//	将li元素添加到笔记本ul列表区
    $("#book_ul").append($li);
}

////创建笔记本
//function createBook(){
//	$(".sure").click(function(){
////		alert("11");
//		var bookName = $("#input_notebook").val();
//		var userId = getCookie("userId");
//		alert(bookName+"..."+userId);
//		if(bookName==""){
//			$("#input_notebook").html("笔记名不能为空");
//		}else{
//			$.ajax({
//				url:path+"/book/add.do",
//				data:{"bookName":bookName,"userId":userId},
//				type:"post",
//				dataType:"json",
//				success:function(result){
//					if(result.status==0){
//						var sli ='<li class="online">'
//							+'<a>'
//							+'<i class="fa fa-book" title="online" rel="tooltip-bottom">'
//							+'</i>'
//							+bookName
//							+'</a>'
//							+'</li>';
////						将sli字符串转换成jQuery的对象的li元素
//						var $li = $(sli);
////						将bookID值与jQuery对象绑定
//						$li.data("bookId",bookId);
////						将li元素添加到笔记本ul列表区
//						$("#book_ul").append($li);
//					}
//				},
//				error:function(){
//					alert("创建笔记失败");
//				}
//			})
//		}
//	});
//}