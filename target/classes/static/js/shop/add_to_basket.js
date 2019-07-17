// jQuery(document) - $(document)
// $(document).ready(function() {});

$(document).ready(() => {

    // $('#send-button').on('click', function() {});
    $('.add_basket').on('click', sendActionToServer);

});

function sendActionToServer(event) {
    // item id
  const itemData = {
        itemId: $(event.target).attr('item-id')// get attribute value
    };

    $.ajax({
        url: '/items/' + itemData.itemId + '/basket',  // /items/1/basket
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(itemData)

    })
            .done(() => {console.log('success')})
            .fail(() => { console.log('fail'); });
}