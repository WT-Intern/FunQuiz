   //API
    var api = "http://localhost:8080/API/Quiz/getQuiz/";
    var resultAPI = "http://localhost:8080/API/Quiz/ShowResultQuiz";
    var relatedQuizAPI = "http://localhost:8080/API/Quiz/getQuizByIdQuizType";

    //variable
    var url = new URL(window.location.href);
    var id = url.searchParams.get("idQuiz");
    var result = "";
    var idQuizType;
    var idOptionCheck = 0;
    var questionsLength;

    //Detail Quiz
    $.ajax({
        url: api + id,
        type: "GET",
        dataType: "json",
        success: function (json)
        {
            console.log (json.data)
            var wrapper = document.createElement("div");
            wrapper.className = "wrapper";

            var questionWrapper;
            var optionWrapper_3;
            var optionWrapper_2;
			var optionWrapperText;
            var optionWrapper;
            var optionContainer;
            var optionList;
            var subOption;
            var option;
            var checkboxOption;

            //title quiz
            var judulElement = json.data[0].judulQuiz;
            var judulQuiz = document.createElement("div");
            $("<h1>").html(judulElement)
                .attr('id-quiz',json.data[0].idQuiz)
                .css('font-size', '60px')
                .css('margin', '10px')
                .appendTo(judulQuiz);

            //image quiz
            var imageElement  = json.data[0].imageURL;
            var imageQuiz = document.createElement("div");
            $("<img>").attr("src", imageElement)
                .attr('id-quiz',json.data[0].idQuiz)
                .css('height','270px')
                .css('width','700px')
                .css('margin', '10px')
                .appendTo(imageQuiz);

            wrapper.appendChild(judulQuiz);
            wrapper.appendChild(imageQuiz);

            //array quizType
            var idType = json.data[0].quizType;
            idQuizType = idType.idQuizType;

            //array questions
            var questions = json.data[0].questions;
            questionsLength = questions.length;

            //loop array que;stions
            $.each(questions, function (i, item) {
               // console.log("idQuestion : " +item.idQuestion);      //show id questionn
                //array options
                var options = questions[i].options;

                //nampung pertanyaan
                questionWrapper = document.createElement("div");
                questionWrapper.className= "questionWrapper";

                $("<h2>").html(item.text)
                    .attr('id-question',item.idQuestion)
                    .css('margin', '10px')
                    .appendTo(questionWrapper);


                optionWrapper_3 = document.createElement("div");
                optionWrapper_3.className = "optionWrapper_3";

                optionWrapper_2 = document.createElement("div");
                optionWrapper_2.className = "optionWrapper_2";
				
				optionWrapperText = document.createElement("div");
                optionWrapperText.className = "optionWrapperText";

                optionWrapper = document.createElement("div");
                optionWrapper.className = "optionWrapper";

                optionContainer = document.createElement("ul");
                optionContainer.className = "optionContainer";

                //loop array options
                $.each(options, function (j, obj) {

                  //  console.log("idOption : " +obj.idOption);

                    optionList = document.createElement("li");
                    optionList.className = "optionList";

                    subOption = document.createElement("div");
                    subOption.className = "subOption";

                    option = document.createElement("div");
                    option.className = "option";

                    checkboxOption = document.createElement("div");
                    checkboxOption.className = "checkboxOption";

                    var lengthOptions = options.length;

                    //if opttion image
                    if (obj.imageURL != null) {
                        if (lengthOptions % 3 == 0 || lengthOptions == 5) {
                            $("<img>").attr("src", obj.imageURL)
                                .attr('id-option',obj.idOption)
                                .attr('id-question',item.idQuestion)
                                .css('width','100%')
                                .appendTo(option);
                        } else if (lengthOptions % 2 == 0) {
                            $("<img>").attr("src", obj.imageURL)
                                .attr('id-option',obj.idOption)
                                .attr('id-question',item.idQuestion)
                                .css('width','70%')
                                .appendTo(option);
                        }

                        $(checkboxOption).append($("<input type='checkbox'>")
                            .attr('id', 'test')
                            .attr('id-option', obj.idOption)
                            .attr('id-question',item.idQuestion)
                            .css('margin-top', '10px')
                            .css('height', '20px')
                            .css('width', '20px')
                            .click(function () {

                                var $this = $(this);
                                var childs = $(this).parents('.optionContainer').find('li');
                                var input = $(this).parents('.optionContainer').find('input');

                                if ($this.is(':checked')) {
                                    //alert('checked');
                                    $this.attr('checked',true);
                                    $(this).parents('.optionList').attr('id', obj.idOption);
                                    if(obj.idOption != 0){
                                        result += obj.idOption + ',';
                                    }
                                    idOptionCheck++;
                                    for (var i=0; i<childs.length; i++)
                                    {
                                        if(childs[i].id != 0){
                                            continue;
                                        }
                                        else {
                                            input[i].disabled='true';
                                        }
                                    }

                                } else {
                                    $this.attr('checked',false);
                                    $(this).parents('.optionList').removeAttr('id');
                                    input.attr('disabled',false);
                                    idOptionCheck--;

                                    var temp = [];
                                    temp = result.split(",");
                                    console.log(temp);
                                    result = "";
                                    for(var i=0;i<temp.length-2;i++){
                                        result += temp[i] +',';
                                    }
                                }
                            })
                        );
                    } else {
                        //if option text
                        $("<h4>").html(obj.text)
                            .attr('id-option',obj.idOption)
                            .attr('id-question',item.idQuestion)
                            .css('margin-left', '28px')
                            .css('margin-bottom', '-30px    ')
                            .appendTo(option);

                        $(checkboxOption).append($("<input type='checkbox'>")
                            .attr('id', 'test')
                            .attr('id-option', obj.idOption)
                            .attr('id-question',item.idQuestion)
                            .css('margin-top', '10px')
                            .css('height', '20px')
                            .css('width', '20px')
                            .click(function () {

                                var $this = $(this);
                                var childs = $(this).parents('.optionContainer').find('li');
                                var input = $(this).parents('.optionContainer').find('input');

                                if ($this.is(':checked')) {
                                    //alert('checked');
                                    $this.attr('checked',true);
                                    $(this).parents('.optionList').attr('id', obj.idOption);
                                    if(obj.idOption != 0){
                                        result += obj.idOption + ',';
                                    }
                                    idOptionCheck++;
                                    for (var i=0; i<childs.length; i++) {
                                        if(childs[i].id != 0){
                                            continue;
                                        }
                                        else {
                                            input[i].disabled='true';
                                        }
                                    }
                                } else {
                                    //alert('unchecked');
                                    $this.attr('checked',false);
                                    $(this).parents('.optionList').removeAttr('id');
                                    input.attr('disabled',false);
                                    idOptionCheck--;

                                    var temp = [];
                                    temp = result.split(",");
                                    console.log(temp);
                                    result = "";
                                    for(var i=0;i<temp.length-2;i++){
                                        result += temp[i] +',';
                                    }
                                }
                            })
                        );
                    }

                    subOption.appendChild(option);
                    subOption.appendChild(checkboxOption);
                    optionList.appendChild(subOption);
                    optionContainer.appendChild(optionList);
					
					
					if (obj.imageURL != null) {
                        if (lengthOptions % 3 == 0 || lengthOptions == 5) {
                            optionWrapper_3.appendChild(optionContainer);
                            optionWrapper.appendChild(optionWrapper_3);
                        } else if (lengthOptions % 2 == 0){
                            optionWrapper_2.appendChild(optionContainer);
                            optionWrapper.appendChild(optionWrapper_2);
                        }
                    } else {
                        optionWrapperText.appendChild(optionContainer);
                        optionWrapper.appendChild(optionWrapperText);
                    }

                });
                questionWrapper.appendChild(optionWrapper);
                wrapper.appendChild(questionWrapper);
            });

            $('#list_question').append(wrapper);

            //Related Quiz
            $.ajax
            ({
                url: relatedQuizAPI,
                type: "POST",
                data: jQuery.param({idQuizType: idQuizType}),
                dataType: "json",
                success: function (json)
                {
                  //  console.log(json.data)
                     $.each(json.data, function (i, quiz)
                     {
                         idType = quiz.idQuiz;

                         //image Quiz
                         var imageRelated = document.createElement("div");
                         imageRelated.className="image"
                         $("<img>").attr("src", quiz.imageURL)
                             .attr('data-id',quiz.idQuiz)
                             .attr('alt', quiz.judulQuiz)
                             .css('height','112px')
                             .css('width','139px')
                             //.css('padding','72px')
                             .css('margin-top', '35px')
                             .appendTo(imageRelated);

                         //title Quiz
                         var title = document.createElement("div");
                         $("<h5>").html(quiz.judulQuiz)
                            .attr('data-id',quiz.idQuiz)
                            .css('height','98px')
                            .css('width','87px')
                             .css('margin-left', '155px')
                            .css('margin-top', '-76px')
                            .appendTo(title);

                        var relatedQuiz = document.createElement("li");
                        relatedQuiz.className = "relatedQuiz";
                        relatedQuiz.appendChild(imageRelated);
                        relatedQuiz.appendChild(title);
                        relatedQuiz.onclick = function () {
                         window.location.href = "http://localhost:8080/question?idQuiz=" + quiz.idQuiz;  //url
                     }

                     $('#relatedQuiz').append(relatedQuiz);
                     });
                }
            });

        }
    });


$( document ).ready(function() {
    var wrapper = document.createElement("div");
    wrapper.className = "button";
    $( "#button" ).click(function()
    {
        if (idOptionCheck < questionsLength)
        {
            alert("Pastikan anda menjawab semua pertanyaan")
        } else {
            $.ajax
            ({
                url: resultAPI,
                type: "POST",
                dataType: "json",
                data: jQuery.param({idQuiz: id, idOption: result}),
                success: function (json) {

                    $.each(json.data, function (i, item)
                    {
                        if (idQuizType == 1) {
                            id = item.idQuiz;
                            var value = document.createElement("div");
                            $("<h3>").html(item.value)
                                .attr('data-id', item.idQuiz)
                                .css('height', '100px')
                                .css('width', '400px')
                                .css('margin-left', '16px')
                                .css('margin-top', '4px ')
                                .appendTo(value);

                            var description = document.createElement("div");
                            $("<h5>").html(item.description)
                                .attr('data-id', item.idQuiz)
                                .css('height', '100px')
                                .css('width', '400px')
                                .css('margin-left', '41px')
                                .css('margin-top', '-63px')
                                .appendTo(description);


                            var image = document.createElement("div");
                            $("<img>").attr("src", item.imageURL)
                                .attr('data-id', item.idQuiz)
                                .css('height', '362px')
                                .css('width', '658px')
                                .css('padding', '15px')
                                .css('margin-top', ' -54px')
                                .css('margin-left', '28px')
                                .appendTo(image);

                            var wrapper = document.createElement("div");
                            wrapper.className = "hasil";

                            wrapper.appendChild(value);
                            wrapper.appendChild(description);
                            wrapper.appendChild(image);


                            $('#result').css({
                                "border-width": "4px",
                                "border-style": "double",
                                "padding": "4px",
                                "margin-top": "32px",
                                "margin-left": "-13px",
                                "margin-right": "14px",
                                "border-color": "#5bc0de"
                            }).append(wrapper).show();
                            $('#button').hide();
                        } else {
                            id = item.idQuiz;
                            var value = document.createElement("div");
                            $("<h3>").html(item.value)
                                .attr('data-id', item.idQuiz)
                                .css('height', '100px')
                                .css('width', '400px')
                                .css('margin-left', '16px')
                                .css('margin-top', '4px ')
                                .appendTo(value);

                            var description = document.createElement("div");
                            $("<h5>").html(item.description)
                                .attr('data-id', item.idQuiz)
                                .css('height', '100px')
                                .css('width', '400px')
                                .css('margin-left', '41px')
                                .css('margin-top', '-63px')
                                .appendTo(description);


                            var image = document.createElement("div");
                            $("<img>").attr("src", item.imageURL)
                                .attr('data-id', item.idQuiz)
                                .css('height', '362px')
                                .css('width', '658px')
                                .css('padding', '15px')
                                .css('margin-top', ' -54px')
                                .css('margin-left', '28px')
                                .appendTo(image);


                            var wrapper = document.createElement("div");
                            wrapper.className = "hasil";

                            wrapper.appendChild(value);
                            wrapper.appendChild(description);
                            wrapper.appendChild(image);

                            // wrapper.css('border', '2px solid green');

                            $('#result').css({
                                "border-width": "4px",
                                "border-style": "double",
                                "padding": "4px",
                                "margin-top": "32px",
                                "margin-left": "-13px",
                                "margin-right": "14px",
                                "border-color": "#5bc0de"
                            }).append(wrapper).show();
                            $('#word').append(item.rightAnswer).append(" from ").append(questionsLength).show()
                            $('#button').hide();

                        }


                    });
                }

            })
        }
    });
});







