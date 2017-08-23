//tab

var flag= false;
function tabQuiz(evt, tabName)
{
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    if (flag == false && tabName == "Result" ) {
        loadResultFirst();
        flag = true;
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

var api = "http://localhost:8080/api-create-quiz"
var quiz = {}
var all_questions = []
var length_question = 0
var length_result = 0
var all_results = []
var quizType ={}
var updateData = {}
var apiImageURL = "http://localhost:8080/api-upload"

function getImageURL()
{
  //  alert ("ayam")
    var bebek = "quiz"
    var formdata = new FormData();
    formdata.append("multipartFile", $("#file")[0].files[0]);
    formdata.append("type", bebek)
    $.ajax
    ({
        url: apiImageURL,
        type: 'POST',
        data: formdata ,
        async : false,
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        success: function (data)
        {
            $('#imageURL').val(data)

        }
    });

    alert (+  $('#imageURL').val())


}


function populateDataTrueFalse() {
    validateDataTrueFalse()
    //console.log(length_question)

    for(var i=1 ; i<=length_question ; i++)
    {
        var k=0;
        var all_options = []
        var option_true = {}
        var option_false = {}

        if($('#checkboxtrue'+i).prop("checked") == true)
        {
        option_true.text = $('#optiontrue'+ i).text()
        option_true.value = 1
        all_options.push(option_true)

            option_false.text = $('#optionfalse'+ i).text()
            option_false.value = 0
            all_options.push(option_false)

        }

        if ($('#checkboxfalse'+i).prop("checked") == true)
        {
            option_false.text = $('#optionfalse'+ i).text()
            option_false.value = 1
            all_options.push(option_false)

            option_true.text = $('#optiontrue'+ i).text()
            option_true.value = 0
            all_options.push(option_true)
        }

        var question = {}
        question.text = $('#question-truefalse'+i).val()
        question.options = all_options

        all_questions.push(question)
    }
    getImageURL()
 //   quiz.imageURL = $('#imageURL').val()
    quiz.imageURL = "https://media1.britannica.com/eb-media/95/178195-131-4DEB4742.jpg"
    quiz.judulQuiz = $('#title').val()
//    quiz.published_date = $('#dateTime').val().replace(' ','T')

    quiz.questions = all_questions
    quizType.idQuizType = "2"
    quizType.text = $('#optionType option:selected').text()
    quiz.quizType = quizType;
    updateData = quiz;

   // console.log(quiz)

}

function validateDataTrueFalse() {
    if($('#title').val() == ''){
//          alert('title quiz can not be left blank');
    }
    if ($("#optionType option:selected").val('') == ''){
//        alert('Option Type can not be left blank');
    }
    if($('#dateTime').val() == ''){
//        alert('date published can not be left blank');
    }
//        console.log('a '+length_question)
    for(var j=1 ; j<=length_question ; j++){

        if($('#question-truefalse'+j).val() == ''){
            //alert('question '+j+' can not be left blank');
        }
        if($('#optiontrue'+j).val() == ''){
            //alert('option true of question'+j+' can not be left blank');
        }
        if($('#optionfalse'+j).val() == ''){
            //alert('option false of question'+j+' can not be left blank');
        }
    }
}

function populateDataCorrectAnswer()
{
   // validateDataCorrectAnswer()
    for(var i=1 ; i<=length_question ; i++) {
        //get all option per question
        var all_options = []
        var length_option_question = question_option[i-1]['total_option']

        for(var j = 1 ; j<=length_option_question ; j++)
        {
            var option = {}
            option.judulQuiz = $('#question'+i+'-option'+j).val()
            option.text = $('#question'+i+'-option'+j).val()
         //   option.imageURL = 'a.jpg'
            if(question_option[i-1]['id_correct_answer'] == j) {
                option.value = 1
            } else {
                option.value = 0
            }
            all_options.push(option)
        }
        var question = {}
        question.judulQuiz = $('#question-correctanswer'+i).val()
        question.text = $('#question-correctanswer'+i).val()
        question.options = all_options


        all_questions.push(question)
    }
    quiz.judulQuiz = $('#title').val()
    quiz.imageURL = "http://www.featurepics.com/StockImage/20140108/quiz-multiple-choice-stock-illustration-2904159.jpg"
//    quiz.published_date = $('#dateTime').val().replace(' ','T')
    quiz.questions = all_questions
    quizType.idQuizType = "3"
    quizType.text = $('#optionType option:selected').text()
    quiz.quizType = quizType;
    updateData = quiz;
    console.log(quiz)
}

function validateDataCorrectAnswer() {
    if($('#title').val() == ''){
        //alert('title quiz can not be left blank');
    }
    if ($("#optionType option:selected").val('') == ''){
        //alert('Option Type can not be left blank');
    }
    if($('#dateTime').val() == ''){
        //alert('date published can not be left blank');
    }

    for(var k=1 ; k<=length_question ; k++){
        if($('#question-correctanswer'+k).val() == ''){
            // alert('question '+k+' can not be left blank');
        }
    }
}

function populateDataPersonality() {
    validateDataPersonality()
    for(var i=1 ; i<=length_question ; i++) {
        //get all option per question
        var all_options = []
        var length_option_question = question_option[i-1]['total_option']

        for(var j = 1 ; j<=length_option_question ; j++)
        {
            var option = {}
            option.text = $('#question'+i+'-option'+j).val()
            option.value = $('#scoreQuestion'+optionsText+'-option'+j).val()
            all_options.push(option)
        }
        var question = {}
        question.text = $('#questionpersonality'+i).val()
        question.options = all_options


        all_questions.push(question)
    }
    quiz.judulQuiz = $('#title').val()
    quiz.imageURL = "http://kids.nationalgeographic.com/content/dam/kids/photos/games/Hub%20promos/personality-quiz.ngsversion.1438022404555.adapt.1900.1.png"
//    quiz.published_date = $('#dateTime').val().replace(' ','T')
    quiz.questions = all_questions
    quizType.idQuizType = "1"
    quizType.text = $('#optionType option:selected').text()
    quiz.quizType = quizType;
    updateData = quiz;
    console.log(quiz)
}

function validateDataPersonality() {
    var i,j=1;

    if($('#questionpersonality'+personality+'').val('') == ''){
        // alert('Question can not be left blank');
    }
    if ($('#question'+i+'-option'+j+'').val('') == ''){
        // alert('option can not be left blank');
    }
    if($('#scoreQuestion'+i+'-option'+j+'').val() == ''){
        // alert('score can not be left blank');
    }

    for(k=1; k<=length_question;k++){
        if($('#question'+i+'-option'+j+'').val()==''){
            // alert('question '+k+' can not be blank');
        }
        if($('#scoreQuestion'+i+'-option'+j+'').val()==''){
            // alert('score question '+k+' can not be blank');
        }
    }
}

function populateDataResult() {
    //get all option per question

    for(var n = 0 ; n<=length_result ; n++)
    {
        var quizRules = {}
        quizRules.imageURL = "https://www.brca.org/images/sections/12c/ResultsIcon.jpg"
        quizRules.value = $('#titleGrade'+n).val()
        quizRules.description = $('#gradeDescription'+n).val()
        quizRules.max = $('#maxValue'+n).val()
        quizRules.min = $('#minValue'+n).val()
        all_results.push(quizRules)
    }
    quiz.quizRules = all_results;
    updateData = quiz;
  //  console.log(all_results)
}

function populateAllData()
{
    var quizType = $('#optionType option:selected').text();
  if(quizType == "True False") {
       populateDataTrueFalse()
  } else if(quizType == "Correct Answer") {
       populateDataCorrectAnswer()
  } else if(quizType == "Personality") {
       populateDataPersonality()
  }
    populateDataResult()
    var dataJson = JSON.stringify(updateData)
    console.log (updateData);

    //hit api
    $.ajax({
        url: api,
        type: "POST",
        contentType : "application/json;charset=utf-8",
        dataType: "json",
        data: dataJson,
        success: function(json) {
            console.log("save")
            window.location.href = "http://localhost:8080/index"
        },
        error: function (e) {
            console.log(e)
        }
    });
}

var next = 1;

function addQuestionTruefalse() {
    length_question++;
    var question = {}
    question.total_option = 0
    question_option.push(question)
    //console.log(length_question)
    question.id_correct_answer = 0
    var n = next;

    var isi ='<div class = "form-group-md'+next+'">';

    isi += '<br/><div class="row-section" id="section-truefalse'+n+'">'+
        '<button id="remove-truefalse" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
        '<div><label>Question '+n+'</label></div><div>'+
        '<textarea id="question-truefalse'+n+'" type="text" class="textarea-question" placeholder="Enter the question"></textarea>'+
        '</div><div></div><div><input id="checkboxtrue'+n+'" name="checkbox" type="checkbox"/>' +
        '<label id="optiontrue'+n+'" value = "True">True</label></div>'+
        '<input id="checkboxfalse'+n+'" name="checkbox" type="checkbox"/>'+
        '<label id="optionfalse'+(n)+'" value = "False">False</label></div>'
        '</div></div></div>';

    isi += '</div>';

    $('#addquestion').append(isi);
    $('#addquestion' +next).slideDown('medium');

    next++;
}

$("body").on("click", "#remove-truefalse", function () {
    $(this).closest("div").remove();
});


/*var next = 0;
function addQuestionTruefalse(){
    length_question ++;
    var n = next + 1;

    var isi ='<div class = "form-group-md'+n+'">';    isi += '<br/><div class="row-section" id="section-truefalse'+n+'">'+
        '<button id="remove-truefalse" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
        '<div><label>Question '+n+'</label></div><div>'+
        '<textarea id="question-truefalse'+n+'" type="text" class="textarea-question" placeholder="Enter the question"></textarea>'+
        '</div><div><label>Option</label></div><div><input id="checkboxtrue'+n+'" type="checkbox" class="radio icheckbox_flat-blue" value="1" name="test[1][]" />'+
        '<input id="optiontrue'+n+'" type="text" class="textoption" value="True"/></div>'+
        '<div><input id="checkboxfalse'+n+'" type="checkbox" class="radio icheckbox_flat-blue" value="1" name="test[1][]" />'+
        '<input id="optionfalse'+n+'" type="text" class="textoption" value="False"/></div></div></div>';    isi += '</div>';    $('#addquestion').append(isi);
    $('#addquestion' +next).slideDown('medium');    next++;    $("body").on("click", "#remove-truefalse", function () {
        $(this).closest("div").remove();
    });
}*/
























var correctanswer = 1;
var nextoptions=0;
$('#addQuestionCorrectanswer').click(function(){
    length_question ++;
    var question = {}
    question.total_option = 0
    question.id_correct_answer = 0
    question_option.push(question)
//    validateCorrectAnswer()
    var section = '<br/><div class="row-section" id="correctanswertype'+correctanswer+'"><div id="sectionquestion'+correctanswer+'">'+
        '<button id="remove-correctanswer'+correctanswer+'" type="button" class="removeQuestion close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
        '<div id="option-correctanswer'+nextoptions+'"><div><label>Question '+correctanswer+'</label></div>'+
        '<div><textarea id="question-correctanswer'+correctanswer+'" type="text" class="textarea-question"'+
        'placeholder="Enter the question"></textarea></div>'+
        '<div><button onclick="tambahOpsion('+nextoptions+')" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-plus" title="Close"></span></button></div>'+
        '</div><br/></div>'

    nextoptions++;

    $('#section-correctanswer').append(section);
    correctanswer++;

    $('div .removeQuestion').click (function () {
        $(this).parent().remove();
    });

});

function setCorrectAnswer(questionId, optionId) {
    question_option[questionId]['id_correct_answer']  = optionId
    //console.log('set correct answer'+ question_option[questionId]['id_correct_answer'] )
    if(question_option[questionId]['id_correct_answer']  == 2)
    {
        alert ('correct answer can not be double')
    }
}

var tambahOpsi = 1;
var question_option = []

function tambahOpsion(options)
{
    if(question_option[options]['total_option'] > 0) {
        question_option[options]['total_option']  = question_option[options]['total_option'] + 1
    } else{
        question_option[options]['total_option'] = 1
    }

    //console.log("total options "+question_option[options]['total_option'])

    $('#option-correctanswer'+options).append( '<br/><br/><div><button id="hapusopsiCa" type="button" class="removeopsi close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
        '<div><label>Option '+question_option[options]['total_option']+'</label></div>'+
        '<div id="boxoptioncs'+tambahOpsi+'" class="boxoption"><div id="imageoptioncs'+tambahOpsi+'" class="imageoption">'+
        '<div id="inputoptioncs'+(tambahOpsi)+'" class="inputoption">'+
        '<input type="file" id="viewImageCorrectAnswer'+tambahOpsi+'" onchange="viewImageCorrectAnswer('+(tambahOpsi+1)+')"/>'+
        '<img id="viewImage" src="" />'+
        '<input id="question'+(options+1)+'-option'+question_option[options]['total_option']+'" class="textoption-correctanswer" type="text" placeholder=" Answer Text"/></div>'+
        '<div id="correctoptioncs'+tambahOpsi+'" class="correctoption"><label>Correct Answer</label>'+
        '<input id="checkboxanswer'+tambahOpsi+'" type="checkbox" class="icheckbox_flat-blue" onclick="setCorrectAnswer('+options+','+question_option[options]['total_option']+')"/></div></div>')

    tambahOpsi++;

    $('div .removeopsi').click (function () {
        $(this).parent().remove();
    });
}


$(document).on("change", "#imageoption-correctanswer", function(oEvent) {

    var file = oEvent.target.files[0];

    if (!file.type.match('image.*')) {
        alert("Tidak ada attach image");
    }else{
        var readerURL = new FileReader();

        readerURL.onload = function(){
            $('#viewImage').attr('src', readerURL.result);
            $('#viewImage').attr('width', '250px');
            $('#viewImage').attr('height', '230px');
            return true;
        };

        readerURL.readAsDataURL(file);
    }
});

function viewImageCorrectAnswer(images) {
    var files = $('#imageoption-correctanswer'+images)[0].files;
    if (!files[0].type.match('image.*')) {
        alert("There is no image");
    }else{
        var readerURL = new FileReader();
        readerURL.onload = function(files){
            $('#viewImage'+images).attr('src', files.target.result);
            $('#viewImage'+images).attr('width', '250px');
            $('#viewImage'+images).attr('height', '230px');
            return true;
        };
        readerURL.readAsDataURL(files[0]);
    }
    alert('hi')
}

var personality = 1;
var optionsps = 1;

$('#addpersonality').click(function()
{
    length_question++;
    var question = {}
    question.total_option = 0
    question_option.push(question)
    //console.log(length_question)
    var sectionps = '<br/><div class="row-section" id="question-personality'+personality+'">'+
        '<div><button id="removepersonality'+personality+'" type="button" class="removequestion-personality close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button><label>Question '+personality+'</label>'+
        '</div><div><textarea id="questionpersonality'+personality+'" type="text" class="textarea-question" placeholder="Enter the question">'+
        '</textarea></div><div><label>Option: </label></div>'+
        '<div><button onclick="addOptionText('+optionsps+')" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-plus"></span></button>'+
        '</div></div></br>';

    optionsps++;

    $('#section-personality').append(sectionps);
    personality++;

    $('div .removequestion-personality').click (function () {
        $(this).parent().remove();
    });

});

var optionsTextps = 1;
var optionsText = 1;
function addOptionText(optionsText)
{

    if(question_option[optionsText-1]['total_option'] > 0) {
        question_option[optionsText-1]['total_option']  = question_option[optionsText-1]['total_option'] + 1
    } else {
        question_option[optionsText-1]['total_option'] = 1
    }
    //console.log("total options "+question_option[optionsText-1]['total_option'])

    $('#question-personality'+optionsText).append('<div><button id="removeoption-personality" type="button" class="removeopsips close" data-dismiss="modal" aria-hidden="true">'+
        '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
        '<input id="scoreQuestion'+(optionsTextps)+'-option'+question_option[optionsText-1]['total_option']+'" class="inputscore" type="number" placeholder="Score"/>'+
        '<input id="question'+(optionsText)+'-option'+question_option[optionsText-1]['total_option']+'" type="text" class="textoption" placeholder="Text Option"/></div>')

    $('div .removeopsips').click (function () {
        $(this).parent().remove();
    });
}


$('.textarea-question').on('keydown', function(e){
    if(e.which == 13) {e.preventDefault();}
}).on('input', function(){
    $(this).height(1);
    var totalHeight = $(this).prop('scrollHeight') - parseInt($(this).css('padding-top')) - parseInt($(this).css('padding-bottom'));
    $(this).height(totalHeight);
});


$(document).on("change", "#imageResult", function(oEvent) {
    var file = oEvent.target.files[0];

    if (!file.type.match('image.*')) {
        alert("Tidak ada attach image");
    }else{
        var readerURL = new FileReader();

        readerURL.onload = function(){
            $('#previewing').attr('src', readerURL.result);
            $('#previewing').attr('width', '250px');
            $('#previewing').attr('height', '230px');
            return true;
        };

        readerURL.readAsDataURL(file);
    }
});

function loadResultFirst() {
    var id = 0;
    var result = '<div class="form-group-lg"><div class="row-section"><div><label>Result'+id+'</label>'+
        '<input type="file" id="imageResult'+id+'" onchange="previewingImage('+id+')"/>'+
        '<img id="previewing'+id+'" src=""/></div>'+
        '<div ><input type="text" id="titleGrade'+id+'" class="form-control" placeholder="Grade Title"/></div>'+
        '<br/><div><textarea id="gradeDescription'+id+'" rows="10" cols="96" placeholder="Grade Description">'+
        '</textarea></div><div><label> From : </label><input class="inputgrade" id="maxValue'+id+'" type="number" placeholder="Max"/>'+
        '<label> To </label> <input class="inputgrade" id="minValue'+id+'" type="number" placeholder="Min"/></div><br/></div></div>'

    $('#sectiongrade').append(result);
}

var grade = 0;

function addGrade()
{
    length_result++;
    console.log (length_result)

    g = grade + 1;
    var result = '<div class="form-group-lg"><div class="row-section"><div><label>Result '+g+'</label>'+
        '<input type="file" id="imageResult'+g+'" onchange="previewingImage('+g+')"/>'+
        '<img id="previewing'+g+'" src=""/></div>'+
        '<div ><input type="text" id="titleGrade'+g+'" class="form-control" placeholder="Grade Title"/></div>'+
        '<br/><div><textarea id="gradeDescription'+g+'" rows="10" cols="104" placeholder="Grade Description">'+
        '</textarea></div><div><label> From : </label><input class="inputgrade" id="maxValue'+g+'" type="number" placeholder="Max"/>'+
        '<label> To </label> <input class="inputgrade" id="minValue'+g+'" type="number" placeholder="Min"/></div><br/></div></div>'

    $('#sectiongrade').append(result);
    g++
    grade++;

};

function previewingImage(viewImageResult) {
    var files = $('#imageResult'+viewImageResult)[0].files;
    if (!files[0].type.match('image.*')) {
        alert("Tidak ada attach image");
    }else{
        var readerURL = new FileReader();
        readerURL.onload = function(files){
            $('#previewing'+viewImageResult).attr('src', files.target.result);
            $('#previewing'+viewImageResult).attr('width', '250px');
            $('#previewing'+viewImageResult).attr('height', '230px');
            return true;
        };
        readerURL.readAsDataURL(files[0]);
    }
}




