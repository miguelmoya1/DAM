using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using SQLite;

namespace capa_datos {
    [Table("Peliculas")]
    public class Pelicula : IComparable<Pelicula> {
        // Propiedades
        [PrimaryKey, AutoIncrement]
        public int Id { get; set; }
        public string Titulo { get; set; }
        public string Descripcion { get; set; }
        public int Duracion { get; set; }
        public int Edad { get; set; }

        // Constructor vacio. OBLIGATORIO para poder usar esta clase como TableQuery
        public Pelicula() { }

        public Pelicula(string titulo, string descripcion, int duracion, int edad) {
            Titulo = titulo;
            Descripcion = descripcion;
            Duracion = duracion;
            Edad = edad;
        }

        public int CompareTo(Pelicula p) => p.Titulo.CompareTo(Titulo);
    }
}
