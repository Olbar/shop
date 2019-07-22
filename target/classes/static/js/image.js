$(document).ready(() => {

    let filename;
    $('#image-input').on('change', function(e) {
        console.log(e, 'e');
        const reader = new FileReader();
        const preview = document.querySelector('#image-viewer');
        reader.onload = function(file) {
            $('#image-input-data').val(reader.result);
            preview.src = reader.result;
        };

        if (e.target.files[0]) {
            filename =  e.target.files[0].name;
            reader.readAsDataURL(e.target.files[0]);
        }

    });

    $('#image-submit').on('click', (e) => {
        let fileAsString = $('#image-input-data').val();
        const specialInfo = 'data:image/jpeg;base64,';

        fileAsString = fileAsString.replace(specialInfo, '');


  const userData = {
        userId: $('.user').attr('item-id')// get attribute value
    };


        $.ajax({
            url: '/user_details/'+userData.userId,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify({ filename: filename, file: fileAsString })
        })
            .done(() => {console.log('success');location.reload();})
            .fail(() => { console.log('fail'); });
    });

});