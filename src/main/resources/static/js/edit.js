var api= "http://localhost:8080/api-quiz-getAllById/";
var apiUpdate = "http://localhost:8080/api-update-quiz"
var url = new URL(window.location.href);
var id = url.searchParams.get("idQuiz");
var questionLength;
var questions = [];
var optionLength;
var resultLength;
var quiz = {};
var dataUpdate  = {};

$(document).ready(function()
{
    $.ajax({
        url: api + id,
        type: "GET",
        dataType: "json",
        success: function (json)
        {
            console.log(json.data)
            $('#title').val(json.data.judulQuiz);

            var questions = json.data.questions;
            console.log (questions)
            questionLength = questions.length;
            //alert(questionLength)

            var questionList = document.createElement("div")
            questionList.className = "questionList"

            var questionContainer = document.createElement("div")
            questionContainer.className = "questionContainer"

            var n = 0;
            $.each(questions, function (i, item)
            {

                var question = document.createElement("div");
                question.className = "question"

                $(question).append($('<label>').text("Question " + (n+1)))
                $(question).append($("<input type='text'>")
                    .attr('class', 'form-control')
                    .attr('id', 'type-question'+ n )
                    .val(item.text)
                );

                var idQuestion = document.createElement("div");
                $(idQuestion).append($("<input type='hidden'>" )
                        .attr('id', 'idQuestion'+ n)
                        .val(item.idQuestion)
                );

                question.appendChild(idQuestion)

                var options = questions[i].options;
                optionLength = options.length;

                var a = 0
                $.each(options, function (j, obj)
                {
                    idOption= obj.idOption;
                    var optionList = document.createElement("div")
                    optionList.className = "optionList"

                    var option = document.createElement("div");
                    $(option).append($('<label>').text("Option-" +(a+1)))
                    $(option).append($("<input type='text'>" )
                        .attr('id', 'type-question'+ n+'option'+a)
                        .attr('class', 'form')
                        .css('margin-left', '18px')
                        .val(obj.text)
                    );

                    var score = document.createElement("div");
                    $(score).append($('<label>').text("Value Option-" + (a+1)))
                    $(score).append($("<input type='text'>" )
                        .attr('id', 'type-question'+ n+'score'+a)
                        .css('margin-left', '14px')
                        .val(obj.value)
                    );

                    var idOption = document.createElement("div");
                    $(idOption).append($("<input type='hidden'>" )
                        .attr('id', 'type-question'+ n+'idOption'+a)
                        .val(obj.idOption)
                    );
                    a++;

                    optionList.appendChild(idOption)
                    optionList.appendChild(option)
                    optionList.appendChild(score)
                    question.appendChild(optionList)
                });
                $('#add_question').append(question)
                n++;
            });

            var result = json.data.quizRules;
            resultLength = result.length;

            var b = 0;
            $.each(result, function (k, item)
            {
                var value = document.createElement("div");
                $(value).append($('<label>').text("Value Result"))
                $(value).append($("<input type='text'>")
                    .attr('class', 'form-control')
                    .attr('id', 'value'+b)
                    .val(item.value)
                );

                var description = document.createElement("div");
                $(description).append($('<label>').text("Description"))
                $(description).append($("<input type='text'>")
                    .attr('class', 'form-control')
                    .attr('id', 'description'+b)
                    .val(item.description)
                );

                var max = document.createElement("div");
                $(max).append($('<label>').text("Score Max"))
                $(max).append($("<input type='text'>")
                    .attr('class', 'form-control')
                    .attr('id', 'max'+b)
                    .val(item.max)
                );

                var min = document.createElement("div");
                $(min).append($('<label>').text("Score Min"))
                $(min).append($("<input type='text'>")
                    .attr('class', 'form-control')
                    .attr('id', 'min'+b)
                    .val(item.min)
                );

                var idRules = document.createElement("div");
                $(idRules).append($("<input type='hidden'>")
                    .attr('id', 'idRules'+b)
                    .val(item.idRules)
                );
                b++;

                var addResult = document.createElement("div");
                addResult.className = "Result";
                addResult.appendChild(idRules)
                addResult.appendChild(value)
                addResult.appendChild(description)
                addResult.appendChild(min)
                addResult.appendChild(max)
                $('#add_result').append(addResult)
            });
        }
    });


    function populateDataEdit()
    {

        quiz.idQuiz = id
        quiz.judulQuiz = $('#title').val()
   //     quiz.published_date = $('#dateTime').val()
        for(var i=0 ; i<questionLength ; i++)
        {
            var question ={}
            question.text = $('#type-question'+ i).val()
          //  question.imageURL = ''
            question.idQuestion =  $('#idQuestion'+i).val()
            var options = []
            for (var j = 0; j < optionLength; j++)
            {

                var option = {}
                option.idOption = $('#type-question'+ i +'idOption'+ j).val()
               // option.imageURL = ''
                option.text = $('#type-question'+ i +'option'+ j).val()
                option.value = $('#type-question'+ i+'score'+j).val()
                options.push(option)
            }

            question.options = options
            questions.push(question)
        }
        var results = []
        for(var k=0 ; k<resultLength ; k++)
        {

            var result = {}
            result.idRules = $('#idRules'+k).val()
            result.value = $('#value'+k).val()
            result.description = $('#description'+k).val()
            result.min = $('#min'+k).val()
            result.max = $('#max'+k).val()
            results.push(result)
        }
        quiz.questions = questions;
        quiz.quizRules = results;
        quiz.imageURL = "http://placehold.it/32x32"
        dataUpdate = quiz;
    }

    $( "#buttonUpdate" ).click(function()
    {
        populateDataEdit();
        var dataJson = JSON.stringify(dataUpdate)
        console.log (dataJson);
        $.ajax({
            url: apiUpdate,
            type: "POST",
            contentType: 'application/json',
            data: dataJson,
            success: function (json)
            {
                window.location.href = "http://localhost:8080/index"
            }
    })
    })
});





