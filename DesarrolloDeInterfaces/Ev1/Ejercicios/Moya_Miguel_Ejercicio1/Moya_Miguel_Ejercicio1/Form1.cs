﻿using System;
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
        public Form1() {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e) {
            MessageBox.Show("Load event.");
        }

        private void Form1_Shown(object sender, EventArgs e) {
            MessageBox.Show("Shown event.");
        }

        private void Form1_Closing(object sender, CancelEventArgs e) {
            MessageBox.Show("Shown event.");
        }
    }
}
