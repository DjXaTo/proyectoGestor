package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class modelo extends conexion {

    public modelo() {

    }

    //Métodos productos
    public boolean listarProd() {
        return true;
    }

    public boolean aniadirProd(String nomb, Double precio) {
        try {
            String q = "INSERT INTO Productos (nombre, precio) VALUES ('" + nomb + "'," + precio + ")";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean modificarProd(String nomb, Double precio, String idpro) {
        try {    //creamos la sentencia sql para insertar un contacto

            String q = "UPDATE Productos SET nombre='" + nomb + "', precio=" + precio + "WHERE idproductos=" + idpro + "";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;     //si no salta ninguna excepcion se ha insertado el contacto
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    //Métodos proveedores
    public boolean listarProv() {
        return true;
    }

    public boolean aniadirProv(String id, String nomb, String dir, int tel) {
        try {
            String q = "INSERT INTO Proveedor (idProveedor, nombre, direccion, telefono) VALUES ('" + id + "','" + nomb + "','" + dir + "'," + tel + ")";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean modificarProv(String nomb, String dir, String id) {
        try {
            String q = "UPDATE Proveedores SET nombre='" + nomb + "', direccion='" + dir + "' where idProveedor='" + id + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;     //si no salta ninguna excepcion se ha insertado el contacto
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean eliminarProv(String idpro) {
        try {
            String q = "DELETE FROM Proveedores WHERE idproveedor = '" + idpro + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean asignarProdProv() {
        return true;
    }

    //Métodos clientes
    public boolean listarClientes() {
        return true;
    }

    public boolean aniadirClientes(String id, String nomb, int tel, String dir) {
        try {
            String q = "INSERT INTO Clientes (idCliente, nombre, telefono, direccion) VALUES ('" + id + "','" + nomb + "'," + tel + ",'" + dir + "')";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean modificarClientes(String dni, String nomb, String dir, String id) {
        try {
            String q = "UPDATE Clientes SET idCliente = '" + dni + "', nombre='" + nomb + "', direccion='" + dir + "' where idCliente='" + id + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;     //si no salta ninguna excepcion se ha insertado el contacto
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean eliminarClientes(String idcliente) {
        try {
            String q = "DELETE FROM Clientes WHERE idcliente = '" + idcliente + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    //Métodos presupuestos
    public boolean listarPres() {
        return true;
    }

    public boolean aniadirPres() {
        return true;
    }

    public boolean modificarPres(String nomb, String dir, String id) {
        try {
            String q = "UPDATE Presupuestos SET nombre='" + nomb + "', direccion='" + dir + "' where idProveedor='" + id + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;     //si no salta ninguna excepcion se ha insertado el contacto
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean eliminarPres(int presu) {
        try {
            String q = "DELETE FROM Presupuestos WHERE idPresu = " + presu;
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean generarProforma() {
        return true;
    }

    //Métodos pedidos
    public boolean listarPed() {
        return true;
    }

    public boolean aniadirPed(double precio, double pagado, double ppagar, int fin, int idPres, String notas) {
        try {
            String q = "INSERT INTO Pedidos (precio, pagado, por_pagar, finalizado, idPresupuestos, notas) VALUES (" + precio + "," + pagado + "," + ppagar + "," + fin +"," + idPres + ",'" + notas + "')";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean modificarPed(String nomb, String dir, String id) {
        try {
            String q = "UPDATE Pedidos SET nombre='" + nomb + "', direccion='" + dir + "' where idProveedor='" + id + "'";
            PreparedStatement ps = this.conectar().prepareStatement(q);
            ps.execute();
            ps.close();
            return true;     //si no salta ninguna excepcion se ha insertado el contacto
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean generarFactura() {
        return true;
    }

    //Tablas
    public DefaultTableModel getProducto() {
        DefaultTableModel tabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };
        return tabla;
    }

    public DefaultTableModel getClientes() {
        DefaultTableModel tabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };
        return tabla;
    }

    public DefaultTableModel getProveedores() {
        DefaultTableModel tabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };
        return tabla;
    }

    public DefaultTableModel getPresupuestos() {
        DefaultTableModel tabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };
        return tabla;
    }

    public DefaultTableModel getPedidos() {
        DefaultTableModel tabla = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };
        return tabla;
    }
}
