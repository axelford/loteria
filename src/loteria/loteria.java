package loteria;

import java.awt.Color;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class loteria {
	public static String numeros() {
		List<Integer> numeros = new ArrayList<Integer>();
		String num = "";
		Random aleatorio = new Random();
		int al;
		while (numeros.size() < 6) {
			al = aleatorio.nextInt(61);
			if (numeros.contains(al) == false) {
				numeros.add(al);
			}
		}
		numeros.sort(null);
		for (int j = 0; j < 6; j++)
			num += String.valueOf(numeros.get(j)) + ' ';

		return num;
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Loteria");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b1 = new JButton("<html>nova combição</html>");
		JButton b2 = new JButton("Cancel");
		JPanel panel = new JPanel();
		JTextField escreve = new JTextField(18);
		escreve.setText(numeros());
		JList lista = new JList();
		List<JButton> botoes = new ArrayList<JButton>();
		escreve.setBackground(Color.DARK_GRAY);
		escreve.setForeground(Color.green);
		escreve.setFont(new Font("Arial", Font.ITALIC, 14));
		panel.setBackground(Color.DARK_GRAY);
		lista.add(escreve);

		lista.add(b1);
		lista.add(b2);
		while (lista.getComponentCount() > 1)
			panel.add(lista.getComponent(1));

		frame.add(panel);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e != null) {
					escreve.setText(numeros());
				}

			}

		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		});

		frame.setBounds(580, 240, 224, 102);
		frame.setMaximizedBounds(new Rectangle(580, 240, 224, 102));
		frame.setVisible(true);

	}

}
