function getCountry(){
    jsRoutes.controllers.core.main.MainController.getActualCountry().ajax({
        success: function (data) {
            $("#tittleAndCOuntry").empty().append("CRUSARDI-"+data)
        },
        error: function (error) {
            $("#tittleAndCOuntry").empty().append("Error de autenticación")
        }
    });
}
function changeCountry(location){
    window.location.href="/sic/country/"+location;
}
function getLmatData(lmatCode) {
    jsRoutes.controllers.lmat.LmatController.getLmatData(lmatCode).ajax({
        success: function (data) {
            swal({
                title: '<strong>Información de las piezas</strong>',
                html:data,
                showCloseButton: false,
                showCancelButton: false,
                focusConfirm: false,
                confirmButtonText: 'Aceptar'
            })
        },
        error: function (error) {
            swal({
                type: 'error',
                title: 'Oops...',
                text: 'Algo esta mal, contacte al administrador del sistema',
            })
        }
    });
}
function applyLamtListFilters(){
    var filter=$("#listFilterText").val();
    window.location.href="/sic/lmat/quickSearch/"+filter;
}