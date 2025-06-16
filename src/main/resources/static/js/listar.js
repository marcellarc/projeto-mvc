document.addEventListener("DOMContentLoaded", function () {
  const deleteForms = document.querySelectorAll(".delete-form");
  const modal = document.getElementById("confirmModal");
  const confirmBtn = document.getElementById("confirmBtn");
  const cancelBtn = document.getElementById("cancelBtn");
  let currentForm = null; // Armazena o formulário que acionou o modal

  // Função para abrir o modal
  function openModal(form) {
    currentForm = form;
    modal.style.display = "flex"; // Exibe o modal
  }

  // Função para fechar o modal
  function closeModal() {
    modal.style.display = "none"; // Oculta o modal
    currentForm = null;
  }

  // Adiciona um evento de clique para cada formulário de exclusão
  deleteForms.forEach((form) => {
    form.addEventListener("submit", function (e) {
      e.preventDefault(); // Impede o envio imediato do formulário
      openModal(form); // Abre o modal de confirmação
    });
  });

  // Se o usuário confirmar, envia o formulário
  confirmBtn.addEventListener("click", function () {
    if (currentForm) {
      currentForm.submit(); // Envia o formulário armazenado
    }
    closeModal(); // Fecha o modal
  });

  // Se o usuário cancelar, apenas fecha o modal
  cancelBtn.addEventListener("click", closeModal);

  // Fecha o modal caso o usuário clique fora da caixa de confirmação
  window.addEventListener("click", (e) => {
    if (e.target === modal) {
      closeModal();
    }
  });
});
