using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace capa_datos {
    public class Usuario {
        public string Nombre { get; set; }
        public string Contraseña { get; set; }
        public string Fecha { get; set; }
        public bool Tipo { get; set; }
        public string Telefono { get; set; }
        public string Email { get; set; }

        public Usuario(string nombre, string contraseña, string fecha, bool tipo, string telefono, string email) {
            Nombre = nombre;
            Contraseña = contraseña;
            Fecha = fecha;
            Tipo = tipo;
            Telefono = telefono;
            Email = email;
        }

        public Usuario() {
        }
    }
}
