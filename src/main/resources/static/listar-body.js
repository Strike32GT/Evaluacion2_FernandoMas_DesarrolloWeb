fetch('/pacientes/data')
    .then(response => {
        if (!response.ok) throw new Error('Error al obtener pacientes');
        return response.json();
    })
    .then(pacientes => {
        const tbody = document.getElementById('pacientes-body');
        tbody.innerHTML = ''; // limpiar por si acaso

        pacientes.forEach((paciente, index) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${index + 1}</td>
                <td>${paciente.dni}</td>
                <td>${paciente.nombres}</td>
                <td>${paciente.apellidos}</td>
                <td>
                    <a href="/pacientes/editar/${paciente.idPaciente}" class="btn-editar">Editar</a>
                    <a href="/pacientes/eliminar/${paciente.idPaciente}" class="btn-eliminar">Eliminar</a>
                </td>
            `;
            tbody.appendChild(tr);
        });
    })
    .catch(error => {
        console.error('Error al cargar pacientes:', error);
        const tbody = document.getElementById('pacientes-body');
        tbody.innerHTML = '<tr><td colspan="5">No se pudieron cargar los pacientes.</td></tr>';
    });
