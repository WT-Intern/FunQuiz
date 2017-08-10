/*! Result.js
 * ================
 * @Author  Bona Simanullang
 */

 $(document).on("change", "#id_imatgeNewPeces", function(oEvent) {
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

 var grade = 0;
 $('#buttongrade').click(function(){

        var result = '<hr/><div class="form-group-lg"><div class="row-section"><div><label>Result '+(grade+2)+'</label>'+
                     '<input type="file" id="id_imatgeNewPeces'+(grade+2)+'" onchange="previewingImage('+(grade+2)+')"/>'+
                     '<img id="previewing'+(grade+2)+'" src=""/></div>'+
                     '<div ><input type="text" id="titlegrade'+(grade+2)+'" class="form-control" placeholder="Grade Title"/></div>'+
                     '<br/><div><textarea id="textarea-grade'+(grade+2)+'" rows="10" cols="110" placeholder="Grade Description">'+
                     '</textarea></div><div><label> From : </label><input class="inputgrade" type="number" placeholder="Max"/>'+
                     '<label> To </label> <input class="inputgrade" type="number" placeholder="Min"/></div><br/></div></div>'

        $('#sectiongrade').append(result);

       grade++;

 });

function previewingImage(wat) {
    var files = $('#id_imatgeNewPeces'+wat)[0].files;
        if (!files[0].type.match('image.*')) {
               alert("Tidak ada attach image");
        }else{
        var readerURL = new FileReader();
        readerURL.onload = function(files){
        $('#previewing'+wat).attr('src', files.target.result);
        $('#previewing'+wat).attr('width', '250px');
        $('#previewing'+wat).attr('height', '230px');
            return true;
        };
        readerURL.readAsDataURL(files[0]);
       }
 }



