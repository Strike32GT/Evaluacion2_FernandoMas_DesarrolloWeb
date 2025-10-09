document.addEventListener('DOMContentLoaded', async () => {
    const main = document.getElementById('contenido');

    try {
        // Carga la vista parcial (HTML) de pacientes
        const response = await fetch('/pacientes/contenido');
        if (!response.ok) throw new Error('No se pudo cargar el contenido');

        const html = await response.text();
        main.innerHTML = html;

        // Después de insertar el HTML, ejecuta el JS que llena la tabla
        const script = document.createElement('script');
        script.src = '/listar-body.js';
        document.body.appendChild(script);

    } catch (error) {
        console.error('Error cargando contenido:', error);
        main.innerHTML = '<p style="color:red;">Error al cargar la página de pacientes.</p>';
    }
});
