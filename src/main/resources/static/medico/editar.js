// === Obtener el ID del médico desde la URL ===
const idMedico = window.location.pathname.split('/').pop();

// === Cargar datos del médico ===
fetch(`/medicos/${idMedico}`)
    .then(response => {
        if (!response.ok) throw new Error("No se pudo obtener el médico");
        return response.json();
    })
    .then(medico => {
        document.getElementById("idMedico").value = medico.idMedico;
        document.getElementById("nombre").value = medico.nombres;
        document.getElementById("apellidos").value = medico.apellidos;
        document.getElementById("colegiatura").value = medico.colegiatura;
        document.getElementById("telefono").value = medico.telefono;
        document.getElementById("correo").value = medico.correo;
        document.getElementById("estado").value = medico.estado;
    })
    .catch(err => console.error("Error cargando médico:", err));

// === Enviar los datos actualizados ===
document.getElementById("form-editar-medico").addEventListener("submit", async (e) => {
    e.preventDefault();

    const medico = {
        nombres: document.getElementById("nombre").value,
        apellidos: document.getElementById("apellidos").value,
        colegiatura: document.getElementById("colegiatura").value,
        telefono: document.getElementById("telefono").value,
        correo: document.getElementById("correo").value,
        estado: document.getElementById("estado").value
    };

    try {
        const response = await fetch(`/medicos/${idMedico}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(medico)
        });

        if (response.ok) {
            alert("Médico actualizado correctamente");
            window.location.href = "/medicos"; // volver al listado
        } else {
            alert("Error al actualizar el médico");
        }
    } catch (error) {
        console.error("Error en la conexión:", error);
        alert("Error de conexión");
    }
});
