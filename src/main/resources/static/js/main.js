
$(document).ready(function (){
    $('.mBtn').on('click', function(e){
        e.preventDefault();
        const href = $(this).attr('href');
        $.get(href, function (deal, status){
            $('#modalId').val(deal.id)
            $('#modalSurname').val(deal.card.surname)
            $('#modalRating').val(deal.card.overall)
            $('#modalType').val(deal.card.cardType)
            $('#modalBp').val(deal.buyingPrice)
            $('#modalSp').val(deal.sellingPrice)
        })
        $('#editModal').modal('show');




    });
});

$(document).ready(function () {
    const form = $('#updateForm');
    form.submit(function (e){
        e.preventDefault();
        const data = {
            card: {
                surname: $("#modalSurname").val(),
                overall: $("#modalRating").val(),
                cardType: $("#modalType").val()
            },
            buyingPrice: $("#modalBp").val(),
            sellingPrice: $("#modalSp").val(),
        };

        $.ajax({
            type: 'PUT',
            url:"/deals/update/" + $('#modalId').val(),
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (data, textStatus, xhr) {
                console.log(data);
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log('Error in Operation');
                console.log(this.url)
                $('#editModal').modal('hide')
                window.location.reload();
            },
        })

    });

});