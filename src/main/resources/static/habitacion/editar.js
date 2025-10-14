// === Obtener el ID del médico desde la URL ===
const idHabitacion = window.location.pathname.split('/').pop();

// === Cargar datos del médico ===
fetch(`/habitacions/${idHabitacion}`)
    .then(response => {
        if (!response.ok) throw new Error("No se pudo obtener la habitacion");
        return response.json();
    })
    .then(habitacion => {
        document.getElementById("idHabitacion").value = habitacion.idHabitacion;
        document.getElementById("numero").value=habitacion.numero;
        document.getElementById("tipo").value = habitacion.tipo;
        document.getElementById("estado").value = habitacion.estado;
    })
    .catch(err => console.error("Error cargando habitacion:", err));

// === Enviar los datos actualizados ===
document.getElementById("form-editar-habitacion").addEventListener("submit", async (e) => {
    e.preventDefault();

    const habitacion = {
        numero: document.getElementById("numero").value,
        tipo: document.getElementById("tipo").value,
        estado: document.getElementById("estado").value
    };

    try {
        const response = await fetch(`/habitacions/${idHabitacion}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(habitacion)
        });

        if (response.ok) {
            alert("Habitacion actualizada correctamente");
            window.location.href = "/habitacions"; // volver al listado
        } else {
            alert("Error al actualizar la habitacion");
        }
    } catch (error) {
        console.error("Error en la conexión:", error);
        alert("Error de conexión");
    }
});
