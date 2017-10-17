using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using capa_negocio;
using capa_datos;


namespace capa_presentacion {
    public partial class Form1 : Form {
        private Negocio negocio;

        public Form1() {
            InitializeComponent();

            negocio = new Negocio();
            leer_cartelera();
        }

        private void button1_Click(object sender, EventArgs e) {
            int filas_almacenadas = 0;

            // Aqui realizariamos las validaciones de los campos del formulario

            // Envío los datos a la capa de negocio
            label_resultado.ForeColor = Color.Red;
            if (box_titulo.Text != "")
                if (Convert.ToInt32(box_duracion.Value) != 0)
                    filas_almacenadas = negocio.Añadir(box_titulo.Text,
                                      Convert.ToInt32(box_edad.Value),
                                      Convert.ToInt32(box_duracion.Value),
                                      box_descripcion.Text);
                else label_resultado.Text = "Error, la duración tiene que ser diferente de 0";
            else label_resultado.Text = "Error, el titulo no puede estar vacío";

            if (filas_almacenadas == 1) {
                label_resultado.ForeColor = Color.Black;
                label_resultado.Text = "La pelicula se almacenó en la base de datos";
                box_titulo.Text = "";
                box_edad.Value = 0;
                box_duracion.Value = 0;

                // relleno el datagrid de cartelera
                leer_cartelera();
            } else label_resultado.Text = "Error al almacenar la pelicula en la base de datos";
        }

        // Actualizo el valor del DataGrid de cartelera
        private void leer_cartelera() {
            int i = 0;
            List<Pelicula> aux;

            // Obtengo la lista de peliculas accediendo a la propiedad cartelera
            // del objeto negocio
            aux = negocio.cartelera;

            dataGridView1.Rows.Clear();
            while (i < aux.Count) {
                dataGridView1.Rows.Add();
                i++;
            }

            aux.Sort();

            i = 0;
            while (i < aux.Count) {
                dataGridView1.Rows[i + 1].Cells[0].Value = aux[i].Titulo;
                dataGridView1.Rows[i + 1].Cells[1].Value = aux[i].Duracion.ToString();
                i++;
            }
        }

        private void box_titulo_TextChanged(object sender, EventArgs e) {

        }
    }
}
