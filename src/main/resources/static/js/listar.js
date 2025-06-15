window.addEventListener('DOMContentLoaded', () => {
  const container = document.getElementById("movieRow");
  const btnEsquerda = document.getElementById("btn-esquerda");
  const btnDireita = document.getElementById("btn-direita");

  btnEsquerda.addEventListener("click", () => {
    container.scrollBy({ left: -300, behavior: 'smooth' });
  });

  btnDireita.addEventListener("click", () => {
    container.scrollBy({ left: 300, behavior: 'smooth' });
  });
});
  