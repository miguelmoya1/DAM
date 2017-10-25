using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Moya_Miguel_Ejercicio1 {
    public partial class Form1 : Form {
        public Form1() => InitializeComponent();

        private void Form1_Load(object sender, EventArgs e) => MessageBox.Show("Load event.");

        private void Form1_Shown(object sender, EventArgs e) => MessageBox.Show("Shown event.");

        private void Form1_Closing(object sender, CancelEventArgs e) => MessageBox.Show("Closing event.");

        private void Form1_FormClosed(object sender, FormClosedEventArgs e) => MessageBox.Show("Closed event.");

        private void textBox1_Enter(object sender, EventArgs e) => MessageBox.Show("Enter textbox1 event.");

        private void textBox2_Enter(object sender, EventArgs e) => MessageBox.Show("Enter textbox2 event.");

        private void textBox1_Validated(object sender, EventArgs e) => MessageBox.Show("Validated textbox1 event.");

        private void textBox2_Validated(object sender, EventArgs e) => MessageBox.Show("Validated textbox2 event.");

        private void textBox1_Validating(object sender, CancelEventArgs e) => MessageBox.Show("Validating textbox1 event.");

        private void textBox2_Validating(object sender, CancelEventArgs e) => MessageBox.Show("Validating textbox2 event.");

        private void textBox2_Leave(object sender, EventArgs e) => MessageBox.Show("Leave textbox2 event.");

        private void textBox1_Leave(object sender, EventArgs e) => MessageBox.Show("Leave textbox1 event.");
    }
}
