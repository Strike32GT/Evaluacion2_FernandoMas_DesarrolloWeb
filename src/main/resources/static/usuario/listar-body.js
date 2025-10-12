fetch('/usuarios/data')
    .then(response => {
        if (!response.ok) throw new Error('Error al obtener usuarios');
        return response.json();
    })
    .then(usuarios => {
        const tbody = document.getElementById('usuarios-body');
        tbody.innerHTML = ''; // limpiar por si acaso

        usuarios.forEach((usuario, index) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${index + 1}</td>
                <td>${usuario.nombreUsuario}</td>
                <td>${usuario.rol}</td>
                <td>
                    <a href="/usuarios/editar/${usuario.idUsuario}" class="btn-editar">Editar</a>
                    <button class="btn-eliminar" data-id="${usuario.idUsuario}">Eliminar</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        tbody.querySelectorAll('.btn-eliminar').forEach(btn =>{
            btn.addEventListener('click',async e=>{
                const id=e.target.dataset.id;
                if(confirm("Seguro que quieres eliminar?")){
                    try{
                        const response = await fetch(`/usuarios/${id}`, { method: 'DELETE' });
                        if(response.ok){
                            alert("Usuario eliminado correctamente");
                            location.reload();
                        }else{
                            alert("Error al eliminar el usuario")
                        }
                    }catch (error){
                        console.error("Error al eliminar: ",error);
                        alert("Error en la conexion al eliminar el usuario");
                    }
                }
            });
        });

    })
    .catch(error => {
        console.error('Error al cargar usuarios:', error);
        const tbody = document.getElementById('usuarios-body');
        tbody.innerHTML = '<tr><td colspan="5">No se pudieron cargar los usuarios.</td></tr>';
    });
