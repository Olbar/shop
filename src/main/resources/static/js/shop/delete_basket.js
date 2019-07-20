

$(document).ready(() => {

    $('.delete_basket').on('click', sendActionToServer);

});

function sendActionToServer(event) {
    // item id
  const basketData = {
        basketId: $(event.target).attr('item-id')// get attribute value
    };

    $.ajax({
        url: '/basket/' + basketData.basketId ,
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(basketData)
    })
            .done(() => {   location.reload();})
            .fail(() => { console.log('fail'); });
}