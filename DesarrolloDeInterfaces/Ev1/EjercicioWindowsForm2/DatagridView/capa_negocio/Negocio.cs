using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using capa_datos;

namespace capa_negocio {
    public class Negocio {
        // atributos
        private BD _bd;
        protected List<Usuario> Usuarios { get; set; }


        public Negocio() {
            _bd = new BD();
            Usuarios = _bd.GetUsuarios();
        }

        public int Add(Usuario usuario) {
            int added;

            bool found = false;
            Usuarios.ForEach(user => {
                if (user.Nombre == usuario.Nombre) found = true;
            });
            if (found) return -1;

            added = _bd.Add(usuario);
            Usuarios = _bd.GetUsuarios();

            return added;
        }
    }
}
