using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosPOO {
    class Vector3D {
        protected double x { get; set; }
        protected double y { get; set; }
        protected double z { get; set; }

        public bool Igual(Vector3D v) {
            return (v.x == this.x && v.y == this.y && v.z == z);
        }

        public double NormaMax() {
            return Math.Sqrt((x * x) + (y * y) + (z * z));
        }
    }
}
