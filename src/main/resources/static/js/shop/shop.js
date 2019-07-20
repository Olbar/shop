// jQuery(document) - $(document)
// $(document).ready(function() {});

$(document).ready(() => {

    // $('#send-button').on('click', function() {});
    $('#send-button').on('click', sendFeedback);

});

function sendFeedback() {
    const text = $('#feedback').val(); // get value
    if (text) {
        sendFeedbackToServer(text);
        renderFeedback(text);
    }
}

function renderFeedback(feedback) {
    const tag = `<div class="wc-feedback">${feedback}</div>`; // '<div class="wc-feedback">Text</div>'
    $('#feedback-box').append($(tag)).animate({
        scrollTop: $(this).height()}, 'slow');
    $('#feedback').val(''); // set value
}

function sendFeedbackToServer(text) {
    // item id
    const feedbackData = {
        text: text,
        itemId: $('#item-header').attr('item-id') // get attribute value
    };

    $.ajax({
        url: '/items/' + feedbackData.itemId + '/feedback',  // /items/1/feedback
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(feedbackData)

    }).done((resp) => {
        renderFeedback(resp.text);
        location.reload();
    }).fail((resp) => {
        console.log('fail');
        location.reload();
    });
}