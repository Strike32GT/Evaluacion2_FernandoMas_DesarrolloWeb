document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-crear-habitacion");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nuevaHabitacion = {
            numero: document.getElementById("numero").value,
            tipo: document.getElementById("tipo").value,
            estado: document.getElementById("estado").value
        };

        const response = await fetch("/habitacions", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(nuevaHabitacion)
        });

        if (response.ok) {
            alert("✅ Habitacion creada con éxito");
            window.location.href = "/habitacions"; // vuelve al listado
        } else {
            alert("❌ Error al crear habitacion");
        }
    });
});
