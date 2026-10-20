package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import entity.Computador;
import entity.Tipocomputador;
import model.ComputadorModel;
import model.TipoComputadorModel;

public class FrmRegistraComputador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtProcesador;
	private JTextField txtRAM;
	private JTextField txtDiscoDuro;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	private JComboBox<String> cboTipo;
	private JButton btnRegistrar;
	
	// Lista global para manejar los IDs de los tipos según la posición del combo
	private List<Tipocomputador> listaTipos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistraComputador frame = new FrmRegistraComputador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistraComputador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Computador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 10, 621, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(30, 77, 87, 19);
		contentPane.add(lblCodigo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(417, 78, 69, 12);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(30, 119, 87, 19);
		contentPane.add(lblModelo);
		
		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProcesador.setBounds(399, 118, 106, 19);
		contentPane.add(lblProcesador);
		
		JLabel lblRAM = new JLabel("RAM:");
		lblRAM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRAM.setBounds(30, 158, 69, 12);
		contentPane.add(lblRAM);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro:");
		lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiscoDuro.setBounds(390, 159, 106, 12);
		contentPane.add(lblDiscoDuro);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(30, 198, 87, 12);
		contentPane.add(lblPrecio);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(391, 198, 69, 12);
		contentPane.add(lblEstado);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(30, 247, 69, 19);
		contentPane.add(lblTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(101, 79, 141, 18);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(486, 77, 165, 18);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(101, 119, 147, 18);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtProcesador = new JTextField();
		txtProcesador.setBounds(499, 120, 152, 18);
		contentPane.add(txtProcesador);
		txtProcesador.setColumns(10);
		
		txtRAM = new JTextField();
		txtRAM.setBounds(85, 158, 125, 18);
		contentPane.add(txtRAM);
		txtRAM.setColumns(10);
		
		txtDiscoDuro = new JTextField();
		txtDiscoDuro.setBounds(490, 158, 133, 18);
		contentPane.add(txtDiscoDuro);
		txtDiscoDuro.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(101, 197, 125, 18);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(453, 197, 133, 18);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(85, 248, 179, 20);
		contentPane.add(cboTipo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrar.setBounds(305, 298, 133, 27);
		contentPane.add(btnRegistrar);

		// Llamamos al método para cargar los datos en el ComboBox al abrir la ventana
		cargarComboTipo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			handleBtnRegistrarActionPerformed(e);
		}
	}

	protected void handleBtnRegistrarActionPerformed(ActionEvent e) {
		try {
			// Validar campos vacíos
			if (txtCodigo.getText().trim().isEmpty() || 
				txtMarca.getText().trim().isEmpty() || 
				txtModelo.getText().trim().isEmpty() || 
				txtProcesador.getText().trim().isEmpty() || 
				txtRAM.getText().trim().isEmpty() || 
				txtDiscoDuro.getText().trim().isEmpty() || 
				txtPrecio.getText().trim().isEmpty() || 
				txtEstado.getText().trim().isEmpty()) {
				
				JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			// 1. Capturar los datos de las cajas de texto
			String codigo = txtCodigo.getText().trim();
			String marca = txtMarca.getText().trim();
			String modelo = txtModelo.getText().trim();
			String procesador = txtProcesador.getText().trim();
			String ram = txtRAM.getText().trim();
			String discoDuro = txtDiscoDuro.getText().trim();
			double precio = Double.parseDouble(txtPrecio.getText().trim());
			
			if (precio <= 0) {
				JOptionPane.showMessageDialog(this, "El precio debe ser mayor a cero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String estado = txtEstado.getText().trim();
			
			// Obtener el ID del tipo según la posición seleccionada en el ComboBox
			int indexTipo = cboTipo.getSelectedIndex();
			int idTipoComputador = listaTipos.get(indexTipo).getIdtipocomputador();

			// 2. Crear el objeto Computador
			Computador obj = new Computador();
			obj.setIdtipocomputador(idTipoComputador);
			obj.setCodigo(codigo);
			obj.setMarca(marca);
			obj.setModelo(modelo);
			obj.setProcesador(procesador);
			obj.setRam(ram);
			obj.setDisco_duro(discoDuro);
			obj.setPrecio(precio);
			obj.setEstado(estado);

			// 3. Enviar al Model para registrar en la base de datos
			ComputadorModel model = new ComputadorModel();
			int filas = model.insertarComputador(obj);

			if (filas > 0) {
				JOptionPane.showMessageDialog(this, "Computadora registrada exitosamente.");
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(this, "Error al registrar la computadora.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese un valor numérico válido para el precio.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cargarComboTipo() {
		TipoComputadorModel model = new TipoComputadorModel();
		listaTipos = model.listarTipoComputador();
		
		cboTipo.removeAllItems();
		for (Tipocomputador t : listaTipos) {
			cboTipo.addItem(t.getNombre());
		}
	}
	
	public void limpiarCampos() {
		txtCodigo.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtProcesador.setText("");
		txtRAM.setText("");
		txtDiscoDuro.setText("");
		txtPrecio.setText("");
		txtEstado.setText("");
		txtCodigo.requestFocus();
	}
}