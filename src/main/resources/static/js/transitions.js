document.addEventListener("DOMContentLoaded", function () {
    document.body.classList.remove('preload');
    document.body.classList.add('loaded');

    const links = document.querySelectorAll('header a');
    links.forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            const url = this.href;
            document.body.classList.remove('loaded');
            document.body.classList.add('fade-out');
            setTimeout(() => {
                window.location.href = url;
            }, 500); // Tempo deve bater com o do CSS
        });
    });
});
