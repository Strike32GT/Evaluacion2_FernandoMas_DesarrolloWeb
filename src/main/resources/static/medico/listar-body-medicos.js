// src/main/resources/static/medico/listar-body-medicos.js

fetch('/medicos/data')
    .then(response => {
        if (!response.ok) throw new Error('Error al obtener médicos');
        return response.json();
    })
    .then(medicos => {
        const tbody = document.getElementById('medicos-body');
        tbody.innerHTML = ''; // limpiar por si acaso

        medicos.forEach((medico, index) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${index + 1}</td>
                <td>${medico.nombres}</td>
                <td>${medico.apellidos}</td>
                <td>${medico.telefono ?? '-'}</td>
                <td>${medico.correo ?? '-'}</td>
                <td>${medico.estado}</td>
                <td>
                    <a href="/medico/editar.html?id=${medico.idMedico}" class="btn-editar">Editar</a>
                    <button class="btn-eliminar" data-id="${medico.idMedico}">Eliminar</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        // Manejo de eliminación
        tbody.querySelectorAll('.btn-eliminar').forEach(btn => {
            btn.addEventListener('click', async e => {
                const id = e.target.dataset.id;
                if (confirm("¿Seguro que deseas eliminar este médico?")) {
                    try {
                        const response = await fetch(`/medicos/${id}`, { method: 'DELETE' });
                        if (response.ok) {
                            alert("Médico eliminado correctamente");
                            location.reload();
                        } else {
                            alert("Error al eliminar el médico");
                        }
                    } catch (error) {
                        console.error("Error al eliminar: ", error);
                        alert("Error de conexión al eliminar el médico");
                    }
                }
            });
        });

    })
    .catch(error => {
        console.error('Error al cargar médicos:', error);
        const tbody = document.getElementById('medicos-body');
        tbody.innerHTML = '<tr><td colspan="9">No se pudieron cargar los médicos.</td></tr>';
    });
