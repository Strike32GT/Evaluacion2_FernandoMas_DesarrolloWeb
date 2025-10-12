// === Obtener el id del paciente desde la URL ===
const idUsuario = window.location.pathname.split('/').pop();

// === Cargar datos del paciente ===
fetch(`/usuarios/${idUsuario}`)
    .then(response => {
        if (!response.ok) throw new Error("No se pudo obtener al usuario");
        return response.json();
    })
    .then(usuario => {
        document.getElementById("idUsuario").value = usuario.idUsuario;
        document.getElementById("user").value = usuario.nombreUsuario;
        document.getElementById("password").value = usuario.password;
        document.getElementById("rol").value = usuario.rol;
    })
    .catch(err => console.error("Error cargando usuario:", err));

// === Enviar datos actualizados ===
document.getElementById("form-editar-usuario").addEventListener("submit", async (e) => {
    e.preventDefault();

    const usuario = {
        nombreUsuario: document.getElementById("user").value,
        password: document.getElementById("password").value,
        rol: document.getElementById("rol").value,
    };

    try {
        const response = await fetch(`/usuarios/${idUsuario}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            alert("Usuario actualizado correctamente");
            window.location.href = "/usuarios"; // volver al listado
        } else {
            alert("Error al actualizar el usuario");
        }
    } catch (error) {
        console.error("Error en la conexión:", error);
        alert("Error de conexión");
    }
});
