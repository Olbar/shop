// jQuery(document) - $(document)
// $(document).ready(function() {});

$(document).ready(() => {

    // object - '', [], {}, true, 3

    // button.btn   - tag button with class 'btn'
    // #feedback     - id (search by id)
    // .btn         - search by class

    // $('#send-button').on('click', function() {});
    $('#send-button').on('click', sendFeedback);

});

function sendFeedback() {
    // var
    // let
    // const
    const text = $('#feedback').val(); // get value

    // ==
    // !=
    // ===
    // !==

    // undefined
    // null
    if (text) {
        sendFeedbackToServer(text);
        renderFeedback(text);
    }
}

function renderFeedback(feedback) {
    const tag = `<div class="wc-feedback">${feedback}</div>`; // '<div class="wc-feedback">Text</div>'
    $('#feedback-box').append($(tag));

    $('#feedback').val(''); // set value
}

function sendFeedbackToServer(text) {
    // item id
    const feedbackData = {
        text: text,
        itemId: $('#item-header').attr('item-id') // get attribute value
        // set attribute value: $('#item-header').attr('item-id', 'value')
    };

    // AJAX
    $.ajax({
        url: '/items/' + feedbackData.itemId + '/feedback',  // /items/1/feedback
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(feedbackData)
        // deprecated
        // success: function(response) {
        //
        // },
        // error: function(response) {
        //
        // }
    }).done((resp) => {
        console.log('success');
    }).fail((resp) => {
        console.log('fail');
    });

    // when function will be done, then function2 executes
    // $.when(function1]() {}).done(function2() {})

}