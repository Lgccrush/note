/** note.js封装笔记相关操作* */
//根据笔记本ID加载笔记列表
//function 
function loadNoteBooks() {
//					设置选中效果
    $("#book_ul a").removeClass("checked");//清除之前选中
    $(this).find("a").addClass("checked");
    $("#input_note_title").val("");
    um.setContent("");
    //获取绑定的li里的userId
    var bookId = $(this).data("bookId");
//						alert(bookId);
    $.ajax({//发送ajax请求
        url: path + "/note/loadnotes.do",//地址
        data: {"bookId": bookId},//参数
        type: "post",//请求方法
        dataType: "json",//响应类型
        success: function (result) {
//								成功解析返回数据得到id和标题
            if (result.status == 0) {
                var notes = result.data;//获取返回的笔记
//								清除原列表信息
                $("#note_ul").empty();
                //$("#note_ul li").remove();
                for (var i = 0; i < notes.length; i++) {
                    var noteId = notes[i].cn_note_id;//获取笔记id
                    var noteTitle = notes[i].cn_note_title;//获取笔记标题
                    var sli = "";
                    sli = sli
                        + '<li class="online">'
                        + '<a>'
                        + '	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'
                        + noteTitle
                        + '		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'
                        + '</a>'
                        + '<div class="note_menu" tabindex="-1">'
                        + '	<dl>'
                        + '	<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'
                        + '		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'
                        + '		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'
                        + '	</dl>' + '</div>' + '</li>';
                    var $li = $(sli);//转为jQuery对象
                    $li.data("noteId", noteId);//绑定笔记id
                    $("#note_ul").append($li);//显示笔记
                }
            }
        },
        error: function () {//失败情况
            alert("加载笔记本列表失败");
        }
    });
};

/*根据笔记id显示标题和内容*/
function loadNote() {
    //获取笔记id
    var noteId = $(this).data("noteId");
//	alert(noteId);
//	设置选中效果
    $("#note_ul a").removeClass("checked");//清除之前选中
    $(this).find("a").addClass("checked");
    $.ajax({
        //发送ajax请求
        url: path + "/note/load.do",//请求地址
        data: {"noteId": noteId},//请求参数
        type: "post",//请求方法
        dataType: "json",//返回类型
        success: function (result) {//请求成功
            if (result.status == 0) {
//				获取返回的笔记标题和笔记内容
                var noteMsg = result.data;
                var noteTitle = noteMsg.cn_note_title;
                var noteBody = noteMsg.cn_note_body;
//				alert(noteTitle+"-----"+noteBody);
                $("#input_note_title").val(noteTitle);//设置笔记标题
                um.setContent(noteBody);//设置笔记内容
            }
        },
        error: function () {
            alert("加载笔记信息失败");
        }
    })
}

//更新笔记
function updateNote() {
//		alert("1");
//		获取被选中的li
    var $li = $("#note_ul a.checked").parent();
//		alert(text);
//		alert(title);
//		获取被选中的li的id 对应的标题和内容
    var noteId = $li.data("noteId");
    var title = $("#input_note_title").val();
    var body = um.getContent();
    $("#note_title_span").html("");
    //检查格式
    if ($li.length == 0) {
        alert("请选择要保存的笔记");
    } else if (title == "") {   //有选中的笔记，检查笔记标题是否为空

        $("#note_title_span").html("<font color='red'>标题不能为空</font>");
    } else {
        $.ajax({//发送ajax请求
            url: path + "/note/update.do",
            data: {"noteId": noteId, "title": title, "body": body},
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.status == 0) {
                    $("#note_ul a.checked").html('	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'
                        + title
                        + '		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>');
                    alert(result.msg);
                }
            },
            error: function () {
                alert("保存失败");
            }
        })
    }
    ;
}

//创建笔记
//function createNote(){
//	var noteName = $("#input_note").val().trim();
//	var userId = getCookie("userId");
//	alert(noteName+"-----"+userId);
//	if(noteName==""){
//		$("#input_note_span").html("笔记名不能为空");
//	}
//}