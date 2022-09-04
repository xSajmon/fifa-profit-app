
$(document).ready(function (){
    $('.mBtn').on('click', function(e){
        e.preventDefault();
        const href = $(this).attr('href');
        $.get(href, function (deal, status){
            $('#modalSurname').val(deal.card.surname)
            $('#modalRating').val(deal.card.overall)
            $('#modalType').val(deal.card.cardType)
            $('#modalBp').val(deal.buyingPrice)
            $('#modalSp').val(deal.sellingPrice)
        })

        $('#editModal').modal('show');

    });
});