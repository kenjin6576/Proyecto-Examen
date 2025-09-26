package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // ---- Look & Feel Nimbus (base moderna) ----
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ---- Configuración básica de la ventana ----
        setTitle("Asistencia de Alumnos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 248, 245)); // verde agua pastel
        setLayout(null);

        // ---- Fuentes más juveniles ----
        Font labelsFont = new Font("Verdana", Font.PLAIN, 15);
        Font buttonsFont = new Font("Verdana", Font.BOLD, 14);

        // ---- Panel con borde suave ----
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBounds(30, 30, 430, 220);
        panelDatos.setBackground(Color.WHITE);
        panelDatos.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180,180,180),1,true),
            "Datos del Estudiante"
        ));
        add(panelDatos);

        // ---- Labels y campos ----
        JLabel LNombre = new JLabel("Nombre:");
        LNombre.setBounds(20, 40, 80, 25);
        LNombre.setFont(labelsFont);
        panelDatos.add(LNombre);

        JTextField TNombre = new JTextField();
        TNombre.setBounds(110, 40, 280, 25);
        panelDatos.add(TNombre);

        JLabel LEdad = new JLabel("Edad:");
        LEdad.setBounds(20, 80, 80, 25);
        LEdad.setFont(labelsFont);
        panelDatos.add(LEdad);

        JTextField TEdad = new JTextField();
        TEdad.setBounds(110, 80, 80, 25);
        panelDatos.add(TEdad);

        JLabel LCarrera = new JLabel("Carrera:");
        LCarrera.setBounds(20, 120, 80, 25);
        LCarrera.setFont(labelsFont);
        panelDatos.add(LCarrera);

        JTextField TCarrera = new JTextField();
        TCarrera.setBounds(110, 120, 280, 25);
        panelDatos.add(TCarrera);

        // ---- Botón con color plano llamativo ----
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(buttonsFont);
        btnAgregar.setBackground(new Color(76, 175, 80)); // verde
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBounds(150, 170, 130, 35);

        // Efecto hover: oscurece cuando pasa el mouse
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(56, 142, 60));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(76, 175, 80));
            }
        });

        panelDatos.add(btnAgregar);

         // ---- Navegación con ENTER ----
        TNombre.addActionListener(e -> TEdad.requestFocus());
        TEdad.addActionListener(e -> TCarrera.requestFocus());
        TCarrera.addActionListener(e -> btnAgregar.requestFocus());

        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.setBackground(new Color(245, 245, 245));
        panelLista.setBounds(480, 30, 430, 630);
        add(panelLista);

        btnAgregar.addActionListener(e -> {
            String nombre = TNombre.getText();
            String edad = TEdad.getText();
            String carrera = TCarrera.getText();

            JPanel burbuja = new JPanel();
            burbuja.setLayout(new FlowLayout(FlowLayout.LEFT));
            burbuja.setBackground(new Color(200, 230, 255));
            burbuja.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
            burbuja.setMaximumSize(new Dimension(430, 80));

            JLabel texto = new JLabel(nombre + " " + edad + " " + carrera + " ");
            burbuja.add(texto);
            JButton btnEliminar = new JButton("✖");

        
            btnEliminar.setMargin(new Insets(1,4,1,4));

            burbuja.add(texto);
            burbuja.add(btnEliminar);

            btnEliminar.addActionListener( el -> {
                panelLista.remove(burbuja);
                panelLista.updateUI();
            });

            panelLista.add(burbuja);
            panelLista.updateUI();

            TNombre.setText("");
            TEdad.setText("");
            TCarrera.setText("");
            TNombre.requestFocus();
        });


        setVisible(true);
    }
}
