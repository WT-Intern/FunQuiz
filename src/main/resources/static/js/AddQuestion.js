/*! AddQuestion.js
 * ================
 * @Author  Bona Simanullang
 * @version 2.3.8
 * @license MIT <http://opensource.org/licenses/MIT>
 */

var next = 1;
function tambahQuestion(){
    var n = next + 1;

    var isi ='<div class="box-body id="tambahquestion'+next+'">';

    isi += '<hr>';

    isi += '<div class = "form-group-sm"<div class="row-section"><button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button><div class="row-section" id="add_question"><div><label>Question'+n+'</label></div><div><input type="text" class="form-control" placeholder="Enter the question"/></div><div><label>Option</label></div><div"><input type="checkbox" class="icheckbox_flat-blue"/><input type="text" class="option_truefalse" value="True"/></div><div><input type="checkbox" class="icheckbox_flat-blue"/><input type="text" class="option_truefalse" value="False"/></div></div></div>';

    isi += '</div>';

    $('#tambahquestion').append(isi);
    $('#tambahquestion' +next).slideDown('medium');

    next++;
}

//      var item = $('#qtf:first').clone();
//      item.find('label:first').attr('id', id)
//          .html('Question ' + (count++));
//      item.appendTo('#correctanswer');
// });

//var counter = 1;
//$('#AddItem').click(function(){
//     e.preventDefault();
//    $('#'+qtf).html('<div class="row-section" id="question_correctanswer"><div><button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button><label id="Question[0]">Question 1</label></div><div><textarea id='"text-question" + (++counter) +' type="text" class="form-control" data-autosize-input='{ "space": 40 }' placeholder="Enter the question"></textarea></div></div><br/><div><label>Option</label></div><div id='"optionCorrectAnswer"+ (++counter) +' ><div id='"boxoption"+i'><div id="imageoption"><button type="button" class="close" aria-hidden="true"><span class="glyphicon glyphicon-picture"></span></button></div><div id='"inputoption"+ (++counter) +'><input id="text_asnwer" type="text" placeholder=" Answer Text"/>
//    '<button id="remove" type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button></div><div id='"correctoption"+i'><label>Correct Answer</label><input type="checkbox" class="icheckbox_flat-blue"/></div></div><div class="field hiddenContent" align="left" id="attachimage"><input type="file"  id='"files"+ (++counter) +' name="files[]" class="btn btn-primary button-animation rounded" /></div></div>');
//    appendTo('#correctanswer');
//});

//var itemIndex = 0;
//$()

//var itemIndex = 2;
//$(AddItem).click(function (e) { //on add input button click
//    e.preventDefault();
//    if (x < max_fields) { //max input box allowed
//        x++; //text box increment
//
//          $(wrapper).append('<div class="row-section" id="question_correctanswer'+ itemIndex++ +'"><div><button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button><label id="Question'+ itemIndex++ +'">Question 1</label></div><div><textarea id="text-question '+ itemIndex++ +'" type="text" class="form-control" data-autosize-input='{ "space": 40 }' placeholder="Enter the question"></textarea></div></div><br/><div><label>Option</label></div><div id="optionCorrectAnswer'+ itemIndex++ +'" ><div id="boxoption'+ itemIndex++ +'"><div id="imageoption'+ itemIndex++ +'"><button type="button" class="close" aria-hidden="true"><span class="glyphicon glyphicon-picture"></span></button></div><div id="inputoption'+ itemIndex++ +'"><input id="text_asnwer'+ itemIndex++ +'" type="text" placeholder=" Answer Text"/><button id="remove'+ itemIndex++ +'" type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button></div><div id="correctoption'+ itemIndex++ +'"><label>Correct Answer</label><input type="checkbox" class="icheckbox_flat-blue"/></div></div><div class="field hiddenContent" align="left" id="attachimage'+ itemIndex++ +'"><input type="file"  id="files'+ itemIndex++ +'" name="files[]" class="btn btn-primary button-animation rounded" /></div></div>');
//    }
//});

//var itemIndex = 1;
// $("#AddItem").click(function(e) {
//    e.preventDefault();
//    $("#correctanswer").append('<div class="row-section" id="question_correctanswer'+ itemIndex++ +'"><div><button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button><label id="Question'+ itemIndex++ +'">Question 1</label></div><div><textarea id="text-question '+ itemIndex++ +'" type="text" class="form-control" data-autosize-input='{ "space": 40 }' placeholder="Enter the question"></textarea></div></div><br/><div><label>Option</label></div><div id="optionCorrectAnswer'+ itemIndex++ +'" ><div id="boxoption'+ itemIndex++ +'"><div id="imageoption'+ itemIndex++ +'"><button type="button" class="close" aria-hidden="true"><span class="glyphicon glyphicon-picture"></span></button></div><div id="inputoption'+ itemIndex++ +'"><input id="text_asnwer'+ itemIndex++ +'" type="text" placeholder=" Answer Text"/><button id="remove'+ itemIndex++ +'" type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-trash" title="Close"></span></button></div><div id="correctoption'+ itemIndex++ +'"><label>Correct Answer</label><input type="checkbox" class="icheckbox_flat-blue"/></div></div><div class="field hiddenContent" align="left" id="attachimage'+ itemIndex++ +'"><input type="file"  id="files'+ itemIndex++ +'" name="files[]" class="btn btn-primary button-animation rounded" /></div></div>');
//  });



$('#imageoption').click(function(){
    $("#boxoption").hide();
    $("#backoption").show();
    $("#attachimage").show();
});
$('#backoption').click(function(){
    $("#boxoption").show();
    $("#backoption").hide();
    $("#attachimage").hide();
});

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
            "<div id=\"correct-options\"+j><label>Correct Answer</label><input id=\"checkcorrect\" type=\"checkbox\" class=\"icheckbox_flat-blue\"/></div>" +
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