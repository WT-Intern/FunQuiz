var next = 1;
function addQuestion(){
    var n = next + 1;

    var isi ='<div class = "form-group-md'+next+'">';

    isi += '<br/><div class="row-section" id="section-truefalse'+n+'">'+
    '<button id="remove-truefalse" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
    '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
    '<div><label>Question'+n+'</label></div><div>'+
    '<textarea id="question-truefalse'+n+'" type="text" class="textarea-question" placeholder="Enter the question"></textarea>'+
    '</div><div><label>Option</label></div><div><input id="checkboxtrue'+n+'" type="checkbox" class="radio icheckbox_flat-blue" value="1" name="test[1][]" />'+
    '<input id="optiontrue'+n+'" type="text" class="textoption" value="True"/></div>'+
    '<div><input id="checkboxfalse'+n+'" type="checkbox" class="radio icheckbox_flat-blue" value="1" name="test[1][]" />'+
    '<input id="optionfalse'+n+'" type="text" class="textoption" value="False"/></div></div></div>';

    isi += '</div>';

    $('#addquestion').append(isi);
    $('#addquestion' +next).slideDown('medium');

    $("body").on("click", "#remove-truefalse", function () {
            $(this).closest("div").remove();
    });
}


$("input:checkbox").click(function() {
    if ($(this).is(":checked")) {
        var group = "input:checkbox[name='" + $(this).attr("name") + "']";
        $(group).prop("checked", false);
        $(this).prop("checked", true);
    } else {
        $(this).prop("checked", false);
    }
});

var correctanswer = 1;
var options=1;
 $('#addcorrectanswer').click(function(){

    var section = '<br/><div class="row-section" id="correctanswertype'+correctanswer+'"><div id="sectionquestion'+correctanswer+'">'+
                  '<button id="remove-correctanswer'+correctanswer+'" type="button" class="removeQuestion close" data-dismiss="modal" aria-hidden="true">'+
                  '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
                  '<div id="option-correctanswer'+options+'"><div><label>Question '+correctanswer+'</label></div>'+
                  '<div><textarea id="question-correctanswer'+correctanswer+'" type="text" class="textarea-question"'+
                  'placeholder="Enter the question"></textarea></div>'+
                  '<div><button onclick="tambahOpsion('+options+')" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
                  '<span class="glyphicon glyphicon-plus" title="Close"></span></button></div>'+
                  '</div><br/></div>'

                    options++;

                  $('div .removeQuestion').click (function () {
                    	$(this).parent().remove();
                  });
  $('#section-correctanswer').append(section);

       correctanswer++;
});

 var tambahOpsi = 1;
 function tambahOpsion(options){

     $('#option-correctanswer'+options).append( '<br/><br/><div><button id="hapusopsiCa" type="button" class="removeopsi close" data-dismiss="modal" aria-hidden="true">'+
     '<span class="glyphicon glyphicon-remove" title="Close"></span></button>'+
     '<div><label>Option '+(tambahOpsi)+'</label></div>'+
     '<div id="boxoptioncs'+(tambahOpsi)+'" class="boxoption"><div id="imageoptioncs'+(tambahOpsi)+'" class="imageoption">'+
     '<button id="imageoption-correctanswer'+(tambahOpsi)+'" type="button" class="close" aria-hidden="true">'+
     '<span class="glyphicon glyphicon-picture"></span></button></div>'+
     '<div id="inputoptioncs'+(tambahOpsi)+'" class="inputoption">'+
     '<input id="textoption-correctanswercs'+(tambahOpsi)+'" class="textoption-correctanswer" type="text" placeholder=" Answer Text"/></div>'+
     '<div id="correctoptioncs'+(tambahOpsi)+'" class="correctoption"><label>Correct Answer</label>'+
     '<input id="checkboxanswer'+tambahOpsi+'" type="checkbox" class="icheckbox_flat-blue"/></div></div>')

    if(tambahOpsi==6){
        tambahOpsi=0;
    }
    tambahOpsi++;

    $('div .removeopsi').click (function () {
            $(this).parent().remove();
    });
 }

var personality = 1;
var optionsps = 1;
$('#addpersonality').click(function(){
    var sectionps = '<br/><div class="row-section" id="question-personality'+personality+'">'+
                    '<div><button id="removepersonality'+personality+'" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
                    '<span class="glyphicon glyphicon-remove" title="Close"></span></button><label>Question '+personality+'</label>'+
                    '</div><div><textarea id="questionpersonality'+personality+'" type="text" class="textarea-question" placeholder="Enter the question">'+
                    '</textarea></div><div><label>Option: </label></div>'+
                    '<div><button onclick="addOptionText('+optionsps+')" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
                    '<span></span></button><button onclick="addOptionImage('+optionsps+')" type="button" class="close" data-dismiss="modal" aria-hidden="true">'+
                    '<span class="glyphicon glyphicon-plus"></span></button></div></div>';

                    optionsps++;
     $('#section-personality').append(sectionps);
                    personality++;
});

var optionsTextps = 1;
function addOptionText(optionsText){
    $('#question-personality'+optionsps).append('<div></div><div><input id="scoreTextpersonality'+optionsTextps+'" class="inputscore" type="number" placeholder="Score"/>'+
    '<input type="text" class="textoption" placeholder="Text Option"/></div>')

    optionsTextps++;
}

var optionsImageps = 1;
function addOptionImage(optionsImage){
    $('#question-personality'+optionsImage).append('<br/></div><div><input id="scoreTextpersonality'+optionsTextps+'" class="inputscore" type="number" placeholder="Score"/>'+
    '<input type="text" class="textoption" placeholder="Text Option"/></div>')
    optionsImageps++;
}

$('#text-question').on('keydown', function(e){
    if(e.which == 13) {e.preventDefault();}
}).on('input', function(){
    $(this).height(1);
    var totalHeight = $(this).prop('scrollHeight') - parseInt($(this).css('padding-top')) - parseInt($(this).css('padding-bottom'));
    $(this).height(totalHeight);
});


  if (window.File && window.FileList && window.FileReader) {

    $("#files").on("change", function(e) {
      var files = e.target.files,
        filesLength = files.length;
      for (var count_file = 0; count_file < filesLength; count_file++) {
        var index_file = files[count_file]
        var fileReader = new FileReader();
        fileReader.onload = (function(e) {
          var file = e.target;
          $("<span class=\"file_image\">" +
            "<img class=\"imageThumb\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
            "<br/><span class=\"remove\">Remove image</span>" +
            "<div id=\"correct-options\"><label>Correct Answer</label><input id=\"checkcorrect\" type=\"checkbox\" class=\"icheckbox_flat-blue\"/></div>" +
            "</span>").insertAfter("#files");
          $(".remove").click(function(){
            $(this).parent(".file_image").remove();
          });
        });
        fileReader.readAsDataURL(index_file);
      }
    });
  } else {
    alert("Cannot attach file")
  }
