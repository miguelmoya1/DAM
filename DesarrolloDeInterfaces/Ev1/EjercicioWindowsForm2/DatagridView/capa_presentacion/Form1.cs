using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace capa_presentacion {
    public partial class Form1 : Form {
        ErrorProvider error;
        public Form1() {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e) {
            error = new ErrorProvider();
        }

        private void textBox1_Validating(object sender, CancelEventArgs e) {
            if (textBox1.Text == "") {
                error.SetError(errorText, "El campo nombre es obligatorio");
                e.Cancel = true;
            }
        }

        private void textBox2_Validating(object sender, CancelEventArgs e) {
            if (textBox2.Text == "") {
                error.SetError(errorText, "El campo contraseña es obligatorio");
                e.Cancel = true;
            }
        }

        private void dateTimePicker1_Validating(object sender, CancelEventArgs e) {
            if (dateTimePicker1.Text == "") {
                error.SetError(errorText, "Tienes que introducir una fecha");
                e.Cancel = true;
            }
        }

        private void comboBox1_Validating(object sender, CancelEventArgs e) {
            if (comboBox1.Text == "") {
                error.SetError(errorText, "Debes especificar un tipo de usuario");
                e.Cancel = true;
            }
        }

        private void maskedTextBox1_Validating(object sender, CancelEventArgs e) {
            if (maskedTextBox1.Text == "") {
                error.SetError(errorText, "El campo telefono es obligatorio");
                e.Cancel = true;
            }
        }

        private void maskedTextBox2_Validating(object sender, CancelEventArgs e) {
            if (maskedTextBox2.Text == "") {
                error.SetError(errorText, "El campo email es obligatorio");
                e.Cancel = true;
            }
        }
    }
}
