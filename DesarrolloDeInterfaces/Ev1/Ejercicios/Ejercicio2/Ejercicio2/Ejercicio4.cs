using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio2 {
    public partial class Ejercicio4 : Form {
        string selected = "HEX";
        public Ejercicio4() {
            InitializeComponent();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e) {
            selected = "HEX";
            label1.Text = Convert.ToInt64(textBox1.Text).ToString("X");
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e) {
            selected = "DEC";
            label1.Text = textBox1.Text;
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e) {
            selected = "OCT";
            label1.Text = Convert.ToInt64(textBox1.Text, 8) + "";
        }

        private void textBox1_TextChanged(object sender, EventArgs e) {
            switch (selected) {
                case "HEX":
                    label1.Text = Convert.ToInt64(textBox1.Text).ToString("X");
                    break;
                case "DEC":
                    label1.Text = textBox1.Text;
                    break;
                case "OCT":
                    label1.Text = Convert.ToInt64(textBox1.Text, 8) + "";
                    break;
            }
        }
    }
}
