document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-crear-medico");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nuevoMedico = {
            nombres: document.getElementById("nombre").value,
            apellidos: document.getElementById("apellidos").value,
            colegiatura: document.getElementById("colegiatura").value,
            telefono: document.getElementById("telefono").value,
            correo: document.getElementById("correo").value,
            estado: document.getElementById("estado").value
        };

        const response = await fetch("/medicos", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(nuevoMedico)
        });

        if (response.ok) {
            alert("✅ Medico creado con éxito");
            window.location.href = "/medicos"; // vuelve al listado
        } else {
            alert("❌ Error al crear medico");
        }
    });
});
