function readURL(input) {
     $('.preview').show();
    $('#image_preview').hide();
    $('.preview').after('<center><img id="image_preview" src="#" alt="your image" style="display:none;"/></center');
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        $('#image_preview')
        .attr('src', e.target.result)
        .width(420)
        .height(310);
      };
      reader.readAsDataURL(input.files[0]);
    }
  }
  function getPreview(){
    $('.preview').hide();
    $('#image_preview').show();
    }

$('#optionType').change(function(){
    if ($(this)[0].options[0].selected) {
        $("#truefalse").hide();
        $("#correctanswer").hide();
        $("#personality").hide();
     }
    if ($(this)[0].options[1].selected) {
        $("#truefalse").show();
        $("#correctanswer").hide();
        $("#personality").hide();
     }
    if ($(this)[0].options[2].selected) {
        $("#truefalse").hide();
        $("#correctanswer").show();
        $("#personality").hide();
     }
     if($(this)[0].options[3].selected){
        $("#truefalse").hide();
        $("#correctanswer").hide();
        $("#personality").show();
     }
});