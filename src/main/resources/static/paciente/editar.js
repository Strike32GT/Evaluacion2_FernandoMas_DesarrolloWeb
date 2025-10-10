// === Obtener el id del paciente desde la URL ===
const idPaciente = window.location.pathname.split('/').pop();

// === Cargar datos del paciente ===
fetch(`/pacientes/${idPaciente}`)
    .then(response => {
        if (!response.ok) throw new Error("No se pudo obtener el paciente");
        return response.json();
    })
    .then(paciente => {
        document.getElementById("idPaciente").value = paciente.idPaciente;
        document.getElementById("dni").value = paciente.dni;
        document.getElementById("nombres").value = paciente.nombres;
        document.getElementById("apellidos").value = paciente.apellidos;
        document.getElementById("fechaNacimiento").value=paciente.fechaNacimiento;
        document.getElementById("sexo").value = paciente.sexo;
        document.getElementById("direccion").value = paciente.direccion;
        document.getElementById("telefono").value = paciente.telefono;
        document.getElementById("correo").value = paciente.correo;
        document.getElementById("estado").value = paciente.estado;
    })
    .catch(err => console.error("Error cargando paciente:", err));

// === Enviar datos actualizados ===
document.getElementById("form-editar-paciente").addEventListener("submit", async (e) => {
    e.preventDefault();

    const paciente = {
        dni: document.getElementById("dni").value,
        nombres: document.getElementById("nombres").value,
        apellidos: document.getElementById("apellidos").value,
        fechaNacimiento: document.getElementById("fechaNacimiento").value,
        sexo: document.getElementById("sexo").value,
        direccion: document.getElementById("direccion").value,
        telefono: document.getElementById("telefono").value,
        correo: document.getElementById("correo").value,
        estado: document.getElementById("estado").value
    };

    try {
        const response = await fetch(`/pacientes/${idPaciente}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(paciente)
        });

        if (response.ok) {
            alert("Paciente actualizado correctamente");
            window.location.href = "/pacientes"; // volver al listado
        } else {
            alert("Error al actualizar el paciente");
        }
    } catch (error) {
        console.error("Error en la conexión:", error);
        alert("Error de conexión");
    }
});
