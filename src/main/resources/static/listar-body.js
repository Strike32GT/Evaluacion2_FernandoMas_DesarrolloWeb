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
                <td>${paciente.fechaNacimiento}</td>
                <td>${paciente.estado}</td>
                <td>
                    <a href="/pacientes/editar/${paciente.idPaciente}" class="btn-editar">Editar</a>
                    <button class="btn-eliminar" data-id="${paciente.idPaciente}">Eliminar</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        tbody.querySelectorAll('.btn-eliminar').forEach(btn =>{
            btn.addEventListener('click',async e=>{
                const id=e.target.dataset.id;
                if(confirm("Seguro que quieres eliminar?")){
                    try{
                        const response = await fetch(`/pacientes/${id}`, { method: 'DELETE' });
                        if(response.ok){
                            alert("Paciente eliminado correctamente");
                            location.reload();
                        }else{
                            alert("Error al eliminar el paciente")
                        }
                    }catch (error){
                        console.error("Error al eliminar: ",error);
                        alert("Error en la conexion al eliminar el paciente");
                    }
                }
            });
        });

    })
    .catch(error => {
        console.error('Error al cargar pacientes:', error);
        const tbody = document.getElementById('pacientes-body');
        tbody.innerHTML = '<tr><td colspan="5">No se pudieron cargar los pacientes.</td></tr>';
    });
