$(function() {
  $("#anoLancamento").datepicker({
    changeYear: true,
    showButtonPanel: true,
    dateFormat: 'yy',
    yearRange: "1888:2100",
    onClose: function(dateText, inst) {
      // Quando fechar, pega o ano selecionado
      var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
      $(this).datepicker('setDate', new Date(year, 0, 1));
    }
  });

  // Modifica o calendário para mostrar só o ano (esconde mês e dias)
  $("#anoLancamento").focus(function () {
    $(".ui-datepicker-month").hide();
    $(".ui-datepicker-calendar").hide();
  });
});
