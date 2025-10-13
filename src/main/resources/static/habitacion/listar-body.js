fetch('/habitacions/data')
    .then(response => {
        if (!response.ok) throw new Error('Error al obtener habitaciones');
        return response.json();
    })
    .then(habitacions => {
        const tbody = document.getElementById('habitaciones-body');
        tbody.innerHTML = ''; // limpiar por si acaso

        habitacions.forEach((habitacion, index) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${habitacion.numero}</td>
                <td>${habitacion.tipo}</td>
                <td>${habitacion.estado}</td>
                <td>
                    <a href="/habitacions/editar/${habitacion.idHabitacion}" class="btn-editar">Editar</a>
                    <button class="btn-eliminar" data-id="${habitacion.idHabitacion}">Eliminar</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        tbody.querySelectorAll('.btn-eliminar').forEach(btn =>{
            btn.addEventListener('click',async e=>{
                const id=e.target.dataset.id;
                if(confirm("Seguro que quieres eliminar?")){
                    try{
                        const response = await fetch(`/habitacions/${id}`, { method: 'DELETE' });
                        if(response.ok){
                            alert("Habitacion eliminada correctamente");
                            location.reload();
                        }else{
                            alert("Error al eliminar la habitacion")
                        }
                    }catch (error){
                        console.error("Error al eliminar: ",error);
                        alert("Error en la conexion al eliminar la habitacion");
                    }
                }
            });
        });

    })
    .catch(error => {
        console.error('Error al cargar habitaciones:', error);
        const tbody = document.getElementById('habitaciones-body');
        tbody.innerHTML = '<tr><td colspan="5">No se pudieron cargar las habitaciones.</td></tr>';
    });
