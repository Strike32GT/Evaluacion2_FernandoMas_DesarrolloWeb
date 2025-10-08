fetch('/api/pacientes')
    .then(response => response.json())
    .then(pacientes => {
        const tbody = document.getElementById('pacientes-body');
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
    });