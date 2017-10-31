using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;

namespace capa_datos {
    public class BD {
        private SQLiteConnection _bd;

        public BD() {
            // Creo la BD si no existia
            _bd = new SQLiteConnection("Usuario.db");

            _bd.CreateTable<Usuario>();
        }

        public int Add(Usuario user) {
            try {
                _bd.Insert(user);
            } catch (Exception e) {
                return 0;
            }
            return 1;
        }

        public List<Usuario> GetUsuarios() {
            int i;
            List<Usuario> c = new List<Usuario>(); ;

            // De esta forma leemos toda la tabla
            TableQuery<Usuario> aux = _bd.Table<Usuario>();

            // IMPORTANTE. Tambien podemos hecer una select
            //db.Query<Stock>("SELECT * FROM Cartelera");

            for (i = 0; i < aux.Count(); i++) {
                c.Add(aux.ElementAt(i));
            }

            return c;
        }
    }
}
