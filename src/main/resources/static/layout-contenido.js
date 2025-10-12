document.addEventListener('DOMContentLoaded', async () => {
    const main = document.getElementById('contenido');
    const path = window.location.pathname; // Ejemplo: /pacientes o /medicos

    // Detectar el módulo según la URL
    let modulo = '';
    if (path.includes('/pacientes')) modulo = 'paciente';
    else if (path.includes('/medicos')) modulo = 'medico';
    else if (path.includes('/usuarios'))modulo='usuario';
    else {
        console.warn('No se reconoce el módulo en la URL:', path);
        return;
    }

    try {
        // Cargar vista parcial (listar.html)
        const response = await fetch(`/${modulo}s/contenido`);
        if (!response.ok) throw new Error(`No se pudo cargar el contenido de ${modulo}s`);

        const html = await response.text();
        main.innerHTML = html;

        // Cargar dinámicamente el JS correspondiente al módulo
        const script = document.createElement('script');
        script.src = `/${modulo}/listar-body${modulo === 'medico' ? '-medicos' : ''}.js`;
        document.body.appendChild(script);

    } catch (error) {
        console.error(`Error cargando contenido de ${modulo}s:`, error);
        main.innerHTML = `<p style="color:red;">Error al cargar la página de ${modulo}s.</p>`;
    }
});
