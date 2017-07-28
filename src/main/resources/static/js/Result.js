/*! Result.js
 * ================
 * @Author  Bona Simanullang
 * @version 2.3.8
 * @license MIT <http://opensource.org/licenses/MIT>
 */
$(document).on("change", "#id_imatgeNewPeces", function(oEvent) {
    var file = oEvent.target.files[0];

    if (!file.type.match('image.*')) {
        alert("El archivo seleccionado no es una Imagen");
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

 var grade = 0;

 $('#buttongrade').click(function(){
        var uploadimage = '<input type="file" id="id_imatgeNewPeces"/><br/>'+grade;
        var previewimage = '<img id="previewing" src="" />'+grade;

        $('#sectiongrade').append('<div>'+uploadimage+''+previewimage+'</div><div ><input type="text" id="titlegrade" class="form-control" placeholder="Grade Title"/></div><br/><div><textarea id="textarea-grade" rows="10" cols="104" placeholder="Grade Description"></textarea></div><br/><div><label> From : </label><input class="input_grade" type="number" placeholder="Max"/><label> To </label> <input class="input_grade" type="number" placeholder="Min"/> </div><br/>')

       grade++;

 });


//   $("#addButton").click(function () {
//
// 	if(counter>10){
//             alert("Only 10 textboxes allow");
//             return false;
// 	}
//
// 	var newTextBoxDiv = $(document.createElement('div'))
// 	     .attr("id", 'imgupload' + counter);
//
// 	newTextBoxDiv.after().html('<div><input type="file' +counter+
// 	                           '"id="id_imatgeNewPeces'+counter+
// 	                           '"/><br/><img'
// 	                           '"id="previewing'+counter+ '"src="" /></div>');
//
// // 	      '<input type="text" name="textbox' + counter +
// // 	      '" id="textbox' + counter + '" value="" >');
// //http://www.mkyong.com/jquery/how-to-add-remove-textbox-dynamically-with-jquery/
// //http://zeering.in/Bzz2aeAIwjM=
// 	newTextBoxDiv.appendTo("#sectiongrade");
//
//
// 	counter++;
//      });

