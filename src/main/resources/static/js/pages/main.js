var id;
var WTAPI = "http://localhost:8080/API/Quiz/getAllQuizByStatus";


$(document).ready(function(){
    LoadFirst();
    $(window).scroll(function () {
        var theWindow = $(this);
        var theContainer = $('#list_quizzes');
        $(this).delay(1000);
        if ($(window).scrollTop() + $(window).height() >= $(document).height()){
            if (id >= 1 || id!=null)
            {
                $.ajax({
                    url: WTAPI,
                    type: "POST",
                    data : jQuery.param({idQuiz : id}),
                    dataType: "json",
                    success: function (json) {
                        $.each(json.data, function (i, item) {
                            id = item.idQuiz;
                            var image = document.createElement("div");
                            $("<img>").attr('data-id',item.idQuiz)
                                .attr('alt',item.judulQuiz)
                                .attr("src", item.imageURL)
                                .css('height','170px')
                                .css('width','250px')
                                .css('padding','10px')
                                .css('margin-bottom', '5px')
                                .appendTo(image);
                            var title = document.createElement("div");
                            $("<h1>").html(item.judulQuiz)
                                .attr('data-id',item.idQuiz)
                                .css('height','100px')
                                .css('width','400px')
                                .css('margin-left', '260px')
                                .css('margin-top', '-110px')
                                .appendTo(title);
                            var wrapper = document.createElement("li");
                            wrapper.className = "itemList";
                            wrapper.appendChild(image);
                            wrapper.appendChild(title);
                            wrapper.onclick = function ()
                            {
                                window.location.href = "http://localhost:8080/question?idQuiz=" + item.idQuiz;  //url
                            }
                            $('#list_quizzes').append(wrapper);
                        });
                    }
                });
            }else {
                return false;
            }
        }
    });
})

function LoadFirst() {
    $.ajax({
        url: WTAPI,
        type: "POST",
        data : jQuery.param({idQuiz : id}),
        dataType: "json",

        success: function (json)
        {
            $.each(json.data, function (i, item)
            {
                id = item.idQuiz;
             //   console.log (id);
                var image = document.createElement("div");
                $("<img>").attr('data-id',item.idQuiz)
                    .attr('alt',item.judulQuiz)
                    .attr("src", item.imageURL)
                    .css('height','170px')
                    .css('width','250px')
                    .css('padding','10px')
                    .css('margin-bottom', '5px')
                    .appendTo(image);
                var title = document.createElement("div");
                $("<h1>").html(item.judulQuiz)
                    .attr('data-id',item.idQuiz)
                    .css('height','100px')
                    .css('width','400px')
                    .css('margin-left', '260px')
                    .css('margin-top', '-110px')
                    .appendTo(title);


                var wrapper = document.createElement("li");
                wrapper.className = "itemList";
                wrapper.appendChild(image);
                wrapper.appendChild(title);
                wrapper.onclick = function () {
                      window.location.href = "http://localhost:8080/question?idQuiz=" + item.idQuiz;  //url
                }

                $('#list_quizzes').append(wrapper);
            });
        }
    });
}
