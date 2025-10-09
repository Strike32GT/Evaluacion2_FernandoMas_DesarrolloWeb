document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-crear-paciente");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nuevoPaciente = {
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

        const response = await fetch("/pacientes", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(nuevoPaciente)
        });

        if (response.ok) {
            alert("✅ Paciente creado con éxito");
            window.location.href = "/pacientes"; // vuelve al listado
        } else {
            alert("❌ Error al crear paciente");
        }
    });
});
